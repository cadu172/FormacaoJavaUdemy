package gui.util;


import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

public class Utils {
	
	@SuppressWarnings("exports")
	public static Stage getCurrentStage(ActionEvent event) {
		return (Stage)(((Node)event.getSource()).getScene().getWindow());
	}
	
	public static Integer tryParseToInt(String valorEntrada) {
		try {
			return Integer.parseInt(valorEntrada);
		}
		catch ( NumberFormatException e ) {			
			return null;
		}
	}

}
