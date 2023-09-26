module javaFX_Project2 {
	requires javafx.fxml;
	requires javafx.controls;	
	
	/*
	 * O java solicitou que o pacote fosse incluido em exports e opens para abri o formulário*/
	exports gui;
	opens   gui;
	 
	opens application to javafx.graphics;
}
