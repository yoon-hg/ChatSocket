package serverChatVer01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketMain {

    public static void main(String[] args){
        System.out.println("hello socket start");
        try{
            ServerSocket serverSocket = new ServerSocket(8888);
            Socket socket = serverSocket.accept();

            //socket 통신으로 data 읽어 오기
            ReceiveThread receiveThread = new ReceiveThread();
            receiveThread.setSocket(socket);

            //socket 통신으로 data 보내기
            SendThread sendThread = new SendThread();
            sendThread.setSocket(socket);

            receiveThread.start();
            sendThread.start();

        } catch (IOException e){
            e.printStackTrace();
        }
    }

}
