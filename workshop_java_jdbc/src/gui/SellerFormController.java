package gui;

import java.net.URL;
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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.util.Callback;
import model.entities.Department;
import model.entities.Seller;
import model.exceptions.ValidationException;
import model.services.DepartmentService;
import model.services.SellerService;

public class SellerFormController implements Initializable {
	
	private List<InterfaceDataChangeListener> listeners = new ArrayList<InterfaceDataChangeListener>();
	
	private Seller entity;
	
	private SellerService service;
	private DepartmentService departmentService;
	
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
	private Button btSave;
	
	@FXML
	private Button btCancel;
	
	@FXML
	private Label labelErrorName;
	
	@FXML
	private Label labelErrorEmail;	
	
	@FXML
	private Label labelErrorBirthDate;
	
	@FXML
	private Label labelErrorBaseSalary;
	
	@FXML
	private Label labelErrorDepartment;	
	
	@FXML
	private ComboBox<Department> comboBoxDepartment;
	
	private ObservableList<Department> obsList;
	
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
		
		if ( txtName.getText() == null || txtName.getText().trim() == "" ) {
			errors.addError("name", "Name can´t be empty");		
		}
		else {
			obj.setName(txtName.getText());
		}
		
		if ( txtEmail.getText() == null || txtEmail.getText().trim() == "" ) {
			errors.addError("email", "E-Mail can´t be empty");		
		}
		else {
			obj.setEmail(txtEmail.getText());
		}
		
		if ( txtBirthDate.getValue() == null  ) {
			errors.addError("birthdate", "Birth Date can´t be empty");
		}
		else {
			obj.setBirthDate(Date.from(txtBirthDate.getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));	
		}
		
		if ( Utils.tryParseToDouble(txtBaseSalary.getText(), null) == null ) {
			errors.addError("basesalary", "Base Salary can´t be empty");	
		}
		else {
			obj.setBaseSalary(Utils.tryParseToDouble(txtBaseSalary.getText(), 0.00));
		}
		
		if ( comboBoxDepartment.getValue() == null ) {
			errors.addError("department", "Select a Department");
		}
		else {
			obj.setDepartment(comboBoxDepartment.getValue());
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
		
		initializeComboBoxDepartment();
	}

	public void setEntity(Seller entity) {
		this.entity = entity;
	}
	
	public void setServices(SellerService service, DepartmentService departmentService) {
		this.service = service;
		this.departmentService = departmentService;
	}

	public void updateFormData() {
		if ( entity == null ) {
			throw new IllegalStateException("entity nao foi instanciado");
		}
		txtId.setText(String.valueOf(entity.getId()));
		txtName.setText(entity.getName());
		txtEmail.setText(entity.getEmail());		
		txtBaseSalary.setText(String.format(Locale.US, "%.2f", entity.getBaseSalary()));
		
		if ( entity.getDepartment() == null ) {
			comboBoxDepartment.getSelectionModel().selectFirst();
		}
		else {
			comboBoxDepartment.setValue(entity.getDepartment());
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
		
		labelErrorName.setText(errors.containsKey("name") ? errors.get("name") : null );
		labelErrorEmail.setText(errors.containsKey("email") ? errors.get("email") : null );
		labelErrorBirthDate.setText(errors.containsKey("birthdate") ? errors.get("birthdate") : null );
		labelErrorBaseSalary.setText(errors.containsKey("basesalary") ? errors.get("basesalary") : null );
		labelErrorDepartment.setText(errors.containsKey("department") ? errors.get("department") : null );
	
	}
	
	public void loadAssociatedObjects() {
		
		if ( departmentService == null ) {
			throw new IllegalStateException("departmentService esta vazio ou nao foi instanciado");
		}
		
		List<Department> list = departmentService.findAll();
		obsList = FXCollections.observableArrayList(list);
		comboBoxDepartment.setItems(obsList);
		
	}
	
	private void initializeComboBoxDepartment() {
		Callback<ListView<Department>, ListCell<Department>> factory = lv -> new ListCell<Department>() {
			@Override
			protected void updateItem(Department item, boolean empty) {
				super.updateItem(item, empty);
				setText(empty ? "" : item.getName());
			}
		};
		comboBoxDepartment.setCellFactory(factory);
		comboBoxDepartment.setButtonCell(factory.call(null));
	}
	
}
