package connectionPool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Saar.Carmel
 *
 */
public class ConnectionPool implements Runnable {
	private String url;
	private String username;
	private String password;
	private int maxConnections;
	private boolean waitIfBusy;
	private List<Connection> availableConnections;
	private List<Connection> busyConnections;
	private boolean connectionPending = false;
	private String driver = "com.mysql.jdbc.Driver";
	public ConnectionPool() {
		super();
	}

	/**
	 * 
	 * @param url
	 * @param username
	 * @param password
	 * @throws SQLException
	 */
	public ConnectionPool(String url, String username, String password) throws SQLException {
		this(url, username, password, 3, 10, true);
	}

	/**
	 * 
	 * @param url
	 * @param username
	 * @param password
	 * @param initialConnections
	 * @param maxConnections
	 * @param waitIfBusy
	 * @throws SQLException
	 */
	public ConnectionPool(String url, String username, String password, int initialConnections, int maxConnections,
			boolean waitIfBusy) throws SQLException {
		this.url = url;
		this.username = username;
		this.password = password;
		this.maxConnections = maxConnections;
		this.waitIfBusy = waitIfBusy;
		if (initialConnections > maxConnections) {
			initialConnections = maxConnections;
		}
		availableConnections = new ArrayList<>(initialConnections);
		busyConnections = new ArrayList<>();
		for (int i = 0; i < initialConnections; i++) {
			availableConnections.add(makeNewConnection());
		}
	}

	/**
	 * 
	 * @return Connection
	 * @throws SQLException
	 */
	public synchronized Connection getConnection() throws SQLException {
		if (!availableConnections.isEmpty()) {
			int lastIndex = availableConnections.size() - 1;
			Connection existingConnection = availableConnections.get(lastIndex);
			availableConnections.remove(lastIndex);
			if (existingConnection.isClosed()) {
				notifyAll();
				return (getConnection());
			} else {
				busyConnections.add(existingConnection);
				return (existingConnection);
			}
		} else {
			if ((totalConnections() < maxConnections) && !connectionPending) {
				makeBackgroundConnection();
			} else if (!waitIfBusy) {
				throw new SQLException("Connection limit reached");
			}
			try {
				wait();
			} catch (InterruptedException ie) {
			}
			return (getConnection());
		}
	}

	private void makeBackgroundConnection() {
		connectionPending = true;
		try {
			Thread connectThread = new Thread(this);
			connectThread.start();
		} catch (OutOfMemoryError oome) {
		}
	}

	public void run() {
		try {
			Connection connection = makeNewConnection();
			synchronized (this) {
				availableConnections.add(connection);
				connectionPending = false;
				notifyAll();
			}
		} catch (Exception e) {
		}
	}

	/**
	 * 
	 * @return
	 * @throws SQLException
	 */
	private Connection makeNewConnection() throws SQLException {
		try{
		Class.forName(driver);
		} catch(ClassNotFoundException e){
			
		}
		Connection connection = DriverManager.getConnection(url, username, password);
		return (connection);
	}

	/**
	 * 
	 * @param connection
	 */
	public synchronized void free(Connection connection) {
		busyConnections.remove(connection);
		availableConnections.add(connection);
		notifyAll();
	}

	/**
	 * 
	 * @return
	 */
	public synchronized int totalConnections() {
		return (availableConnections.size() + busyConnections.size());
	}

	public synchronized void closeAllConnections() {
		closeConnections(availableConnections);
		availableConnections = new ArrayList<>();
		closeConnections(busyConnections);
		busyConnections = new ArrayList<>();
	}

	/**
	 * 
	 * @param connections
	 */
	private void closeConnections(List<Connection> connections) {
		connections.forEach(connection -> {
			try {
				if (!connection.isClosed()) {
					connection.close();
				}
			} catch (SQLException sqlException) {
			}
		});

	}

	public synchronized String toString() {
		String information = "ConnectionPool(" + url + "," + username + ")" + ", available="
				+ availableConnections.size() + ", busy=" + busyConnections.size() + ", max=" + maxConnections;
		return (information);
	}
}