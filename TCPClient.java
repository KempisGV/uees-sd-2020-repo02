import java.io.OutputStream;  import java.net.InetAddress;  import java.net.Socket;
import java.util.Random;

public class TCPClient {

  public static final void main(final String[] args) {
    Socket        client;
    OutputStream  os;
    InetAddress   ia;

    try {
      ia = InetAddress.getByName("10.10.10.1");//get local host address
      
      client = new Socket(ia, 9999); //create socket (*@\clientBox{1+2)}@*)
      
      Random rand = new Random();
      int random_number = rand.nextInt((10-1)+1)+1;

      os = client.getOutputStream(); //get stream to write to
      os.write(random_number);  //escribe un int del 1 al 10 (*@\clientBox{3)}@*)
      
      client.close(); //close (*@\clientBox{4)}@*)
    } catch (Throwable t) {
      t.printStackTrace();
    }
  }
}