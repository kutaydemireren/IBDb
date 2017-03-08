package domain;

public class PublishingCompany {
	private int pid;
	private String location;
	private String name;
	
	public PublishingCompany(int pid, String location, String name) {
		super();
		this.pid = pid;
		this.location = location;
		this.name = name;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "PublishingCompany [location=" + location + ", name=" + name + "]";
	}
	
	public String toHTML() {
		return "<tr><td>" + name + "</td><td>" + location + "</td><td></tr>";
	}
}
