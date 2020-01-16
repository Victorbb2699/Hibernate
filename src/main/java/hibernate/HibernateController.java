package hibernate;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import javax.persistence.Query;

import org.hibernate.Session;

import HibernateUtil.HibernateUtil;
import clases.Estancias;
import clases.Estudiantes;
import clases.ResidenciaObservacion;
import clases.Residencias;
import clases.Universidades;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.VBox;
import utils.DialogEstanciasController;
import utils.DialogEstudiantesController;
import utils.DialogResidenciasController;
import utils.DialogUniversidadesController;

public class HibernateController implements Initializable {

	// model
	private Session sesion = HibernateUtil.getSessionFactory().openSession();

	// view

	public Session getSesion() {
		return sesion;
	}

	@FXML
	private VBox root;

	@FXML
	private TextArea visualizarTextArea;

	@FXML
	private Button insertarEstancia;

	@FXML
	private Button insertarUniversidad;

	@FXML
	private Button insertarEstudiantes;

	@FXML
	private Button insertarRes;

	@FXML
	private Button actualizarResidencia;

	@FXML
	private Button eliminarResidencia;

	@FXML
	private Button visualizarResidencias;

	@FXML
	private Button visualizarResidenciasAll;

	public HibernateController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/hibernateView.fxml"));
		loader.setController(this);
		loader.load();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	@FXML
	void onActualizarResidenciaAction(ActionEvent event) {

		TextInputDialog dialog = new TextInputDialog("Actualizar residencia");
		dialog.setTitle("Actualizar residencia");
		dialog.setHeaderText("Actualizar residencia");
		dialog.setContentText("Introduce codigo residencia");
		Optional<String> result = dialog.showAndWait();
		
		
		try {

			sesion.beginTransaction();
			DialogResidenciasController indialog = new DialogResidenciasController(sesion);
			Optional<Residencias> dialogResi = indialog.showAndWait();

			Residencias residencia = new Residencias();
			residencia = (Residencias) sesion.get(Residencias.class, Integer.parseInt(result.get()));
			
			Universidades universidad = sesion.get(Universidades.class, dialogResi.get().getUniversidad().getCodUniversidad());
			residencia.setCodResidencia(Integer.parseInt(result.get()));
			residencia.setCodUniversidad(universidad);
			residencia.setNomResidencia(dialogResi.get().getNomResidencia());
			residencia.setPrecioMensual(dialogResi.get().getPrecioMensual());
			residencia.setComedor(dialogResi.get().isComedor());
			
			sesion.save(residencia);
			sesion.getTransaction().commit();

		} catch (Exception e) {
			System.out.println("No se puede modificar esa residencia");
			sesion.getTransaction().rollback();
		}

	}

	@SuppressWarnings("unchecked")
	@FXML
	void onConsultaDosAction(ActionEvent event) {

		Query q = sesion.createQuery("FROM Residencias");
		List<Residencias> aux = q.getResultList();

		StringBuilder sb = new StringBuilder();
		sb.append("\nResidencias con estancias\n");

		for (int i = 0; i < aux.size(); i++) {
			sb.append("\nResidencia\n");
			sb.append("  Código:  " + aux.get(i).getCodResidencia());
			sb.append("  Código universidad:  " + aux.get(i).getUniversidad().getCodUniversidad());
			sb.append("  Nombre residencia:  " + aux.get(i).getNomResidencia());
			sb.append("  Precio mensual:  " + aux.get(i).getPrecioMensual());
			if (aux.get(i).isComedor()) {
				sb.append("  Tiene comedor  ");
			} else {
				sb.append("  No tiene comedor  ");
			}
			if (aux.get(i).getResidenciaObservacionX() == null) {
				sb.append("  Sin observación  ");
			} else {
				sb.append("Observación:" + aux.get(i).getResidenciaObservacionX().getObservaciones());
			}
			sb.append("\nEstancias de esta residencia.\n");
			for (int j = 0; j < aux.get(i).getEstancias().size(); j++) {
				sb.append("  Codigo estancia:  " + aux.get(i).getEstancias().get(j).getCodEstancia());
				sb.append("  Universidad:  " + aux.get(i).getUniversidad().getNomUniversidad());
				sb.append("  Codigo estudiante:  "
						+ aux.get(i).getEstancias().get(j).getCodEstudiantes().getCodEstudiante());
				sb.append("  Dni estudiante:  " + aux.get(i).getEstancias().get(j).getCodEstudiantes().getDni());
				sb.append("  Nombre estudiante:  "
						+ aux.get(i).getEstancias().get(j).getCodEstudiantes().getNomEstudiante());
				sb.append("  Teléfono estudiante:  "
						+ aux.get(i).getEstancias().get(j).getCodEstudiantes().getTelefonoEstudiante());
				sb.append("  Fecha inicio:  " + aux.get(i).getEstancias().get(j).getFechaInicio());
				sb.append("  Fecha fin:  " + aux.get(i).getEstancias().get(j).getFechaFin());
				sb.append("  Precio pagado:  " + aux.get(i).getEstancias().get(j).getPreciopagado());
				sb.append("\n");
			}
			visualizarTextArea.setText(sb.toString());
		}
	}

