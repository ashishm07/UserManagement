package in.nic;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Employee {
	
	private String name;
	private int empNo;
	
	public Employee(String name, int empNo) {
		// TODO Auto-generated constructor stub
		this.name =name;
		this.empNo = empNo;
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
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", empNo=" + empNo + "]";
	}
	
	
}
