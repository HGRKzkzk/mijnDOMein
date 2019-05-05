package proxy;

public class ConnectionSettings {
	
	protected int PORT = 8888;
	protected int timeout = 250;
	protected final String SERVER_IP = "192.168.1.104";
	protected final String app_ID = "234";
	
	
	
	public void setServerTimeOut(int ms) {
		
		this.timeout = ms;
		
		
	}
	
	public String getID() {
		
		return this.app_ID;
	}
	

}
