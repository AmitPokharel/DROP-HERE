import java.net.*;  // for Socket
import java.io.*;// for IOException and Input/OutputStream
import java.util.*;
public class TCPEchoClient {

  public static void main(String[] args) throws IOException {

    if ((args.length < 2) || (args.length > 3))  // Test for correct # of args
      throw new IllegalArgumentException("Parameter(s): <Server> <Word> [<Port>]");

    String server = args[0];       // Server name or IP address
    // Convert input String to bytes using the default character encoding
    byte[] byteBuffer = args[1].getBytes();

    int servPort = (args.length == 3) ? Integer.parseInt(args[2]) : 7;

    // Create socket that is connected to server on specified port
    Socket socket = new Socket(server, servPort);
    Also obj=new Also();
    System.out.println("Connected to server...sending echo string");

    InputStream in = socket.getInputStream();
    OutputStream out = socket.getOutputStream();

    out.write(byteBuffer);  // Send the encoded string to the server

    // Receive the same string back from the server
    int totalBytesRcvd = 0;  // Total bytes received so far
    int bytesRcvd;           // Bytes received in last read
    while (totalBytesRcvd < byteBuffer.length) {
      if ((bytesRcvd = in.read(byteBuffer, totalBytesRcvd,  
                        byteBuffer.length - totalBytesRcvd)) == -1)
        throw new SocketException("Connection close prematurely");
      totalBytesRcvd += bytesRcvd;
    }

    System.out.println("Received: " + new String(byteBuffer));
    obj.createfolder();

    socket.close();  // Close the socket and its streams
  }
}
class Also
{
	public void createfolder()
	{
		File file = new File("C:\\DROP HERE");
		 if (!file.exists()) {
			file.mkdir();
			System.out.println("Directory is created!");
			} 
		else 
		{
			if(file.isDirectory()){
				 
				if(file.list().length>0){
		 
					System.out.println("Directory is not empty!");
		 
				}else{
		 
					System.out.println("Directory is empty!");
		 
				}
		 
			}else{
		 
				System.out.println("This is not a directory");
		 
			}
		}
	}
}