package gui;

import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;

public class ViewController {
	
	@FXML
	private Button BtnTeste;
	
	@FXML
	public void BtnTeste_OnAction() {
		Alerts.showAlert("Titulo do alerta", "Header do Alerta", "Conteúdo da mensagem", AlertType.WARNING);
	}
	
}
