package com.registration.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "State_Info")
@Data
public class State {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer stateId;

	@Column(name = "Country_Id")
	public Integer countryId;

	@Column(name = "State_Name")
	private String stateName;

	@Column(name = "State_Code")
	private Integer stateCode;

}
