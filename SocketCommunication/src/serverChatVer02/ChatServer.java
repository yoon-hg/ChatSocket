package serverChatVer02;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ChatServer {

    public static ArrayList<PrintWriter> mOutputList;

    public static void main(String[] args){
        mOutputList = new ArrayList<PrintWriter>();

        try{
            ServerSocket serverSocket = new ServerSocket(8888);

            while (true){
                Socket clientSocket = serverSocket.accept();
                ClientManagerThread clientThread = new ClientManagerThread();
                clientThread.setSocket(clientSocket);

                mOutputList.add(new PrintWriter(clientSocket.getOutputStream()));

                clientThread.start();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
