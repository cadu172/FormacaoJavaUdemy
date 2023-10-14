package gui;

import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.entities.Department;
import model.entities.Seller;
import model.exceptions.ValidationException;
import model.services.SellerService;

public class SellerFormController implements Initializable {
	
	private List<InterfaceDataChangeListener> listeners = new ArrayList<InterfaceDataChangeListener>();
	
	private Seller entity;
	
	private SellerService service;
	
	@FXML
	private TextField txtId;

	@FXML
	private TextField txtName;
	
	@FXML
	private TextField txtEmail;
	
	@FXML
	private DatePicker txtBirthDate;

	@FXML
	private TextField txtBaseSalary;	
	
	@FXML
	private TextField txtDepartmentId;
	
	@FXML
	private Button btSave;
	
	@FXML
	private Button btCancel;
	
	@FXML
	private Label labelErrorMessage;
	
	@FXML
	private Label labelErrorEmail;	
	
	@FXML
	private Label labelErrorBirthDate;
	
	@FXML
	private Label labelErrorBaseSalary;	
	
	
	
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
	
	private Seller getFormData() {
		
		ValidationException errors = new ValidationException("");
		
		Seller obj = new Seller();
		
		obj.setId(Utils.tryParseToInt(txtId.getText()));
		obj.setName(txtName.getText());
		obj.setEmail(txtEmail.getText());
		obj.setBirthDate(Date.from(txtBirthDate.getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
		obj.setBaseSalary(Utils.tryParseToDouble(txtBaseSalary.getText(), 0.00));
		obj.setDepartment(new Department(Utils.tryParseToInt(txtDepartmentId.getText()), null));
		
		if (  obj.getName() == "" || obj.getName() == null ) {			
			errors.addError("name", "field name was null");			
		} 
		
		if (  obj.getEmail() == "" || obj.getEmail() == null ) {			
			errors.addError("email", "field email was null");			
		} 		
		
		if (  obj.getBirthDate() == null ) {			
			errors.addError("birthdate", "field birthdate was null");			
		} 		

		if (  obj.getBaseSalary() == null ) {			
			errors.addError("basesalary", "field basesalary was null");			
		} 		
		
		if ( errors.getErros().size() > 0 ) {
			throw errors;
		}
		
		return obj;		
		
	}	
	
	private void initializeNodes() {
		Constraints.setTextFieldInteger(txtId);
		Constraints.setTextFieldMaxLength(txtName, 200);
		Constraints.setTextFieldDouble(txtBaseSalary);
		Constraints.setTextFieldMaxLength(txtEmail, 200);
		Utils.formatDatePicker(txtBirthDate, "dd/MM/yyyy");
	}

	public void setEntity(Seller entity) {
		this.entity = entity;
	}
	
	public void setService(SellerService service) {
		this.service = service;
	}

	public void updateFormData() {
		if ( entity == null ) {
			throw new IllegalStateException("entity nao foi instanciado");
		}
		txtId.setText(String.valueOf(entity.getId()));
		txtName.setText(entity.getName());
		txtEmail.setText(entity.getEmail());		
		txtBaseSalary.setText(String.format(Locale.US, "%.2f", entity.getBaseSalary()));
		
		if ( entity.getDepartment() != null ) {
			txtDepartmentId.setText(entity.getDepartment().getId().toString());
		}
		
		if ( ! ( entity.getBirthDate() == null ) ) {
			txtBirthDate.setValue(entity.getBirthDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
		}
		
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
		
		if ( errors.containsKey("email") ) {
			labelErrorEmail.setText(errors.get("email"));
		}	
		
		if ( errors.containsKey("birthdate") ) {
			labelErrorBirthDate.setText(errors.get("birthdate"));
		}
		
		if ( errors.containsKey("basesalary") ) {
			labelErrorBaseSalary.setText(errors.get("basesalary"));
		}		
		
	}
	
}
