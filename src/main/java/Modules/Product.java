package Modules;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="pId")
	int pId;
	@Column(name="pName")
	String pName;
	@Column(name="pBrand")
	String pBrand;
	@Column(name="price")
	float price;
	@Column(name="description")
	String decription;
	@Column(name="imgPath")
	String imagPath;
	public Product() {
		
	}
	public Product(int pId, String pName, String pBrand, float price, String decription, String imagPath) {
		super();
		this.pId = pId;
		this.pName = pName;
		this.pBrand = pBrand;
		this.price = price;
		this.decription = decription;
		this.imagPath = imagPath;
	}
	public Product(String pName, String pBrand, float price, String decription, String imagPath) {
		super();
		this.pName = pName;
		this.pBrand = pBrand;
		this.price = price;
		this.decription = decription;
		this.imagPath = imagPath;
	}
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getpBrand() {
		return pBrand;
	}
	public void setpBrand(String pBrand) {
		this.pBrand = pBrand;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getDecription() {
		return decription;
	}
	public void setDecription(String decription) {
		this.decription = decription;
	}
	public String getImagPath() {
		return imagPath;
	}
	public void setImagPath(String imagPath) {
		this.imagPath = imagPath;
	}
	@Override
	public String toString() {
		return "Product [pId=" + pId + ", pName=" + pName + ", pBrand=" + pBrand + ", price=" + price + ", decription="
				+ decription + ", imagPath=" + imagPath + "]";
	}
	

}
