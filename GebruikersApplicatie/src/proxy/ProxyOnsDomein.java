package proxy;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ProxyOnsDomein {

ConnectionSettings conSettings = new ConnectionSettings();

	private Scanner inServer;
	private PrintWriter outServer;

	Socket socket;

	private boolean connectToServer(String client_id) {

		Socket socket = null;

		try {
			socket = new Socket();
			socket.connect(new InetSocketAddress(conSettings.SERVER_IP, conSettings.PORT), conSettings.timeout);

		} catch (IOException e) {

			System.out.println("Kan geen verbinding maken.");
			try {
				socket.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			return false;

		}

		try {
			inServer = new Scanner(socket.getInputStream());
			outServer = new PrintWriter(socket.getOutputStream());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		boolean reactionFromServer = true;
		while (reactionFromServer) {
			String reaction = inServer.nextLine();

			if (reaction.equals("Who are you?")) {
				reactionFromServer = false;
				outServer.println(client_id);
				System.out.println(client_id);
				outServer.flush();
			}
		}

		try {
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	/**
	 * Method to connect a client with the server. Used for both the GA and the HC
	 * 
	 * @param client_id, Unique String that describes the client.
	 * @throws IOException, this method can produce a IOException, always use in
	 *                      Try/catch block
	 */
	public boolean connectClientToServer(String client_id) {

		if (connectToServer(client_id)) {
			System.out.println("Verbinding met server gemaakt!");
			return true;
		}
		System.out.println("Geen verbinding met server gemaakt.");
		return false;
	}

	/**
	 * Method for GA to use. Used for sending requests to HC
	 * 
	 * @param requestFromId, String with unique id from requester (GA)
	 * @param requestForId   String with unique id from receiver (HC)
	 * @param message        String containing the message for receiver (HC)
	 * @return String with the response from receiver to requester (HC responds to
	 *         GA)
	 */
	public String sendRequest(String requestFromId, String requestForId, String message) {

		String request = requestFromId + ";" + requestForId + ";" + message;
		outServer.println(request);
		outServer.flush();
		return receiveRequest();
	}

	/**
	 * Method only used by GA because HC needs a permanent connection Use to close
	 * the connection with the server (and save some kb's on your bundle)
	 */
	public void closeConnection() {
		if (inServer != null && outServer != null) {
			inServer.close();
			outServer.close();
		}
		return;
	}

	/**
	 * Method used by HC to listen for incoming requests and used by proxy to return
	 * the response from HC
	 * 
	 * @return string, String with: 1) a request for a HC 2) the response from HC
	 */
	public String receiveRequest() {
		return inServer.nextLine();
	}
}
