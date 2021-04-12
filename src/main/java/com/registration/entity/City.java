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
@Table(name = "City_Info")
@Data
public class City {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer cityId;

	@Column(name = "State_Id")
	public Integer stateId;

	@Column(name = "City_Name")
	private String cityName;

	@Column(name = "Country_Code")
	private Integer cityCode;

}
