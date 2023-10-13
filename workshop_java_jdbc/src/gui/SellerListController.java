package gui;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;

import application.Main;
import db.DbIntegrityException;
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
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.entities.Seller;
import model.services.SellerService;

public class SellerListController implements Initializable, InterfaceDataChangeListener {

	private SellerService service;

	@FXML
	private Button BtnNew;

	@FXML
	private TableView<Seller> tableViewDepartament;

	@FXML
	private TableColumn<Seller, Integer> tableColumnID;

	@FXML
	private TableColumn<Seller, String> tableColumnName;

	@FXML
	private TableColumn<Seller, Seller> tableColumnEDIT;

	@FXML
	private TableColumn<Seller, Seller> tableColumnREMOVE;
	
	@FXML
	private TableColumn<Seller, String> tableColumnEmail;
	
	@FXML
	private TableColumn<Seller, Date> tableColumnBirthDate;
	
	@FXML
	private TableColumn<Seller, Double> tableColumnBaseSalary;	

	@FXML
	public void BtnNew_OnAction(@SuppressWarnings("exports") ActionEvent event) {

		Seller newSeller = new Seller();

		Stage parentStage = Utils.getCurrentStage(event);
		createDialogForm(newSeller, "/gui/SellerForm.fxml", parentStage);
	}

	public void initializeNodes() {

		tableColumnID.setCellValueFactory(new PropertyValueFactory<>("id"));
		tableColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));
		
		tableColumnEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
		
		tableColumnBirthDate.setCellValueFactory(new PropertyValueFactory<>("birthDate"));
		this.formatTableColumnDateAuxiliar(tableColumnBirthDate, "dd/MM/yyyy");
		
		tableColumnBaseSalary.setCellValueFactory(new PropertyValueFactory<>("baseSalary"));
		Utils.formatTableColumnDouble(tableColumnBaseSalary, 2);

		Stage parentStage = (Stage) Main.getMainScene().getWindow();
		tableViewDepartament.prefHeightProperty().bind(parentStage.heightProperty());

	}

	@Override
	public void initialize(URL p_URL, ResourceBundle p_Resource) {
		initializeNodes();
	}

	public void setSellerService(SellerService service) {
		this.service = service;
	}

	public void updateTableView() {

		if (service == null) {
			throw new IllegalStateException("Atribuito private service esta nulo");
		}

		ObservableList<Seller> obsSeller = FXCollections.observableArrayList(this.service.findAll());
		tableViewDepartament.setItems(obsSeller);

		initEditButtons();
		initRemoveButtons();
	}

	public void createDialogForm(Seller obj, String frxSource, @SuppressWarnings("exports") Stage parentStage) {

		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource(frxSource));
			Pane pane = loader.load();

			SellerFormController controller = loader.getController();

			controller.setEntity(obj);
			controller.setService(new SellerService());
			controller.updateFormData();
			controller.subscribeDataChangeListener(this);

			Stage modalStageWindow = new Stage();

			modalStageWindow.setTitle("Enter Seller Data");
			modalStageWindow.setScene(new Scene(pane));
			modalStageWindow.setResizable(false);
			modalStageWindow.initOwner(parentStage);
			modalStageWindow.initModality(Modality.WINDOW_MODAL);
			modalStageWindow.showAndWait();

		} catch (IOException e) {
			Alerts.showAlert("IOException Error", "Erro ao abrir formulario (" + frxSource + ")", e.getMessage(),
					AlertType.ERROR);
		}

	}

	@Override
	public void onDataChange() {
		updateTableView();
	}

	private void initEditButtons() {
		tableColumnEDIT.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
		tableColumnEDIT.setCellFactory(param -> new TableCell<Seller, Seller>() {
			private final Button button = new Button("edit");

			@Override
			protected void updateItem(Seller obj, boolean empty) {
				super.updateItem(obj, empty);
				if (obj == null) {
					setGraphic(null);
					return;
				}
				setGraphic(button);
				button.setOnAction(
						event -> createDialogForm(obj, "/gui/SellerForm.fxml", Utils.getCurrentStage(event)));
			}
		});
	}

	private void initRemoveButtons() {
		tableColumnREMOVE.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
		tableColumnREMOVE.setCellFactory(param -> new TableCell<Seller, Seller>() {
			private final Button button = new Button("remove");

			@Override
			protected void updateItem(Seller obj, boolean empty) {
				super.updateItem(obj, empty);
				if (obj == null) {
					setGraphic(null);
					return;
				}
				setGraphic(button);
				button.setOnAction(event -> removeEntity(obj));
			}
		});
	}

	private void removeEntity(Seller obj) {

		Optional<ButtonType> result = Alerts.showConfirmation("Confirm delete",
				"Confirm delete item: " + obj.getName() + "?");

		if (result.get() == ButtonType.OK) {

			try {

				service.remove(obj);
				updateTableView();

			} catch (DbIntegrityException err) {

				Alerts.showAlert("Error on delete", null, err.getMessage(), AlertType.ERROR);
			}

		}
	}
	
	
	public <T> void formatTableColumnDateAuxiliar(TableColumn<Seller, Date> tableColumn, String format) {
		tableColumn.setCellFactory(column -> {
			TableCell<Seller, Date> cell = new TableCell<Seller, Date>() {
				private SimpleDateFormat sdf = new SimpleDateFormat(format);

				@Override
				protected void updateItem(Date item, boolean empty) {
					super.updateItem(item, empty);
					if (empty) {
						setText(null);
					} else {
						setText(sdf.format(item));
					}
				}
			};
			return cell;
		});
	}	

}
