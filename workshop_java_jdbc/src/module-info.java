module workshop_javafx_jdbc {
	exports application;
	exports model.services;
	exports gui;
	exports gui.util;
	exports model.entities;

	requires javafx.base;
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	
	opens gui;	
	
	opens model.entities;	
	
	opens application to javafx.graphics, javafx.fxml;
}