package app;

import hibernate.HibernateController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

	HibernateController controller;

	@Override
	public void stop() throws Exception {
		super.stop();
		controller.getSesion().close();	
	}
	@Override
	public void start(Stage primaryStage) throws Exception {

		controller = new HibernateController();

		Scene scene = new Scene(controller.getView(), 640, 480);

		primaryStage.setTitle("Proyecto Hibernate - Victor Bethencourt Barrera");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}

}
