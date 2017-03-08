package ibdb.src.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.ResourceBundle;
import db_interface.*;

public class BaseModel {
	private static Connection _conn = null;
	private static ResourceBundle _bundle;

	public String openDBConnection(String bundle) {
		_bundle = ResourceBundle.getBundle(bundle);
		return openDBConnection(
				_bundle.getString("dbUser"),
				_bundle.getString("dbPass"),
				_bundle.getString("dbSID"),
				_bundle.getString("dbHost"),
				Integer.parseInt(_bundle.getString("dbPort"))
				);
	}

	public String openDBConnection(String dbUser, String dbPass, String dbSID, String dbHost, int port) {

		String res="";
		if (_conn != null) {
			closeDBConnection();
		}

		try {
			_conn = DBUtils.openDBConnection(dbUser, dbPass, dbSID, dbHost, port);
			res = DBUtils.testConnection(_conn);
		} catch (SQLException sqle) {
			sqle.printStackTrace(System.err);
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace(System.err);
		}
		return res;
	}

	public void closeDBConnection() {
		try {
			DBUtils.closeDBConnection(_conn);
			System.out.println("Closed a connection");
		} catch (SQLException sqle) {
			sqle.printStackTrace(System.err);
		}
	}

	public Statement createStatement() throws SQLException {
		Statement st = _conn.createStatement();
		return st;
	}
}
