package com.blogapp.payloads;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {

	private Integer categoryId;

	@NotEmpty
	@Size(min = 4, max = 15)
	private String categoryTitle;

	@NotEmpty
	@Size(min = 10)
	private String categoryDescription;

}
