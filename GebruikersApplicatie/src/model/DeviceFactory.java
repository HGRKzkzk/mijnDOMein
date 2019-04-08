package model;

public class DeviceFactory {
	
	
	
	 public Device getDevice(String devicetype, String name, int port, boolean analoog) {
		 	
		 		
		 switch(devicetype) {
 
		 case "Alleen uitleesbaar": 
			 return new ReadableDevice(name, port);

		 case "Schakelbaar": 
			 return new SwitchableDevice(name, port);

		 case "Dimbaar": 
			 return new DimmableDevice(name, port);	 

		 }

		 return null; 
	 }
	        

}
