package pkg;

public class CapBean {
	private String name;
	private String capName;
	public CapBean() {
		this.name = "";
		this.capName = "";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCapName() {
		return capName;
	}
	public void setCapName(String capName) {
		this.capName = capName;
	}
	public void convert() {
		this.capName = this.name.toUpperCase();
	}
}



