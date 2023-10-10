package gui;

import java.net.URL;
import java.util.ResourceBundle;

import db.DbException;
import gui.util.Alerts;
import gui.util.Constraints;
import gui.util.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import model.entities.Department;
import model.services.DepartmentService;

public class DepartmentFormController implements Initializable {
	
	private Department entity;
	
	private DepartmentService service;
	
	@FXML
	private TextField txtId;

	@FXML
	private TextField txtName;
	
	@FXML
	private Button btSave;
	
	@FXML
	private Button btCancel;
	
	@FXML
	private Label labelErrorMessage;	
	
	@FXML
	private void onBtSaveAction(ActionEvent event) {
		
		if ( service == null ) {
			throw new IllegalStateException("service was null");
		}
		
		this.entity = this.getFormData();
		
		try {
			
			service.saveOrUpdate(this.entity);
			
			Utils.getCurrentStage(event).close();
		
		}
		catch (DbException e) {
			Alerts.showAlert("Error saving object", null, e.getMessage(), AlertType.ERROR);			
		}
	}	

	@FXML
	private void onBtCancelAction(ActionEvent event) {
		Utils.getCurrentStage(event).close();
	}		
	
	@Override
	public void initialize(URL source, ResourceBundle resource) {
		initializeNodes();
	}
	
	private Department getFormData() {
		
		Department obj = new Department();
		
		obj.setId(Utils.tryParseToInt(txtId.getText()));
		obj.setName(txtName.getText());
		
		return obj;
	}	
	
	private void initializeNodes() {
		Constraints.setTextFieldInteger(txtId);
		Constraints.setTextFieldMaxLength(txtName, 30);
	}

	public void setEntity(Department entity) {
		this.entity = entity;
	}
	
	public void setService(DepartmentService service) {
		this.service = service;
	}

	public void updateFormData() {
		if ( entity == null ) {
			throw new IllegalStateException("entity nao foi instanciado");
		}
		txtId.setText(String.valueOf(entity.getId()));
		txtName.setText(entity.getName());
	}
	
}
