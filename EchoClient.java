import java.io.*;
import java.net.*;
 
public class EchoClient {
    public static void main(String[] args) throws IOException {
         
        
        try (
            Socket echoSocket = new Socket("localhost", 6124);
            PrintWriter out =
                new PrintWriter(echoSocket.getOutputStream(), true);
            BufferedReader read =
                new BufferedReader(
                    new InputStreamReader(echoSocket.getInputStream()));
            BufferedReader stdIn =
                new BufferedReader(
                    new InputStreamReader(System.in))
        ) {
            String userInput;
            while ((userInput = stdIn.readLine()) != null) {
                out.println(userInput);
                System.out.println("echo: " + read.readLine());
            }
        } catch (UnknownHostException e) {
            System.err.println("Host is unknown " );
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Connection unknown"
                );
            System.exit(1);
        } 
    }
}