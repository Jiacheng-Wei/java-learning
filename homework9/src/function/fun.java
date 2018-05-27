package function;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Polyline;
import javafx.collections.ObservableList;


public class fun extends Application {

	@Override
	public void start(Stage primaryStage) {
		Polyline polyline = new Polyline();
		ObservableList<Double>list = polyline.getPoints();
		double scaleFactor = 0.0125;
		for(int x = -100; x <= 100; x++) {
			list.add(x + 200.0);
			list.add(-scaleFactor * x * x );
		}
		
		Pane pane = new Pane();
		pane.getChildren().add(polyline);
		
		Scene scene = new Scene(pane,800,800);
		primaryStage.setTitle("demo");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
