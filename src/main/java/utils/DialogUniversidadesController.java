package utils;

import java.io.IOException;

import clases.Universidades;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;

public class DialogUniversidadesController extends Dialog<Universidades> {

	@FXML
	private DialogPane root;

	@FXML
	private TextField coduniTextField;

	@FXML
	private TextField nomuniTextField;

	public DialogUniversidadesController() {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/insertarUniView.fxml"));
		loader.setController(this);
		try {
			loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}

		setTitle("Insertar universidad");
		setHeaderText("Insertar nueva universidad");

		ButtonType okButton = new ButtonType("Añadir", ButtonData.OK_DONE);
		ButtonType cancelButton = new ButtonType("Cancelar", ButtonData.CANCEL_CLOSE);

		getDialogPane().setContent(root);
		getDialogPane().getButtonTypes().addAll(okButton, cancelButton);

		setResultConverter(resultButton -> {
			
			if (resultButton == okButton) {

				Universidades universidad = new Universidades();

				universidad.setCodUniversidad(coduniTextField.getText());
				universidad.setNomUniversidad(nomuniTextField.getText());

				return universidad;

			}
			return null;
		});

	}

	public DialogPane getView() {
		return root;
	}
}
