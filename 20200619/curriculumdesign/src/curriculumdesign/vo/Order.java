package curriculumdesign.vo;

import java.util.ArrayList;

public class Order {
	private String sNumber;
	private String emsNumber;
	private String receiverName;
	private String receiverProvinceCode;
	private String receiverAdress;
	private String receiverPhone;
	private String consignerName;
	private String consignerProvinceCode;
	private String consignerAdress;
	private String consignerPhone;
	private String remark;
	private ArrayList<Goods> goodsList = new ArrayList<Goods>();

	public Order() {
		super();
	}

	public Order(String sNumber, String emsNumber, String receiverName, String receiverProvinceCode,
			String receiverAdress, String receiverPhone, String consignerName, String consignerProvinceCode,
			String consignerAdress, String consignerPhone, String remark) {
		super();
		this.sNumber = sNumber;
		this.emsNumber = emsNumber;
		this.receiverName = receiverName;
		this.receiverProvinceCode = receiverProvinceCode;
		this.receiverAdress = receiverAdress;
		this.receiverPhone = receiverPhone;
		this.consignerName = consignerName;
		this.consignerProvinceCode = consignerProvinceCode;
		this.consignerAdress = consignerAdress;
		this.consignerPhone = consignerPhone;
		this.remark = remark;
	}

	public Order(String sNumber, String emsNumber, String receiverName, String receiverProvinceCode,
			String receiverAdress, String receiverPhone, String consignerName, String consignerProvinceCode,
			String consignerAdress, String consignerPhone, String remark, ArrayList<Goods> goodsList) {
		super();
		this.sNumber = sNumber;
		this.emsNumber = emsNumber;
		this.receiverName = receiverName;
		this.receiverProvinceCode = receiverProvinceCode;
		this.receiverAdress = receiverAdress;
		this.receiverPhone = receiverPhone;
		this.consignerName = consignerName;
		this.consignerProvinceCode = consignerProvinceCode;
		this.consignerAdress = consignerAdress;
		this.consignerPhone = consignerPhone;
		this.remark = remark;
		this.goodsList = goodsList;
	}

	public String getsNumber() {
		return sNumber;
	}

	public void setsNumber(String sNumber) {
		this.sNumber = sNumber;
	}

	public String getEmsNumber() {
		return emsNumber;
	}

	public void setEmsNumber(String emsNumber) {
		this.emsNumber = emsNumber;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getReceiverProvinceCode() {
		return receiverProvinceCode;
	}

	public void setReceiverProvinceCode(String receiverProvinceCode) {
		this.receiverProvinceCode = receiverProvinceCode;
	}

	public String getReceiverAdress() {
		return receiverAdress;
	}

	public void setReceiverAdress(String receiverAdress) {
		this.receiverAdress = receiverAdress;
	}

	public String getReceiverPhone() {
		return receiverPhone;
	}

	public void setReceiverPhone(String receiverPhone) {
		this.receiverPhone = receiverPhone;
	}

	public String getConsignerName() {
		return consignerName;
	}

	public void setConsignerName(String consignerName) {
		this.consignerName = consignerName;
	}

	public String getConsignerProvinceCode() {
		return consignerProvinceCode;
	}

	public void setConsignerProvinceCode(String consignerProvinceCode) {
		this.consignerProvinceCode = consignerProvinceCode;
	}

	public String getConsignerAdress() {
		return consignerAdress;
	}

	public void setConsignerAdress(String consignerAdress) {
		this.consignerAdress = consignerAdress;
	}

	public String getConsignerPhone() {
		return consignerPhone;
	}

	public void setConsignerPhone(String consignerPhone) {
		this.consignerPhone = consignerPhone;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public ArrayList<Goods> getGoodsList() {
		return goodsList;
	}

	public void setGoodsList(ArrayList<Goods> goodsList) {
		this.goodsList = goodsList;
	}

	@Override
	public String toString() {
		return "Order [sNumber=" + sNumber + ", emsNumber=" + emsNumber + ", receiverName=" + receiverName
				+ ", receiverProvinceCode=" + receiverProvinceCode + ", receiverAdress=" + receiverAdress
				+ ", receiverPhone=" + receiverPhone + ", consignerName=" + consignerName + ", consignerProvinceCode="
				+ consignerProvinceCode + ", consignerAdress=" + consignerAdress + ", consignerPhone=" + consignerPhone
				+ ", remark=" + remark + ", goodsList=" + goodsList + "]";
	}

}
