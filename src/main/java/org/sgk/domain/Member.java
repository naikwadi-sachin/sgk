package org.sgk.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Member {

	@NotNull
	@Size(min=2)
	private String name;

	@NotNull
	@Size(min=2, max=10)
	private String phone;

	@NotNull
	@Pattern(regexp=".+@.+\\.[a-z]+")
	private String email;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
