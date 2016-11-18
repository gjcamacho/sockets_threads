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
		int k=0;
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
					
					ServerSocketThread sst=new ServerSocketThread(k,socket);
					k++;
					
					sst.start();
					
					pause=true;
					die=true;
					
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
			
		}
		
	}

}
