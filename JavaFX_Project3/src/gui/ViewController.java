package gui;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import gui.util.Alerts;
import gui.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ViewController implements Initializable {
	
	@FXML
	private TextField EdtValor1;
	
	@FXML
	private TextField EdtValor2;

	@FXML
	private Button BtnSoma;
	
	@FXML
	private Label lblResultado;
	
	@FXML
	public void BtnTeste_OnAction() {
		
		Locale.setDefault(Locale.US);
		
		try {
			
			// recebe os valores informados pelo usuário
			float valorCampo1 = Float.parseFloat(EdtValor1.getText());
			float valorCampo2 = Float.parseFloat(EdtValor2.getText());
			
			// realiza asoma
			float somaValor = valorCampo1 + valorCampo2;		

			// transfere o resultado para o label na tela
			lblResultado.setText(String.format("%.2f", somaValor));

		
		}
		catch (NumberFormatException e) {
			Alerts.showAlert("Erro de Conversão", "Número Informado Incorretamente", e.getMessage(), AlertType.WARNING);
		}
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		Constraints.setTextFieldDouble(EdtValor1);
		Constraints.setTextFieldDouble(EdtValor2);
		Constraints.setTextFieldMaxLength(EdtValor1, 12);
		Constraints.setTextFieldMaxLength(EdtValor2, 12);
		
	}
	
}
