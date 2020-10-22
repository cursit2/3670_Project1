import java.net.*;
import java.io.*;
import java.util.Scanner;
//jobCreator creates job, connects to jobSeeker, gives job, waits for job to finish and come back.
public class JobCreator{ //client
    public static void main(String[] args) throws IOException{
        try{
        Socket s = new Socket("localhost", 4999);

        PrintWriter pr = new PrintWriter(s.getOutputStream());
        Scanner sc = new Scanner(System.in);
        String job = sc.nextLine();

        pr.println(job);
        pr.flush();

        InputStreamReader in = new InputStreamReader(s.getInputStream());
        BufferedReader bf = new BufferedReader(in);

        String str = bf.readLine();
        System.out.println("server: "+ str);
        }catch(IOException e){
            System.out.println("Connection failed. Abort");
        }
    }
}