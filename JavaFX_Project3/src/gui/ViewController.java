package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import model.entities.Pessoa;

public class ViewController implements Initializable {
	
	@FXML
	private ComboBox<Pessoa> comboPessoa;
	
	ObservableList<Pessoa> obsList;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		List<Pessoa> lista = new ArrayList<>();
		
		lista.add(new Pessoa(1, "Carlos", "carlos@gmail.com"));
		lista.add(new Pessoa(2, "Eduardo", "eduardo@gmail.com"));
		lista.add(new Pessoa(3, "Roberto", "roberto@gmail.com"));
		
		obsList = FXCollections.observableArrayList(lista);
		
		comboPessoa.setItems(obsList);
		
	}
	
}
