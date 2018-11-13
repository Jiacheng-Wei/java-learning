
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PersonalData extends Application {
	public void start(Stage stage) {
		BorderPane pane = new BorderPane();		
		
		VBox vbox1= new VBox(15);
		Label lname = new Label("昵称：");
		VBox.setMargin(lname,new Insets(45,10,0,50));
		Label lbirth = new Label("生日：");
		VBox.setMargin(lbirth,new Insets(15,10,0,50));
		Label lsex = new Label("性别：");
		VBox.setMargin(lsex,new Insets(15,10,0,50));
		Label lpass1 = new Label("密码：");
		VBox.setMargin(lpass1,new Insets(15,10,0,50));
		/*Label lpass2 = new Label("确认密码：");
		VBox.setMargin(lpass2,new Insets(35,10,0,50));*/
		vbox1.getChildren().addAll(lname,lbirth,lsex,lpass1);
		
		VBox vbox2 = new VBox(5);
		TextField namefield = new TextField();
		VBox.setMargin(namefield,new Insets(40,50,0,0));
		vbox2.getChildren().add(namefield);
		
		HBox hbox1 = new HBox(10);
		ComboBox cyear = new ComboBox();
		cyear.setValue("请选择");
		cyear.getItems().addAll("1980","1981","1982","1983","1984","1985","1986","1987","1988","1989","1990",
				"1991","1992","1993","1994","1995","1996","1997","1998","1999","2000",
				"2001","2002","2003","2004","2005","2006","2007","2008","2009","2010");
		ComboBox cmonth = new ComboBox();
		cmonth.setValue("请选择");
		cmonth.getItems().addAll("1","2","3","4","5","6","7","8","9","10","11","12");
		ComboBox cday = new ComboBox();
		cday.setValue("请选择");
		cday.getItems().addAll("1","2","3","4","5","6","7","8","9","10","11","12","13","14","15",
				"16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31");
		hbox1.getChildren().addAll(cyear,cmonth,cday);
		VBox.setMargin(hbox1,new Insets(15,50,0,0));
		vbox2.getChildren().add(hbox1);
		
		HBox hbox2 = new HBox(15);
		RadioButton rbmale = new RadioButton("男");
		RadioButton rbfamale = new RadioButton("女");
		ToggleGroup group = new ToggleGroup();
		rbmale.setToggleGroup(group);
		rbfamale.setToggleGroup(group);
		hbox2.getChildren().addAll(rbmale,rbfamale);
		VBox.setMargin(hbox2,new Insets(25,50,0,0));
		vbox2.getChildren().add(hbox2);
		
		Button passfield1 = new Button("修改密码");
		VBox.setMargin(passfield1,new Insets(20,50,0,0));
		vbox2.getChildren().add(passfield1);
		/*Text text = new Text("*密码由6~20个数字和字母组成，区分大小写");
		text.setFont(Font.font ("Verdana", 10));
		text.setFill(Color.TOMATO);
		vbox2.getChildren().add(text);*/
		
		/*TextField passfield2 = new TextField();
		VBox.setMargin(passfield2,new Insets(20,50,0,0));
		vbox2.getChildren().add(passfield2);*/
		
		pane.setLeft(vbox1);
		pane.setCenter(vbox2);
		Button btSignUp=new Button("保存");
		pane.setBottom(btSignUp);
		pane.setAlignment(btSignUp, Pos.BASELINE_CENTER);
		pane.setBackground(new Background(new BackgroundFill(Color.ALICEBLUE,null,null)));
		
		Scene scene = new Scene(pane,440,260);
		stage.setTitle("个人信息");
		stage.setScene(scene);
		stage.show();
	}
	public static void main(String[] args) {
		Application.launch(args);
	}
}
