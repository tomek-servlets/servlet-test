package com.patryk.adaramelech;

import java.io.Serializable;

public class Product implements Serializable {
	static final long serialVersionUID = 12345L;
	private long id;
	private String title;
	private String description;
	private float price;
	private String tag;
	private int contvalue;
	private String descMore;

	public Product() {
		// TODO Auto-generated constructor stub

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public void setcont(int contvalue) {
		this.contvalue = contvalue;
	}

	public int getCont() {
		return contvalue;
	}

	public void setDescMore(String Desc) {
		this.descMore = Desc;
	}

	public String getdescMore() {
		return descMore;
	}

}
