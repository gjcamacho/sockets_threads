import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class Client extends Thread {

	private boolean die;
	private boolean pause;
	private String ip;
	private int port;
	private int id;
	Socket socket;

	public Client(int id,String ip, int port) {
		// TODO Auto-generated constructor stub
		
		this.id=id;
		this.ip=ip;
		this.port=port;
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
	
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		while(!die){
			while(!pause){
				System.out.println("Cliente: Arrancando");
				try {
					System.out.println("Cliente: inicializando socket");
					
					if(socket==null){
						socket=new Socket(ip,port);
					}
					
					System.out.println("Cliente: Conexion hecha");
					
					DataInputStream dis=new DataInputStream(socket.getInputStream());
					DataOutputStream dos=new DataOutputStream(socket.getOutputStream());
					
					System.out.println("Cliente: Enviando datos");
					Thread.sleep(100);
					int j=0;
					
					dos.writeBytes("test!!\n");
					
					System.out.println("Cliente: datos enviados");
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				
				pause=true;
				die=true;
				
			}
		}
	}

	
	
}
