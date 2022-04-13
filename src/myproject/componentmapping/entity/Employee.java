package myproject.componentmapping.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "emp10")
public class Employee {

	@Id
	@Column(name = "eno")
	@GenericGenerator(name = "incGenerator", strategy = "increment")
	@GeneratedValue(generator = "incGenerator")
	private int eno;
	@Column(name = "ename")
	private String ename;
	@Column(name = "esal")
	private float esal;
	@Embedded
	private Account acc;
	@Embedded
	private Address addr;
	
	public int getEno() {
		return eno;
	}
	public void setEno(int eno) {
		this.eno = eno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public float getEsal() {
		return esal;
	}
	public void setEsal(float esal) {
		this.esal = esal;
	}
	public Account getAcc() {
		return acc;
	}
	public void setAcc(Account acc) {
		this.acc = acc;
	}
	public Address getAddr() {
		return addr;
	}
	public void setAddr(Address addr) {
		this.addr = addr;
	}
	
	
}
