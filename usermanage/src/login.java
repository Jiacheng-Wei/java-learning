
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.ComboBox;
import javafx.collections.*;

public class login extends Application {

	@Override
	public void start(Stage primaryStage) {
		BorderPane pane =  new BorderPane();
		Image image = new Image("image/hexo1.jpg");
		ImageView imageview = new ImageView(image);
		imageview.setFitHeight(100);
		imageview.setFitWidth(400);
		pane.setTop(imageview);
		pane.setCenter(getGridPane());
		
		
		
		
		
		Scene scene=new Scene(pane,400,300);
		primaryStage.setTitle("OICO");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	private StackPane descriptionPane = new StackPane();
	private String[] choice= {"����","����","����"};
	private ComboBox<String> cbo =new ComboBox<>();
	
	private GridPane getGridPane() {
		GridPane gridpane=new GridPane();
		gridpane.setAlignment(Pos.CENTER);
		gridpane.setPadding(new Insets(11.5,12.5,13.5,14.5));
		gridpane.setHgap(5.5);
		gridpane.setVgap(5.5);
		
		gridpane.add(new Label("�˺�"), 0, 0);
		gridpane.add(new TextField(), 1, 0);
		gridpane.add(new Button("ע��"), 2, 0);
		
		gridpane.add(new Label("����"), 0, 1);
		gridpane.add(new TextField(), 1, 1);
		gridpane.add(new Button("�������룿"), 2, 1);
		

		cbo.setPrefWidth(100);
		cbo.setValue("����");
		ObservableList<String> items = FXCollections.observableArrayList(choice);
		cbo.getItems().addAll(items);
		gridpane.add(cbo, 0, 2);
		
		Button signup = new Button("		��¼			");
		gridpane.add(signup, 1, 3);
		return gridpane;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
