package curriculumdesign.vo;

public class Goods {
	private String suttleWeight;
	private String roughWeight;
	private String amount;
	private String mainGoods;

	public Goods() {
		super();
	}

	public Goods(String suttleWeight, String roughWeight, String amount, String mainGoods) {
		super();
		this.suttleWeight = suttleWeight;
		this.roughWeight = roughWeight;
		this.amount = amount;
		this.mainGoods = mainGoods;
	}

	public String getSuttleWeight() {
		return suttleWeight;
	}

	public void setSuttleWeight(String suttleWeight) {
		this.suttleWeight = suttleWeight;
	}

	public String getRoughWeight() {
		return roughWeight;
	}

	public void setRoughWeight(String roughWeight) {
		this.roughWeight = roughWeight;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getMainGoods() {
		return mainGoods;
	}

	public void setMainGoods(String mainGoods) {
		this.mainGoods = mainGoods;
	}

	@Override
	public String toString() {
		return "Goods [suttleWeight=" + suttleWeight + ", roughWeight=" + roughWeight + ", amount=" + amount
				+ ", mainGoods=" + mainGoods + "]";
	}

}
