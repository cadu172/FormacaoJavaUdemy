module workshop_javafx_jdbc {
	requires javafx.controls;
	requires javafx.fxml;
	
	exports gui;
	opens gui;
	
	opens application to javafx.graphics, javafx.fxml;
}
