package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

import application.Main;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import model.services.DepartmentService;
import model.services.SellerService;

public class MainViewController implements Initializable {
	
	@FXML
	private MenuItem menuItemSeller;

	@FXML
	private MenuItem menuItemDepartment;

	@FXML
	private MenuItem menuItemAbout;
	
	@Override
	public void initialize(URL p_URI, ResourceBundle p_ResourceBundle) {
		// TODO Auto-generated method stub
		
	}
	
	@FXML
	public void onMenuItemSellerAction() {
		loadView("/gui/SellerList.fxml", ( SellerListController controller ) -> {
			
			controller.setSellerService(new SellerService());
			controller.updateTableView();	
			
		});
	}

	@FXML
	public void onMenuItemDepartmentAction() {
		//loadView("/gui/DepartmentList.fxml");
		loadView("/gui/DepartmentList.fxml", ( DepartmentListController controller ) -> {
		
			controller.setDepartmentService(new DepartmentService());
			controller.updateTableView();	
			
		});
	}
	
	@FXML
	public void onMenuItemAboutAction() {
		
		loadView("/gui/About.fxml", x -> {});
	}
	
	private synchronized <T> void loadView(String pathView, Consumer<T> initializeProcedure) {
		
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(pathView));
			
			VBox newVBox = loader.load();
			
			Scene mainScene = Main.getMainScene();
			VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();
			
			Node mainMenu = mainVBox.getChildren().get(0);
			mainVBox.getChildren().clear();
			mainVBox.getChildren().add(mainMenu);
			mainVBox.getChildren().addAll(newVBox.getChildren());
			
			T controller = loader.getController();
			initializeProcedure.accept(controller);
		
		} catch (IOException e) {
			Alerts.showAlert("IOException Error", "Error on load fxml" , e.getMessage(), AlertType.ERROR);
		}
	}
	
}
