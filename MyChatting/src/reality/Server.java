package reality;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Server extends Application{
	
	private Hashtable outputStreams = new Hashtable();
	private TextField tf=new TextField();
	private TextArea ta=new TextArea();
	private Socket socket;
	private String target;
	private DataOutputStream dos;
	private DataInputStream dis;
	private ServerSocket serversocket;
	private DatagramSocket dsocketSend;
	private DatagramSocket dsocketRece;
	public static void main(String[] args) throws IOException {
		Application.launch(args);
	}
	

	@Override
	public void start(Stage primaryStage) throws Exception {

			 dsocketSend=new DatagramSocket(10002);
			 dsocketRece=new DatagramSocket(10003);
		     BorderPane paneForTextField=new BorderPane();
		     paneForTextField.setPadding(new Insets(5,5,5,5));
		     paneForTextField.setStyle("-fx-border-color:green");
		     paneForTextField.setLeft(new Label("Enter your message: "));
		     
		     tf=new TextField();
		     tf.setAlignment(Pos.BOTTOM_RIGHT);
		     paneForTextField.setCenter(tf);
		     
		     BorderPane mainPane=new BorderPane();
		     ta=new TextArea();
		     mainPane.setCenter(new ScrollPane(ta));
		     mainPane.setTop(paneForTextField);
		     
		     Scene scene=new Scene(mainPane,450,200);
		     primaryStage.setTitle("Myserver");
		     primaryStage.setScene(scene);
		     primaryStage.show();
		     new Thread(() -> listen()).start();
             new Thread(()->receive()).start();
		}
		public void listen() {
			try {
				serversocket=new ServerSocket(8000);
				while(true){
					Socket socket=serversocket.accept();
					Platform.runLater(()->
					ta.appendText("Connection from"+socket+"at"+new Date()+'\n'));
				       DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
				}

			}catch(IOException ex) {
				ex.printStackTrace();
			}
		}
        public void receive() {
        	while(true) {
        	byte[] buf=new byte[1024];
        	DatagramPacket dp=new DatagramPacket(buf,buf.length);
        	try {
				dsocketRece.receive(dp);
			} catch (IOException e) {
				e.printStackTrace();
			}
        	String text=new String(dp.getData(),0,dp.getLength())+"\n";
        	target=text.substring(0,11);
        	try {
				dp.setAddress(InetAddress.getByName(target));
				dp.setPort(10004);
				dsocketSend.send(dp);
			} catch (IOException e) {
				e.printStackTrace();
			}
        	}
        }

		}
	
	