	@SuppressWarnings("unchecked")
	@FXML
	void onConsultaUnoAction(ActionEvent event) {

		Query query = sesion.createQuery("FROM Residencias");
		List<Residencias> residencias = query.getResultList();

		StringBuilder sb = new StringBuilder();
		sb.append("\nResidencias\n");

		for (int i = 0; i < residencias.size(); i++) {

			sb.append(" [Codigo] " + residencias.get(i).getCodResidencia());
			sb.append(" [Codigo universidad] " + residencias.get(i).getCodUniversidad().getCodUniversidad());
			sb.append(" [Nombre residencia] " + residencias.get(i).getNomResidencia());
			sb.append(" [Precio mensual] " + residencias.get(i).getPrecioMensual());
			sb.append(" [Comedor] ");
			if (residencias.get(i).isComedor()) {
				sb.append(" Si tiene comedor ");
			} else {
				sb.append(" No tiene comedor ");
			}

			if (residencias.get(i).getResidenciaObservacionX() == null) {
				sb.append(" [Observacion] Sin observaciones ");
			} else {
				sb.append(" [Observacion] " + residencias.get(i).getResidenciaObservacionX().getObservaciones());
			}
			sb.append("\n");
		}

		visualizarTextArea.setText(sb.toString());

	}

	@FXML
	void onEliminarResidenciaAction(ActionEvent event) {

		TextInputDialog dialog = new TextInputDialog("Eliminar residencia");
		dialog.setTitle("Eliminar residencia");
		dialog.setHeaderText("Eliminar residencia");
		dialog.setContentText("Introduce codigo residencia");

		// Traditional way to get the response value.
		Optional<String> result = dialog.showAndWait();

		try {
			sesion.beginTransaction();
			Residencias residencia = new Residencias();
			residencia = (Residencias) sesion.get(Residencias.class, Integer.parseInt(result.get()));

			if (residencia.getResidenciaObservacionX() == null) {
				sesion.delete(residencia);
			} else {
				ResidenciaObservacion residenciasobservaciones = new ResidenciaObservacion();
				sesion.delete(residenciasobservaciones);
			}
			sesion.getTransaction().commit();

		} catch (Exception e) {

			System.out.println("No se puede eliminar la residencia");
			sesion.getTransaction().rollback();

		}
	}

	@FXML
	void onInsertarEstanciaAction(ActionEvent event) {

		try {

			DialogEstanciasController esdialog = new DialogEstanciasController(sesion);
			Optional<Estancias> estancia = esdialog.showAndWait();
			sesion.beginTransaction();
			sesion.save(estancia.get());

			sesion.getTransaction().commit();
		} catch (Exception e) {
			sesion.getTransaction().rollback();
		}
	}

	@FXML
	void onInsertarEstudiantesAction(ActionEvent event) {

		try {

			DialogEstudiantesController estdialog = new DialogEstudiantesController();
			Optional<Estudiantes> estudiante = estdialog.showAndWait();
			sesion.beginTransaction();
			sesion.save(estudiante.get());

			sesion.getTransaction().commit();
		} catch (Exception e) {
			sesion.getTransaction().rollback();
		}

	}

	@FXML
	void onInsertarResAction(ActionEvent event) {

		try {

			DialogResidenciasController resdialog = new DialogResidenciasController(sesion);
			Optional<Residencias> res = resdialog.showAndWait();
			sesion.beginTransaction();
			
			
			sesion.save(res.get());

			sesion.getTransaction().commit();
		} catch (Exception e) {
			sesion.getTransaction().rollback();
		}

	}

	@FXML
	void onInsertarUniversidadAction(ActionEvent event) {

		try {

			DialogUniversidadesController unidialog = new DialogUniversidadesController();
			Optional<Universidades> uni = unidialog.showAndWait();
			sesion.beginTransaction();
			sesion.save(uni.get());

			sesion.getTransaction().commit();
		} catch (Exception e) {
			sesion.getTransaction().rollback();
		}

	}

	public VBox getView() {
		return root;
	}

}
