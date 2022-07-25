package dto.categoryDTO;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import entity.Category;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Category request DTO")
public class CategoryRequestDTO {

	@ApiModelProperty(value = "Name")
	@NotBlank(message = "Name")
	@Length(min = 3, max = 50, message = "Name")
	private String name;

	
	public Category covertToEntity() {
		return new Category(name);
	}
	
	public Category covertToEntity(Long CodeCategory) {
		return new Category(CodeCategory, name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
