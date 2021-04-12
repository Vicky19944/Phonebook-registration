package com.registration.entity;

import lombok.Data;

@Data
public class UnlockAcc {
	private String email;
	private String temPassword;
	private String newPassword;
	private String conformPassword;

}
