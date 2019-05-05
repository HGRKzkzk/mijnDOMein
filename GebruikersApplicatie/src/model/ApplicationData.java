package model;

import java.util.ArrayList;
import java.util.List;

import persistance.SerializeHandler;

public class ApplicationData {
	
	SerializeHandler SerializeHandler = new SerializeHandler();
	List deviceList = new ArrayList<Device>();
	List clusterList = new ArrayList<Cluster>();
	

}
