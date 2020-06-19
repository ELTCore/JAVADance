package curriculumdesign.dao;

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

import curriculumdesign.tools.Global;
import curriculumdesign.tools.PDFManage;
import curriculumdesign.vo.Goods;
import curriculumdesign.vo.Order;
import jxl.Sheet;
import jxl.Workbook;

import java.awt.*;

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
					orderList.get(orderList.size() - 1).getGoodsList().add(goods);
				}

			}

		}
		System.out.println("\n成功导入" + count + "条面单数据!");

		printOrderForm(orderList);

		return orderList;
	}

	public boolean checkOrderExist(Order order, ArrayList<Order> orderList) {
		boolean result = false;
		for (Order ord : orderList) {

			if (ord.getsNumber().equals(order.getsNumber()) && ord.getEmsNumber().equals(order.getEmsNumber())) {
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
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");

		String orderNumber = sdf.format(date) + randInt;

		return orderNumber;
	}

	public void createBarCode(String orderNumber, String fileName) throws IOException {

		BarcodeSettings settings = new BarcodeSettings();// 创建BarcodeSettings实例

		settings.setType(BarCodeType.Code_128);// 指定条码类型

		settings.setData(orderNumber);// 设置条码数据

		settings.setData2D(orderNumber);// 设置条码显示数据

		settings.setShowTextOnBottom(true);// 设置数据文本显示在条码底部

		settings.setX(0.7f);// 设置黑白条宽度

		settings.setImageHeight(50);// 设置生成的条码图片高度

		settings.setImageWidth(70);// 设置生成的条码图片宽度

		settings.hasBorder(false);// 设置边框可见

		settings.setBorderColor(new Color(135, 206, 250));// 设置条码边框颜色

		settings.setBorderWidth(0);// 设置条码边框宽度

		settings.setBackColor(new Color(255, 255, 255));// 设置条码背景色

		BarCodeGenerator barCodeGenerator = new BarCodeGenerator(settings);// 创建BarCodeGenerator实例

		BufferedImage bufferedImage = barCodeGenerator.generateImage();// 根据settings生成图像数据，保存至BufferedImage实例

		ImageIO.write(bufferedImage, "png", new File(Global.classPath + fileName));// 保存条码为PNG图片

		System.out.println("Complete!");

	}

	public void barCodeListCreate(ArrayList<Order> orderList) throws IOException {
		for (Order ord : orderList) {
			createBarCode(createOrderNumber(), ord.getEmsNumber() + ".png");
		}
	}

	public void overlapImage(String basicPath, String barCodePath, String outputPath, Order order) {
		try {
			// 设置图片大小
			BufferedImage basic = resizeImage(443, 649, ImageIO.read(new File(basicPath)));
			BufferedImage barCode = resizeImage(300, 70, ImageIO.read(new File(barCodePath)));

			// 在背景图片中添加入需要写入的信息
			Graphics2D g = basic.createGraphics();
			g.setColor(Color.BLACK);
			g.setFont(new Font("微软雅黑", Font.BOLD, 12));

			int temp = 115;
			g.drawString("内件明细: ", 14, temp);

			ArrayList<Goods> goodsList = order.getGoodsList();
			System.out.println(goodsList.toString());

			for (Goods goods : goodsList) {
				temp += 14;
				g.drawString(goods.getMainGoods(), 14, temp);
			}

			temp = 196;
			g.drawString("收件人: " + order.getReceiverName() + " 电话: " + order.getReceiverPhone(), 14, temp);
			temp += 14;
			g.drawString("地址: " + order.getReceiverAdress(), 14, temp);
			temp += 14;
			g.drawString("邮编: " + order.getReceiverProvinceCode(), 14, temp);

			temp = 267;
			g.drawString("内件数量: " + order.getGoodsList().size() + "件", 14, temp);
			temp += 14;
			g.drawString("总重量: " + order.getGoodsList().get(0).getRoughWeight() + "kg", 14, temp);

			temp = 520;
			g.drawString("发件人: " + order.getConsignerName(), 14, temp);
			temp += 14;
			g.drawString("电话: " + order.getConsignerPhone(), 14, temp);

			temp = 590;
			g.drawString("收件人: " + order.getReceiverName(), 14, temp);
			temp += 14;
			g.drawString("地址: ", 14, temp);
			temp += 14;
			g.drawString(order.getReceiverAdress(), 14, temp);

			// 在背景图片上添加二维码图片
			g.drawImage(barCode, 70, 340, barCode.getWidth(), barCode.getHeight(), null);
			g.dispose();

			// ImageIO.write(background, "jpg", new File("这里是一个输出图片的路径"));

			ImageIO.write(basic, "jpg", new File(outputPath + order.getEmsNumber() + ".jpg"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public BufferedImage resizeImage(int x, int y, BufferedImage bfi) {
		BufferedImage bufferedImage = new BufferedImage(x, y, BufferedImage.TYPE_INT_RGB);
		bufferedImage.getGraphics().drawImage(bfi.getScaledInstance(x, y, Image.SCALE_SMOOTH), 0, 0, null);
		return bufferedImage;
	}

	public void outputJPGList(ArrayList<Order> orderList) {
		for (Order ord : orderList) {
			overlapImage(Global.classPath + Global.JPG_BASICNAME, Global.classPath + ord.getEmsNumber() + ".png",
					Global.classPath + "./", ord);
			System.out.println("JPGCompelte");
		}
	}

	public void outputPDFList(ArrayList<Order> orderList) {

		ArrayList<String> imageUrlList = new ArrayList<String>();

		String pdfUrl = Global.classPath + "PDF.pdf";

		for (Order ord : orderList) {
			imageUrlList.add(Global.classPath + ord.getEmsNumber() + ".jpg");
		}
		File file = PDFManage.Pdf(imageUrlList, pdfUrl);
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
