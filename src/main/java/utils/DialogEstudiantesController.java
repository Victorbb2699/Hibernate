package utils;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ButtonBar.ButtonData;

import java.io.IOException;

import clases.Estudiantes;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;

public class DialogEstudiantesController extends Dialog<Estudiantes> {

	@FXML
	private DialogPane root;

	@FXML
	private TextField codestudianteTextField;

	@FXML
	private TextField dniTextField;

	@FXML
	private TextField nombreTextField;

	@FXML
	private TextField tlfTextField;

	public DialogEstudiantesController() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/insertEstudiantesView.fxml"));
		loader.setController(this);
		try {
			loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		setTitle("Insertar estudiante");
		setHeaderText("Insertar nueva estudiante");

		ButtonType okButton = new ButtonType("Añadir", ButtonData.OK_DONE);
		ButtonType cancelButton = new ButtonType("Cancelar", ButtonData.CANCEL_CLOSE);

		getDialogPane().setContent(root);
		getDialogPane().getButtonTypes().addAll(okButton, cancelButton);

		setResultConverter(resultButton -> {
			
			if (resultButton == okButton) {

				Estudiantes estudiante= new Estudiantes();
				estudiante.setCodEstudiante(Integer.parseInt(codestudianteTextField.getText()));
				estudiante.setDni(dniTextField.getText());
				estudiante.setNomEstudiante(nombreTextField.getText());
				estudiante.setTelefonoEstudiante(tlfTextField.getText());
				

				return estudiante;

			}
			return null;
		});
		
	}
	public DialogPane getView() {
		return root;
	}
}
