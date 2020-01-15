package utils;

import java.io.IOException;

import org.hibernate.Session;

import clases.ResidenciaObservacion;
import clases.Residencias;
import clases.Universidades;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ButtonBar.ButtonData;

public class DialogResidenciasController extends Dialog<Residencias> {

	// model

	// view

	@FXML
	private RadioButton comedorRadioButton;

	@FXML
	private TextField observacionesTextField;

	@FXML
	private DialogPane root;

	@FXML
	private Label nombreResLabel;

	@FXML
	private Label precioMensualLabel;

	@FXML
	private Label comedorLabel;

	@FXML
	private TextField nomResTextField;

	@FXML
	private TextField precioTextField;

	@FXML
	private TextField codUniTextField;

	@FXML
	private TextField comedorTextField;

	@FXML
	private Label coduniLabel;

	public DialogResidenciasController(Session ses) {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/insertarResiView.fxml"));
		loader.setController(this);
		try {
			loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}

		setTitle("Insertar residencia");
		setHeaderText("Insertar nueva residencia");

		ButtonType okButton = new ButtonType("Añadir", ButtonData.OK_DONE);
		ButtonType cancelButton = new ButtonType("Cancelar", ButtonData.CANCEL_CLOSE);

		getDialogPane().setContent(root);
		getDialogPane().getButtonTypes().addAll(okButton, cancelButton);

		setResultConverter(resultButton -> {

			if (resultButton == okButton) {

				Residencias residencia = new Residencias();
				ResidenciaObservacion obv = new ResidenciaObservacion();

				residencia.setNomResidencia(nomResTextField.getText());
				residencia.setCodUniversidad(ses.get(Universidades.class, codUniTextField.getText()));
				residencia.setComedor(comedorRadioButton.isSelected());
				residencia.setPrecioMensual(Integer.parseInt(precioTextField.getText()));
				
				obv.setResidenciaXXX(residencia);
				obv.setObservaciones(observacionesTextField.getText());

				return residencia;

			}
			return null;
		});

	}

	public DialogPane getView() {
		return root;
	}

}
