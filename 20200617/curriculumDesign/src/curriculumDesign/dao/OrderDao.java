package curriculumDesign.dao;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.imageio.ImageIO;

import com.spire.barcode.BarCodeGenerator;
import com.spire.barcode.BarCodeType;
import com.spire.barcode.BarcodeSettings;


import jxl.Sheet;
import jxl.Workbook;

public class OrderDao {
	public ArrayList<Order> loadDataFromXLS(String fileName, ArrayList<Order> orderList) throws Exception {

		Workbook workbook = Workbook.getWorkbook(new File(fileName));
		Sheet sheet = workbook.getSheet(0);
		int rows = sheet.getRows();
		int count = 0;

		for (int i = 1; i < rows; i++) {
			String sNumber, emsNumber, suttleWeight = "", roughWeight = "", amount = "", mainGoods = "", receiverName,
					receiverProvinceCode, receiverAdress, receiverPhone, consignerName, consignerProvinceCode,
					consignerAdress, consignerPhone, remark;

			mainGoods = sheet.getCell(5, i).getContents();

			if (mainGoods == "") {
				break;
			}
			suttleWeight = sheet.getCell(2, i).getContents();
			roughWeight = sheet.getCell(3, i).getContents();
			amount = sheet.getCell(4, i).getContents();

			Goods goods = new Goods(suttleWeight, roughWeight, amount, mainGoods);

			sNumber = sheet.getCell(0, i).getContents();
			if (sNumber == "") {
				orderList.get(orderList.size() - 1).getGoodsList().add(goods);
			} else {
				emsNumber = sheet.getCell(1, i).getContents();

				receiverName = sheet.getCell(6, i).getContents();
				receiverProvinceCode = sheet.getCell(7, i).getContents();
				receiverAdress = sheet.getCell(8, i).getContents();
				receiverPhone = sheet.getCell(9, i).getContents();
				consignerName = sheet.getCell(10, i).getContents();
				consignerProvinceCode = sheet.getCell(11, i).getContents();
				consignerAdress = sheet.getCell(12, i).getContents();
				consignerPhone = sheet.getCell(13, i).getContents();
				remark = sheet.getCell(14, i).getContents();

				Order order = new Order(sNumber, emsNumber, receiverName, receiverProvinceCode, receiverAdress,
						receiverPhone, consignerName, consignerProvinceCode, consignerAdress, consignerPhone, remark);

				if (!checkOrderExist(order, orderList)) {
					orderList.add(order);
					count++;
				}

			}

		}
		System.out.println("\n成功导入" + count + "条面单数据!");

		printOrderForm(orderList);

		return orderList;
	}

	public boolean checkOrderExist(Order order, ArrayList<Order> orderList) {
		boolean result = false;
		for (Order or : orderList) {

			if (or.getsNumber().equals(order.getsNumber()) && or.getEmsNumber().equals(order.getEmsNumber())) {
				result = true;
				break;
			}
		}
		return result;
	}

	public void printOrderForm(ArrayList<Order> orderList) {
		System.out.println();
		for (Order or : orderList) {
			System.out.println(or.toString());
		}
	}

	public String createOrderNumber() {

		int tempInt = (int) (Math.random() * 1000);
		String randInt = String.format("%03d", tempInt);

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

		String orderNumber = sdf.format(date) + randInt;

		return orderNumber;
	}

	void createBarCode(String orderNumber) throws IOException {

		BarcodeSettings settings = new BarcodeSettings();// 创建BarcodeSettings实例

		settings.setType(BarCodeType.Code_128);// 指定条码类型

		settings.setData(orderNumber);// 设置条码数据

		settings.setData2D(orderNumber);// 设置条码显示数据

		settings.setShowTextOnBottom(true);// 设置数据文本显示在条码底部

		settings.setX(0.8f);// 设置黑白条宽度

		settings.setImageHeight(50);// 设置生成的条码图片高度

		settings.setImageWidth(70);// 设置生成的条码图片宽度

		settings.hasBorder(true);// 设置边框可见

		settings.setBorderColor(new Color(135, 206, 250));// 设置条码边框颜色

		settings.setBorderWidth(1);// 设置条码边框宽度

		settings.setBackColor(new Color(240, 255, 255));// 设置条码背景色

		BarCodeGenerator barCodeGenerator = new BarCodeGenerator(settings);// 创建BarCodeGenerator实例

		BufferedImage bufferedImage = barCodeGenerator.generateImage();// 根据settings生成图像数据，保存至BufferedImage实例

		ImageIO.write(bufferedImage, "png", new File("CODE128.png"));// 保存条码为PNG图片

		System.out.println("Complete!");

	}

}
