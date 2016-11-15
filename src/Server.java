import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.CharBuffer;
import java.util.Scanner;

public class Server extends Thread{
	
	ServerSocket serverSocket;
	private boolean die;
	private boolean pause;

	public void init() {
		// TODO Auto-generated method stub
		
		this.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		while(!die){
			while(!pause){
				System.out.println("Arrancando: Server");
				
				if(serverSocket==null){
					try {
						System.out.println("inicializando server");
						serverSocket=new ServerSocket(60000);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				try {
					System.out.println("Escuchando server");
					Socket socket=serverSocket.accept();
					System.out.println("Server: Conexion establecida:");
					
					DataInputStream dis=new DataInputStream(socket.getInputStream());
					
					BufferedReader buf=new BufferedReader(new InputStreamReader(socket.getInputStream()));
					
					Thread.sleep(1000);
					int k=0;
					int j=0;
					String buffer="";
					System.out.println("Server: datos leidos: " + buffer);
					
					System.out.println("Server: Apunto de leer datos");
					System.out.println(buf.readLine());
					System.out.println("Server: Datos leidos");
					
					pause=true;
					die=true;
					
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
			
		}
		
	}

}
