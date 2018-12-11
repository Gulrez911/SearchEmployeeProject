package com.kgate.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import static javax.swing.text.StyleConstants.Size;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "employee123")

public class Employee implements Serializable {

	private static final long serialVersionUID = -3465813074586302847L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "join_employee_skill", joinColumns = { @JoinColumn(name = "id") }, inverseJoinColumns = {
			@JoinColumn(name = "skill_Id") })
	private List<Skill> listSkill = new ArrayList<Skill>();

	@Transient
	private List<String> skills = new ArrayList<>();

	@Column
	private String otp;

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public List<Skill> getListSkill() {
		return listSkill;
	}

	public void setListSkill(List<Skill> listSkill) {
		this.listSkill = listSkill;
	}

	@Column
	@NotEmpty(message = "Please enter your name.")
	private String name;

	@Column
	@NotEmpty(message = "Please enter your email.")
	@Email
	private String email;

	@Column
	private String address;

	@Column
	private String telephone;
<<<<<<< HEAD

	@Column
	private String category;
	
    @Column
    private String password;
    
    
=======

	@Column
	private String category;
>>>>>>> branch 'master' of https://github.com/Gulrez911/SearchEmployeeProject.git

	@Column
	private String status;

<<<<<<< HEAD
	
=======
	@Column
	private String password;
>>>>>>> branch 'master' of https://github.com/Gulrez911/SearchEmployeeProject.git

	@Column
<<<<<<< HEAD
	private int managerId;
=======
>>>>>>> branch 'master' of https://github.com/Gulrez911/SearchEmployeeProject.git

<<<<<<< HEAD
	public int getId() {
		return id;
=======
	private int managerId;
	public String getAadhar() {
		return aadhar;
>>>>>>> branch 'master' of https://github.com/Gulrez911/SearchEmployeeProject.git
	}

<<<<<<< HEAD
	public void setId(int id) {
		this.id = id;
=======
	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
>>>>>>> branch 'master' of https://github.com/Gulrez911/SearchEmployeeProject.git
	}

<<<<<<< HEAD
	public String getName() {
		return name;
=======
	public String getPan() {
		return pan;
>>>>>>> branch 'master' of https://github.com/Gulrez911/SearchEmployeeProject.git
	}

<<<<<<< HEAD
	public void setName(String name) {
		this.name = name;
=======
	public void setPan(String pan) {
		this.pan = pan;
>>>>>>> branch 'master' of https://github.com/Gulrez911/SearchEmployeeProject.git
	}

<<<<<<< HEAD
	public String getEmail() {
		return email;
	}
=======
	@Column
	private String aadhar;
	@Column
	private String pan;
>>>>>>> branch 'master' of https://github.com/Gulrez911/SearchEmployeeProject.git

<<<<<<< HEAD
	public void setEmail(String email) {
		this.email = email;
=======
	public int getId() {
		return id;
>>>>>>> branch 'master' of https://github.com/Gulrez911/SearchEmployeeProject.git
	}

<<<<<<< HEAD
	public String getAddress() {
		return address;
=======
	public void setId(int id) {
		this.id = id;
>>>>>>> branch 'master' of https://github.com/Gulrez911/SearchEmployeeProject.git
	}

<<<<<<< HEAD
	public void setAddress(String address) {
		this.address = address;
=======
	public String getName() {
		return name;
>>>>>>> branch 'master' of https://github.com/Gulrez911/SearchEmployeeProject.git
	}

<<<<<<< HEAD
	public String getTelephone() {
		return telephone;
=======
	public void setName(String name) {
		this.name = name;
>>>>>>> branch 'master' of https://github.com/Gulrez911/SearchEmployeeProject.git
	}

<<<<<<< HEAD
	public void setTelephone(String telephone) {
		this.telephone = telephone;
=======
	public String getEmail() {
		return email;
>>>>>>> branch 'master' of https://github.com/Gulrez911/SearchEmployeeProject.git
	}

<<<<<<< HEAD
	public List<String> getSkills() {
		return skills;
=======
	public void setEmail(String email) {
		this.email = email;
>>>>>>> branch 'master' of https://github.com/Gulrez911/SearchEmployeeProject.git
	}

<<<<<<< HEAD
	public void setSkills(List<String> skills) {
		this.skills = skills;
=======
	public String getAddress() {
		return address;
>>>>>>> branch 'master' of https://github.com/Gulrez911/SearchEmployeeProject.git
	}

<<<<<<< HEAD
=======
	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public List<String> getSkills() {
		return skills;
	}

	public void setSkills(List<String> skills) {
		this.skills = skills;
	}

>>>>>>> branch 'master' of https://github.com/Gulrez911/SearchEmployeeProject.git
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", listSkill=" + listSkill + ", skills=" + skills + ", otp=" + otp + ", name="
				+ name + ", email=" + email + ", address=" + address + ", telephone=" + telephone + ", category="
				+ category + ", status=" + status + ", password=" + password + ", managerId=" + managerId + ", aadhar="
				+ aadhar + ", pan=" + pan + "]";
	}

<<<<<<< HEAD
=======
	 

>>>>>>> branch 'master' of https://github.com/Gulrez911/SearchEmployeeProject.git
}
