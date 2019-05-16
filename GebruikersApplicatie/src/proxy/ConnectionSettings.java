package proxy;

public class ConnectionSettings {
	
	protected int PORT = 8888;
	protected int timeout = 250;
	protected String SERVER_IP = "192.168.1.100";
	protected String app_ID = "234";
	protected String receiver_ID = "134";	
	
	
	public void setServerTimeOut(int ms) {
		
		this.timeout = ms;
		
		
	}
	
	public String getID() {
		
		return this.app_ID;
	}
	

}
