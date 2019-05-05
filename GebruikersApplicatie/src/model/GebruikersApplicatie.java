package model;

import java.io.FileNotFoundException;
import java.io.InvalidClassException;
import java.util.ArrayList;
import java.util.List;

import controller.ControllerData;
import jserial.jSerialcomm;
import persistance.SerializeHandler;

public class GebruikersApplicatie {

	private SerializeHandler SerializeHandler = new SerializeHandler();
	private List deviceList = new ArrayList<Device>();
	private List clusterList = new ArrayList<Cluster>();
	private boolean directToArduino = true;

	public GebruikersApplicatie() {
		
		System.out.println("Direct to Arduino mode is: " + directToArduino );
		if(directToArduino) {
			
			System.out.println("No data wil be send to server.");}
		if(!jSerialcomm.connect()) {
			System.out.println("Arduino not found, no external communication possible. Connect Arduino or change settings.");}
		
	

		try {

			setDeviceList(SerializeHandler.loadDeviceList());
			setClusterList(SerializeHandler.loadClusterList());
		} catch (InvalidClassException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		

	}

	public boolean isDirectToArduino() {
		return directToArduino;
	}

	public void setDirectToArduino(boolean directToArduino) {
		this.directToArduino = directToArduino;
	}

	public List getClusterList() {
		return clusterList;
	}

	public void setClusterList(List clusterList) {
		this.clusterList = clusterList;
	}

	public List getDeviceList() {
		return deviceList;
	}

	public void setDeviceList(List deviceList) {
		this.deviceList = deviceList;
	}

}
