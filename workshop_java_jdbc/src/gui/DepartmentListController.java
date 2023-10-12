package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import gui.listeners.InterfaceDataChangeListener;
import gui.util.Alerts;
import gui.util.Utils;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.entities.Department;
import model.services.DepartmentService;

public class DepartmentListController implements Initializable, InterfaceDataChangeListener {
	
	private DepartmentService service;

	@FXML
	private Button BtnNew;	
	
	@FXML
	private TableView<Department> tableViewDepartament;
	
	@FXML
	private TableColumn<Department, Integer> tableColumnID;
	
	@FXML
	private TableColumn<Department, String> tableColumnName;	
	
	@FXML
	private TableColumn<Department, Department> tableColumnEDIT;	
	
	@FXML
	public void BtnNew_OnAction(@SuppressWarnings("exports") ActionEvent event) {
		
		Department newDepartment = new Department();
		
		Stage parentStage = Utils.getCurrentStage(event);		
		createDialogForm(newDepartment, "/gui/DepartmentForm.fxml", parentStage);
	}
	
	public void initializeNodes() {
		
		tableColumnID.setCellValueFactory(new PropertyValueFactory<>("id"));
		tableColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));
		
		
		Stage parentStage = (Stage) Main.getMainScene().getWindow();		
		tableViewDepartament.prefHeightProperty().bind (parentStage.heightProperty());
		
	}

	@Override
	public void initialize(URL p_URL, ResourceBundle p_Resource) {	
		initializeNodes();
	}
	
	public void setDepartmentService(DepartmentService service) {
		this.service = service;
	}
	
	public void updateTableView() {	
		
		if ( service == null ) {
			throw new IllegalStateException("Atribuito private service esta nulo");
		}
				
		ObservableList<Department> obsDepartment = FXCollections.observableArrayList(this.service.findAll());		
		tableViewDepartament.setItems(obsDepartment);
		
		initEditButtons();
	}
	
	public void createDialogForm(Department obj, String frxSource, @SuppressWarnings("exports") Stage parentStage) {
		
		
		
		try {
		
			FXMLLoader loader = new FXMLLoader(getClass().getResource(frxSource));
			Pane pane = loader.load();
			
			DepartmentFormController controller = loader.getController();
			
			controller.setEntity(obj);
			controller.setService(new DepartmentService());
			controller.updateFormData();
			controller.subscribeDataChangeListener(this);
			
			Stage modalStageWindow = new Stage();
			
			modalStageWindow.setTitle("Enter departmenta Data");
			modalStageWindow.setScene(new Scene(pane));
			modalStageWindow.setResizable(false);
			modalStageWindow.initOwner(parentStage);
			modalStageWindow.initModality(Modality.WINDOW_MODAL);
			modalStageWindow.showAndWait();
		
		} catch(IOException e) {
			Alerts.showAlert("IOException Error", "Erro ao abrir formulario (" + frxSource + ")", e.getMessage(), AlertType.ERROR);
		}
			
		
		
	}

	@Override
	public void onDataChange() {
		updateTableView();		
	}
	
	private void initEditButtons() {
		tableColumnEDIT.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
		tableColumnEDIT.setCellFactory(param -> new TableCell<Department, Department>() {
			private final Button button = new Button("edit");

			@Override
			protected void updateItem(Department obj, boolean empty) {
				super.updateItem(obj, empty);
				if (obj == null) {
					setGraphic(null);
					return;
				}
				setGraphic(button);
				button.setOnAction(
						event -> createDialogForm(obj, "/gui/DepartmentForm.fxml", Utils.getCurrentStage(event)));
			}
		});
	}

}
