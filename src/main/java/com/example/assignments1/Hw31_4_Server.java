package homeworks;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Hw31_4_Server extends Application {
    public static int clientNum = 0;
    public  static final int pincode = (int)(Math.random()*((999999-111111)+1))+111111;
    public void start(Stage stage) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8000);
        while (true) {
            System.out.println("Waiting for connection...");
            System.out.println("PIN: " + pincode);
            Socket socket =  serverSocket.accept();
            clientNum++;
            System.out.println(clientNum + "peoples connection");
            if (clientNum==10)break;
            HandleClient handleClient = new HandleClient(socket);
            Thread thread = new Thread(handleClient);
            thread.start();
        }
    }
}
class HandleClient implements Runnable {
    Socket socket;
    HandleClient(Socket socket) {this.socket = socket;}
    @Override
    public void run() {
        try {
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            String name = dataInputStream.readUTF();
            while (true) {
                try {
                    double a2 =dataInputStream.readDouble()*2;
                    dataOutputStream.writeDouble(a2);
                    System.out.println(name);
                } catch (Exception e) {e.printStackTrace();}
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
