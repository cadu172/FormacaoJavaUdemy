package gui;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.entities.Department;

public class DepartmentListController implements Initializable {
	
	@FXML
	private Button BtnNew;	
	
	@FXML
	private TableView<Department> tableViewDepartament;
	
	@FXML
	private TableColumn<Department, Integer> tableColumnID;
	
	@FXML
	private TableColumn<Department, String> tableColumnName;	
	
	@FXML
	public void BtnNew_OnAction() {
		System.out.println("BtnNew_OnAction");
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

}
