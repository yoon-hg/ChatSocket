import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReceiveThread extends Thread{

    private Socket mSocket;

    @Override
    public void run(){

        super.run();

        try {
            BufferedReader tmpbuf = new BufferedReader(new InputStreamReader(mSocket.getInputStream()));

            String receiveString = "";
            String[] split;

            while(true){
                receiveString = tmpbuf.readLine();

                split = receiveString.split(">");
                if(split.length >= 2 && split[0].equals(SocketClientMain.userID))
                    continue;

                System.out.println(receiveString);

            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void setSocket(Socket socket){
        mSocket = socket;
    }
}
