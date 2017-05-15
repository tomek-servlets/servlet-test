package lu.lllc;

import java.io.Serializable;

public class Book implements Serializable {
	static final long serialVersionUID = 12345L;
	private String title;
	private String description;
	private float price;

	public Book() {
		// TODO Auto-generated constructor stub
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

}
