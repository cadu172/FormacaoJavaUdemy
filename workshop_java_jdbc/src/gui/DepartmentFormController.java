package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import db.DbException;
import gui.listeners.InterfaceDataChangeListener;
import gui.util.Alerts;
import gui.util.Constraints;
import gui.util.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.entities.Department;
import model.exceptions.ValidationException;
import model.services.DepartmentService;

public class DepartmentFormController implements Initializable {
	
	private List<InterfaceDataChangeListener> listeners = new ArrayList<InterfaceDataChangeListener>();
	
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
		
		try {		
			
			this.entity = this.getFormData();
			
			service.saveOrUpdate(this.entity);
			
			this.notifyListeners();
			
			Utils.getCurrentStage(event).close();

		}
		catch( ValidationException err ) {
			setErrorMessage(err.getErros());
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
		
		ValidationException errors = new ValidationException("");
		
		Department obj = new Department();
		
		obj.setId(Utils.tryParseToInt(txtId.getText()));
		obj.setName(txtName.getText());
		
		if (  obj.getName() == "" || obj.getName() == null ) {			
			errors.addError("name", "field name was null");			
		} 
		
		if ( errors.getErros().size() > 0 ) {
			throw errors;
		}
		
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
	
	public void subscribeDataChangeListener(@SuppressWarnings("exports") InterfaceDataChangeListener observer) {
		this.listeners.add(observer);
	}
	
	private void notifyListeners() {
		for ( InterfaceDataChangeListener item : listeners ) {
			item.onDataChange();
		}
	}
	
	private void setErrorMessage(Map<String, String> errors) {		
		if ( errors.containsKey("name") ) {
			labelErrorMessage.setText(errors.get("name"));
		}		
	}
	
}
