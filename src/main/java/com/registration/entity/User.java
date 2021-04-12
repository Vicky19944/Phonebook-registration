package com.registration.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import javax.persistence.Id;

import lombok.Data;

@Entity
@Table(name = "User_Details")
@Data
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer userId;

	@Column(name = "Frist_name")
	@NotBlank(message = "First name must not empty..!!")
	public String Fname;

	@Column(name = "Last_name")
	@NotBlank(message = "Last name must not empty..!!")
	public String Lname;

	@Column(unique = true, name = "Email_id")
	@Email(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")
	public String email;

	@Column(name = "Ph_No")
	@NotBlank(message = "phone no must not empty..!!")
	public String Phno;

	@Column(name = "D.O.B")
	public String[] Dob;

	@Column(name = "Gender")
	public byte Gender;

	@Column(name = "Password")
	@NotBlank
	@Size(min = 8, max = 16, message = "Password size must be between 8-16 charector..!!")
	public String Password;

	@Column(name = "Account_Status")
	public String accountStatus;
}
