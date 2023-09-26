package gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ViewController {
	
	@FXML
	private Button BtnTeste;
	
	@FXML
	public void BtnTeste_OnAction() {
		System.out.println("Botão teste");
	}
	
}
