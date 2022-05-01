package homeworks;

import javafx.application.Application;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Hw31_4_Client extends Application {
    public static void main(String[] args) throws Exception {launch(args);}
    public Text text= new Text();
    public Pane pane = new Pane();

    public void start(Stage stage) throws Exception {
        Socket socket = new Socket("127.0.0.1",8000);
        System.out.println("Connected to server");
        Scanner sc = new Scanner(System.in);
        DataOutputStream out = new DataOutputStream((socket.getOutputStream()));
        DataInputStream in = new DataInputStream((socket.getInputStream()));

        String computerName = java.net.InetAddress.getLocalHost().getCanonicalHostName();
        String name = computerName + "1";
        out.writeUTF(name);

        while (true){
            System.out.println("Write a double value(7 - exit)" + " Name: " + name);
            double a =  sc.nextDouble();
            if (a==7) break;
            out.writeDouble(a);
            System.out.println("Reply from server"+in.readDouble());

        }
    }
}