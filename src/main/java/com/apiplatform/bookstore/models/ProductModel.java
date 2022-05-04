package com.apiplatform.bookstore.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="product")
public class ProductModel {
	@Id
	private String id;
	private String pdName;
	private float pdPrice;
	private String pdColor;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPdName() {
		return pdName;
	}
	public void setPdName(String pdName) {
		this.pdName = pdName;
	}
	public float getPdPrice() {
		return pdPrice;
	}
	public void setPdPrice(float pdPrice) {
		this.pdPrice = pdPrice;
	}
	public String getPdColor() {
		return pdColor;
	}
	public void setPdColor(String pdColor) {
		this.pdColor = pdColor;
	}

}
