import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class SocketClientMain {

    public static String userID;

    public static void main(String[] args){
        System.out.println("hello go to ServerSocket");

        try {
            Socket socket = new Socket("192.168.62.56", 8888);

            //서버의 data 읽어 오기
            ReceiveThread receiveThread = new ReceiveThread();
            receiveThread.setSocket(socket);

            //서버의 data 보내기
            SendThread sendThread = new SendThread();
            sendThread.setSocket(socket);

            sendThread.start();
            receiveThread.start();

        } catch (IOException e){
            e.printStackTrace();
        }

    }
}
