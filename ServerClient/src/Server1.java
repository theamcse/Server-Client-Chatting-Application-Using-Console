import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server1 {
	Server1() throws IOException{
		System.out.println("-X-X-X-X-X-X-X---Server Side---X-X-X-X-X-X-X-");
		ServerSocket ss = new ServerSocket(3333);
		Socket s = ss.accept();
		while(true){
		DataInputStream din= new DataInputStream(s.getInputStream());
		DataOutputStream dout = new DataOutputStream(s.getOutputStream());

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str=" ";
		String str2=" ";
		
		
		str2=br.readLine();
		
		dout.writeUTF(str2);
		str=din.readUTF();
		System.out.println("Client >> "+ str);
		if(str.equals("Stop")){
			break;
		}	
	}
		ss.close();
		s.close();
		
	}
	public static void main(String[] args) throws Exception {
		try{
			new Server1();
		}catch(Exception e){
			System.out.println("End of Commmunication");
		}

	}

}
