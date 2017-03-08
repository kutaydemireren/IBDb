package domain;

public class Reader {
	private int rid;
	private String password;
	private String username;
	
	public Reader(int rid, String password, String username) {
		this.rid = rid;
		this.password = password;
		this.username = username;
	}
	
	public int getRid() {
		return rid;
	}
	
	public void setRid(int rid) {
		this.rid = rid;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Override
	public String toString() {
		return "Reader [rid=" + rid + ", username=" + username + "]";
	}
	
	public String toHTML() {
		return "<tr><td>" + username + "</td><td></tr>";
	}
}
