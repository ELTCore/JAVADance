package test02.vo;

public class tproduct {
	private String barCode;
	private String productName;
	private float price;
	private String supply;

	public tproduct() {
		super();
	}

	public tproduct(String barCode, String productName, float price, String supply) {
		super();
		this.barCode = barCode;
		this.productName = productName;
		this.price = price;
		this.supply = supply;
	}

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getSupply() {
		return supply;
	}

	public void setSupply(String supply) {
		this.supply = supply;
	}

	@Override
	public String toString() {
		return "tproduct [barCode=" + barCode + ", productName=" + productName + ", price=" + price + ", supply="
				+ supply + "]";
	}

}
