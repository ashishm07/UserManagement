package in.nic;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Employee {
	
	private String name;
	private int id;
	
	public Employee(String name, int id) {
		// TODO Auto-generated constructor stub
		this.name =name;
		this.id = id;
	}
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getid() {
		return id;
	}
	public void setid(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", id=" + id + "]";
	}
	
	
}
