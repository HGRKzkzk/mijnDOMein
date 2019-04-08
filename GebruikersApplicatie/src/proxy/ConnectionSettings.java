package proxy;

public class ConnectionSettings {
	
	protected int PORT = 8888;
	protected int timeout = 250;
	protected final String SERVER_IP = "192.168.1.104";
	
	
	
	public void setServerTimeOut(int ms) {
		
		this.timeout = ms;
		
		
	}
	

}
