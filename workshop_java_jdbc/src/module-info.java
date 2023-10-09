module workshop_javafx_jdbc {
	exports application;
	exports model.services;
	exports gui;
	opens gui;
	exports gui.util;
	exports model.entities;

	requires javafx.base;
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires java.sql;
}