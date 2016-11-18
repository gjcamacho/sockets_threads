import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerSocketThread extends Thread{
	
	private Socket socket;
	private int id;
	private boolean die;
	private boolean pause;

	public ServerSocketThread(int id,Socket socket) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.socket=socket;
	}

	public void run(){
		System.out.println("ServerSocket: Arrancando");
		while(!die){
			while(!pause){
				try {
					DataInputStream dis=new DataInputStream(socket.getInputStream());
					
					BufferedReader buf=new BufferedReader(new InputStreamReader(socket.getInputStream()));
					
					
						Thread.sleep(1000);
					
					int k=0;
					int j=0;
					String buffer="";
					System.out.println("ServerSocket: "+id+" datos leidos: " + buffer);
					
					System.out.println("ServerSocket: "+id+" Apunto de leer datos");
					System.out.println("ServerSocket: "+id+" " + buf.readLine());
					System.out.println("ServerSocket: "+id+" Datos leidos");
				
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
