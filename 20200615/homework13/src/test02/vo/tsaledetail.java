package test02.vo;

public class tsaledetail {
	private String lsh;
	private String barCode;
	private String productName;
	private float price;
	private int count;
	private String operator;
	private String saleTime;
	
	public tsaledetail() {
		super();
	}

	public tsaledetail(String lsh, String barCode, String productName, float price, int count, String operator,
			String saleTime) {
		super();
		this.lsh = lsh;
		this.barCode = barCode;
		this.productName = productName;
		this.price = price;
		this.count = count;
		this.operator = operator;
		this.saleTime = saleTime;
	}

	public String getLsh() {
		return lsh;
	}

	public void setLsh(String lsh) {
		this.lsh = lsh;
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

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getSaleTime() {
		return saleTime;
	}

	public void setSaleTime(String saleTime) {
		this.saleTime = saleTime;
	}

	@Override
	public String toString() {
		return "tsaledetail [lsh=" + lsh + ", barCode=" + barCode + ", productName=" + productName + ", price=" + price
				+ ", count=" + count + ", operator=" + operator + ", saleTime=" + saleTime + "]";
	}

}
