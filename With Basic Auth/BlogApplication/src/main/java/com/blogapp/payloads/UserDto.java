package com.blogapp.payloads;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

	private int id;

	@NotEmpty
	@Size(min = 4, message = "Username must be of atleast 4 character")
	private String name;

	@Email(message = "Email address is not valid")
	private String email;

	@NotNull
	@Size(min = 3, max = 10, message = "Password must be min of 3 char and max of 10 char")
	private String password;

	@NotEmpty(message = "Please enter your about section")
	private String about;

}
