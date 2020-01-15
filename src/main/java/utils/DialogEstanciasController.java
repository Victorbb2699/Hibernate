package utils;

import java.io.IOException;

import org.hibernate.Session;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import clases.Estancias;
import clases.Estudiantes;
import clases.Residencias;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.ButtonBar.ButtonData;

public class DialogEstanciasController extends Dialog<Estancias> {

	@FXML
	private DialogPane root;

	@FXML
	private TextField codestudianteTextField;

	@FXML
	private TextField codresidenciaTextField;

	@FXML
	private DatePicker fechaInicioDatePicker;

	@FXML
	private DatePicker fechaFinDatePicker;

	@FXML
	private TextField precioTextField;

	public DialogEstanciasController(Session ses) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/insertarEstanciaView.fxml"));
		loader.setController(this);
		try {
			loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		setTitle("Insertar estancia");
		setHeaderText("Insertar nueva estancia");

		ButtonType okButton = new ButtonType("Añadir", ButtonData.OK_DONE);
		ButtonType cancelButton = new ButtonType("Cancelar", ButtonData.CANCEL_CLOSE);

		getDialogPane().setContent(root);
		getDialogPane().getButtonTypes().addAll(okButton, cancelButton);

		setResultConverter(resultButton -> {

			if (resultButton == okButton) {

				Estancias estancia = new Estancias();

				estancia.setCodEstudiantes(ses.get(Estudiantes.class, Integer.parseInt(codestudianteTextField.getText())));
				estancia.setCodResidencia(ses.get(Residencias.class, Integer.parseInt(codresidenciaTextField.getText())));
				estancia.setFechaInicio(fechaInicioDatePicker.getValue());
				estancia.setFechaFin(fechaFinDatePicker.getValue());
				estancia.setPreciopagado(Integer.parseInt(precioTextField.getText()));

				return estancia;

			}
			return null;
		});
	}

	public DialogPane getView() {
		return root;
	}
}
