
public class ClientGenerator extends Thread{

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
				System.out.println("Arrancando: ClientGenerator");
				
				Client client=new Client(k, "127.0.0.1", 60000);
				
				client.start();
				
				k++;
				pause=true;
				die=true;
				
			}
		}
		
	}

}
