import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client1 {
	Client1() throws Exception, IOException{
		Socket s=new Socket("192.168.43.206", 3333);
		System.out.println("-X-X-X-X-X-X-X---Client Side---X-X-X-X-X-X-X-");
		while(true){
		DataInputStream din = new DataInputStream(s.getInputStream());
		DataOutputStream dout = new DataOutputStream(s.getOutputStream());
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str=" ";
		String str2=" ";
		
		str=din.readUTF();
		System.out.println("Server >> "+ str);
		if(str.equals("Stop")){
			break;
		}		
		str2=br.readLine();
		
		dout.writeUTF(str2);
		}
		s.close();
	}
	
	public static void main(String[] args) throws Exception, Exception {
		try{
			new Client1();
		}catch(Exception e){
			System.out.println("End of Commmunication");
		}
	}
}


