import java.net.*;
import java.io.*;
import java.util.Scanner;
//jobCreator creates job, connects to jobSeeker, gives job, waits for job to finish and come back.
//create job with type, computational task    i.e multiply, 2, 5. addition,subtraction,division,multiplication
public class JobCreator{ //client
    public static void main(String[] args) throws IOException{
        String jobType;
        int var1;
        int var2;
        try{
        Socket s = new Socket("localhost", 4999);

        PrintWriter pr = new PrintWriter(s.getOutputStream());
        Scanner sc = new Scanner(System.in);
        //get job from user. one of the 4 types
        System.out.println("Enter job type: addition, subtraction, division, or multiplication");
        jobType = sc.nextLine();
        pr.println(jobType);
        pr.flush();
        //get two ints from users
        System.out.println("Enter 2 numbers");
        var1 = sc.nextInt();
        var2 = sc.nextInt();
        pr.println(var1);
        pr.flush();
        pr.println(var2);
        pr.flush();
        //get response
        InputStreamReader in = new InputStreamReader(s.getInputStream());
        BufferedReader bf = new BufferedReader(in);

        String str = bf.readLine();
        System.out.println("JobSeeker: "+ str+"\n");

        str = bf.readLine();
        System.out.println("JobSeeker: "+ str);
        }catch(IOException e){
            System.out.println("Connection failed. Abort");
        }
    }
}