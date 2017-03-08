package ibdb.src.domain;

public class Library {
	private int lib;
	private String location;
	private String name;

	public Library(int lib, String location, String name) {
		this.lib = lib;
		this.location = location;
		this.name = name;
	}

	public int getLib() {
		return lib;
	}

	public void setLib(int lib) {
		this.lib = lib;
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
		return "Library [location=" + location + ", name=" + name + "]";
	}

	public String toHTML() {
		return "<tr><td>" + name + "</td><td>|  " + location + "</td><td></tr>";
	}
}
