package domain;

public class BookFactory {
	private int fid;
	private String name;
	private String location;
	
	public BookFactory(int fid, String name, String location) {
		this.fid = fid;
		this.name = name;
		this.location = location;
	}

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "BookFactory [name=" + name + ", location=" + location + "]";
	}
	
	public String toHTML() {
		return "<tr><td>" + name + "</td><td>" + location + "</td><td></tr>";
	}
}
