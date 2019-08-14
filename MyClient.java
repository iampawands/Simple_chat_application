import java.net.*;
import java.lang.*;
import java.io.*;

public class MyClient{
	public static void main(String[] args){
		
		try{
			Socket s = new Socket("localhost",6600);
		DataInputStream dis = new DataInputStream(s.getInputStream());
		DataOutputStream dout = new DataOutputStream(s.getOutputStream());
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str="",str2="";
		while(!str.equals("stop")){
			System.out.print("You : ");
		    str = br.readLine();
			dout.writeUTF(str);
			dout.flush();
			str2 = dis.readUTF();
			System.out.println("Server says : "+str2);
		}
		
		dout.flush();
		dout.close();
		s.close();
		}
		catch(Exception e){
		e.printStackTrace();
		}
	}
}