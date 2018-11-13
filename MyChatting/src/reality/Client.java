package reality;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Client extends Application{
	
	private TextField tf=new TextField();
	private TextField ipField=new TextField();
	private TextArea ta=new TextArea();
	private Socket socket;
	private DataOutputStream dos;
	private DataInputStream dis;
	private DatagramSocket dsocketSend;
	private DatagramSocket dsocketRece;
	public static void main(String[] args) throws IOException {
		Application.launch(args);

	    } 
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		 dsocketSend=new DatagramSocket(10000);
		 dsocketRece=new DatagramSocket(10001);
     BorderPane paneForTextField=new BorderPane();
     paneForTextField.setPadding(new Insets(5,5,5,5));
     paneForTextField.setStyle("-fx-border-color:green");
     paneForTextField.setLeft(new Label("Enter your message: "));
     
     ipField.setAlignment(Pos.TOP_RIGHT);
     tf.setAlignment(Pos.BOTTOM_RIGHT);
     paneForTextField.setCenter(tf);
     paneForTextField.setBottom(ipField);
     
     BorderPane mainPane=new BorderPane();
     mainPane.setCenter(new ScrollPane(ta));
     mainPane.setTop(paneForTextField);
     
     Scene scene=new Scene(mainPane,450,200);
     primaryStage.setTitle("MyClient");
     primaryStage.setScene(scene);
     primaryStage.show();
     
     tf.setOnAction(e -> send()); // Register listener
     
     try {

         socket = new Socket("localhost", 8000);

         dis = new DataInputStream(socket.getInputStream());

         dos = new DataOutputStream(socket.getOutputStream());

         new Thread(()->receive()).start();
     }
     catch (IOException ex) {
         ex.printStackTrace();
     }

	}
    public void receive() {
    	byte[] buf=new byte[1024];
    	DatagramPacket recePack=new DatagramPacket(buf,buf.length);
    	try {
			dsocketRece.receive(recePack);
		} catch (IOException e) {
			e.printStackTrace();
		}
    	String text=new String(recePack.getData(),0,recePack.getLength())+"\n";
    	ta.appendText(text);
    }
    public void send() {
    	try {
    		byte[] pack=(ipField.getText()+tf.getText()).getBytes();
    		DatagramPacket sendPack=new DatagramPacket(pack,pack.length,InetAddress.getByName("171.221.129.154"),10003);
    		dsocketSend.send(sendPack);
    		tf.setText("");
    	}catch(IOException ex) {
    		ex.printStackTrace();
    	}
    }
}
