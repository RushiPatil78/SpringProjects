package org.springfm.beans.service;

import org.springfm.beans.IDepartment;

public class Development implements IDepartment{

	@Override
	public String departmentType() {
		return "Development Department";
	}

}
