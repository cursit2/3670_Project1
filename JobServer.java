import java.net.*;
import java.io.*;
//job seeker waits for jobSeeker to connect, accepts job request, does job, reports back
public class JobSeeker{ //server
    public static void main(String[] args) throws IOException{
        ServerSocket ss = new ServerSocket(4999);
        Socket s = ss.accept();

        System.out.println("JobCreator connected. Waiting for Job...");
        InputStreamReader in = new InputStreamReader(s.getInputStream());
        BufferedReader bf = new BufferedReader(in);

        String jobString = bf.readLine();
        System.out.println("client: "+ jobString);

        PrintWriter pr = new PrintWriter(s.getOutputStream());
        pr.println("Understood");
        pr.flush();

    }
}
