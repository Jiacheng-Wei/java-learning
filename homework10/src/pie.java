
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.text.Text;

public class pie extends Application {

	@Override
	public void start(Stage primaryStage) {
		Pane pane = new Pane();
		
		Arc arc1 =new Arc(150,100,80,80,0,72);
		arc1.setFill(Color.RED);
		arc1.setType(ArcType.ROUND);
		pane.getChildren().add(new Text(240,60,"项目20%"));
		pane.getChildren().add(arc1);
		
		Arc arc2 = new Arc(150,100,80,80,72,36);
		arc2.setFill(Color.BLUE);
		arc2.setType(ArcType.ROUND);
		pane.getChildren().add(new Text(160,10,"测试10%"));
		pane.getChildren().add(arc2);
		
		Arc arc3 = new Arc(150,100,80,80,108,108);
		arc3.setFill(Color.GREEN);
		arc3.setType(ArcType.ROUND);
		pane.getChildren().add(new Text(10,100,"期中30%"));
		pane.getChildren().add(arc3);
		
		Arc arc4 = new Arc(150,100,80,80,216,144);
		arc4.setFill(Color.ORANGE);
		arc4.setType(ArcType.ROUND);
		pane.getChildren().add(new Text(150,190,"期末40%"));
		pane.getChildren().add(arc4);
		
		
		Scene scene = new Scene(pane,300,200);
		primaryStage.setTitle("homework10");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}
