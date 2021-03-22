package topi.fullstackdev.javaproject.Meal;

public class Meal {
	private String name;
	private String category;
	private String area;
	private String thumbnail;
	private String instructions;

	public Meal(String name, String category, String area, String thumbnail, String instructions) {
		this.name = name;
		this.category = category;
		this.area = area;
		this.thumbnail = thumbnail;
		this.instructions = instructions;
	}

	public Meal() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	
}
