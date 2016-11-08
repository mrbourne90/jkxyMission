package com.jikexueyuan.hellospring;

import com.google.gson.JsonObject;

public class JsonOutputHelper implements IOutputHelper {

	private Employee employee;

	@Override
	public String getFormatedString() {

		JsonObject emp = new JsonObject();
		emp.addProperty("name", employee.getName());
		emp.addProperty("age", employee.getAge());
		emp.addProperty("gender", employee.getGender());
		emp.addProperty("address", employee.getAddress());
		emp.addProperty("phoneNum", employee.getPhoneNum());
		return emp.toString();
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}
