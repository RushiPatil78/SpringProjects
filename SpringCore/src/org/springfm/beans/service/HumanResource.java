package org.springfm.beans.service;

import org.springfm.beans.IDepartment;

public class HumanResource implements IDepartment{

	@Override
	public String departmentType() {
		return "HR Department";
	}

}
