package com.registration.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "Country_Info")
@Data
public class Country {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer countryId;

	@Column(name = "User_Id")
	public Integer userId;

	@Column(name = "Country_Name")
	private String countryName;

	@Column(name = "County_Code")
	private Integer countryCode;

}
