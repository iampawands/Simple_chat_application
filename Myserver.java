import java.net.*;
import java.lang.*;
import java.io.*;

public class Myserver{
	public static void main(String []args){
		try{
		ServerSocket serversocket = new ServerSocket(6600);
		Socket s = serversocket.accept();
		DataInputStream dis = new DataInputStream(s.getInputStream());
		DataOutputStream dout = new DataOutputStream(s.getOutputStream());
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	     
		 String str="",str2="";
         
		while(str != "stop"){
		     str = (String)dis.readUTF();
			 System.out.println("Client says: "+str);
			 System.out.print("You : ");
			 str2 = br.readLine();
			 dout.writeUTF(str2);
			 dout.flush();
		}
		
		dis.close();
		serversocket.close();
		s.close();
	
		}
		catch(Exception e){
		e.printStackTrace();
		}
		
		
	}
}