import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ConnectionReceiver {
    public static int port = 8080;

    public static void main(String[] args) {
        byte[] data = "Hello World".getBytes();

        for(byte b : data){
        System.out.println((int)b);
        }

        //new ConnectionReceiver().receive();
    }

    public void receive(){
        try{
        ServerSocket connectionListener = new ServerSocket(port);

        System.out.println("Listening Connection");
        Socket connection = connectionListener.accept();

        System.out.println("Connected");

        InputStream inputStream = connection.getInputStream();

        Scanner scanner = new Scanner(inputStream);
        String receivedText = scanner.nextLine();
        System.out.println("Text Received: "+receivedText);

        OutputStream out = connection.getOutputStream();
        PrintStream writer = new PrintStream(out);
        writer.println("You too");
        System.out.println("Text Sent");


        connection.close();
        }catch(Exception e){
            System.out.println("Failed");
        }
    }
}
