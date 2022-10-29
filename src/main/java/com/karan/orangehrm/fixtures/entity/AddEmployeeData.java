package com.karan.orangehrm.fixtures.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddEmployeeData {
	private String firstName;
	private String middleName;
	private String lastName;
	private String nickName;
	private int employeeId;
}
