import java.net.Socket;
import java.util.Scanner;
import java.io.*;

public class ConnectionBuilder {
    public static String ip = "127.0.0.1";//loopback ip
    public static int port = 8080;//0 - 65000

    public static void main(String[] args) {
        new ConnectionBuilder().build();
    }

    public void build(){
        try{
        System.out.println("Start Connecting");

        Socket connection = new Socket(ip,port);

        System.out.println("Connected");

        OutputStream out = connection.getOutputStream();
        PrintStream writer = new PrintStream(out);
        writer.println("Hello Internet");
        System.out.println("Text Sent");

        InputStream inputStream = connection.getInputStream();
        Scanner scanner = new Scanner(inputStream);
        String receivedText = scanner.nextLine();
        System.out.println("Text Received: "+receivedText);

        connection.close();

        }catch(Exception exception){
            System.out.println("Failed");
        }
    }
}
