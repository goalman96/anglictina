package com.github.goalman96.anglictina.ui;

import com.github.goalman96.anglictina.logika.Hra;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Třída slouží ke spuštění adventury.
 * Při spuštění bez parametru konstruuje okno aplikace,
 * s parametrem -text se spouští v textovém režimu
 * 
 * @author Filip Vencovsky
 *
 */
public class Application extends javafx.application.Application {

	/**
	 * Spouštěcí metoda pro aplikaci
	 * @param args
	 */
	public static void main(String[] args) {
            launch(args);
	}
	/**
	 * Metoda, ve které se konstruuje okno, kontroler a hra,
	 * která se předává kontroleru
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
//		Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass()
		          .getResource("Home.fxml"));
		Parent root = loader.load();

		HomeController controller = loader.getController();
		controller.inicializuj(new  Hra());
		
        primaryStage.setTitle("title");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
		
	}

}
