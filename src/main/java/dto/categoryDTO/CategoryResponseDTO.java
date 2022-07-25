package dto.categoryDTO;

import entity.Category;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Category response DTO")
public class CategoryResponseDTO {

	@ApiModelProperty(value = "code")
	private Long code;

	@ApiModelProperty(value = "name")
	private String name;

	public CategoryResponseDTO() {
	}
	
	public static CategoryResponseDTO convertToCategoryDTO(Category category) {
		return new CategoryResponseDTO(category.getCode(), category.getName());
	}

	public CategoryResponseDTO(Long code, String name) {
		this.code = code;
		this.name = name;
	}

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
