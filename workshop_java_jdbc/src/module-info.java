module workshop_javafx_jdbc {
	requires javafx.controls;
	requires javafx.fxml;
	
	exports gui;
	opens gui;
	
	exports model.entities;	
	opens model.entities;
	
	exports model.services;
	opens model.services;
	
	opens application to javafx.graphics, javafx.fxml;
}
