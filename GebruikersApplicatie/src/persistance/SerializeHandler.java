package persistance;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import model.Device;
import model.Cluster;
import view.Main;

public class SerializeHandler {

	private ArrayList<Device> deviceList = Main.deviceList;
	private ArrayList<Cluster> clusterList = Main.clusterList;

	public void saveAsSerializedData() {

		saveDeviceList();
		saveClusterList();

	}

	public void saveDeviceList() {
		deviceList = Main.deviceList;
		String naam = "devices";
		File file = new File(naam);

		FileOutputStream fileOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		ObjectOutputStream objectOutputStream = null;
		try {
			objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(deviceList);
			objectOutputStream.flush();
		} catch (IOException e) {
			e.printStackTrace();

		} finally {

			try {
				objectOutputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	public void saveClusterList() {
		clusterList = Main.clusterList;
		String naam = "clusters";
		File file = new File(naam);

		FileOutputStream fileOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		ObjectOutputStream objectOutputStream = null;
		try {
			objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(clusterList);
			objectOutputStream.flush();
		} catch (IOException e) {
			e.printStackTrace();

		} finally {

			try {
				objectOutputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	public void loadFromSerializedData() throws FileNotFoundException, InvalidClassException, ClassNotFoundException {

		loadClusterList();
		loadDeviceList();

	}

	@SuppressWarnings("unchecked")
	public ArrayList<Cluster> loadClusterList()
			throws FileNotFoundException, ClassNotFoundException, InvalidClassException {
		ArrayList<Cluster> clusterlist = new ArrayList<Cluster>();
		String naam = "clusters";
		File file = new File(naam);
		FileInputStream fileInputStream = null;
		fileInputStream = new FileInputStream(file);

		ObjectInputStream objectInputStream = null;

		try {
			objectInputStream = new ObjectInputStream(fileInputStream);
			clusterlist = (ArrayList<Cluster>) objectInputStream.readObject();
			return clusterlist;

		} catch (IOException e) {
			// e.printStackTrace();
			throw new InvalidClassException(null);

		} finally {

			try {
				objectInputStream.close();
			} catch (IOException e) {
				throw new RuntimeException("Dit zou nooit voor moeten kunnen komen", e);

			}

		}

	}

	@SuppressWarnings("unchecked")
	public ArrayList<Device> loadDeviceList() {
		ArrayList<Device> deviceList = new ArrayList<Device>();
		String naam = "devices";
		File file = new File(naam);
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(file);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		ObjectInputStream objectInputStream = null;

		try {

			objectInputStream = new ObjectInputStream(fileInputStream);
			deviceList = (ArrayList<Device>) objectInputStream.readObject();
			return deviceList;

		} catch (IOException e) {
			// e.printStackTrace();
			try {
				throw new InvalidClassException(null);
			} catch (InvalidClassException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				objectInputStream.close();
			} catch (IOException e) {
				throw new RuntimeException("Dit zou nooit voor moeten kunnen komen", e);

			}

		}

		return deviceList;

	}

}