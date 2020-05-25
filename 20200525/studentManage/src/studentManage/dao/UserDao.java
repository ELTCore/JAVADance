package studentManage.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Properties;
import java.util.Scanner;

import studentManage.tools.Global;
import studentManage.vo.User;

public class UserDao {

	public boolean login(User user) throws Exception {
		boolean result = false;
		User saveUser = readUserProperty();
		if (saveUser.getUserName().equals(user.getUserName()) && saveUser.getPassword().equals(user.getPassword())) {
			return true;
		}
		return result;
	}

	public User readUserProperty() throws Exception {

		Properties property = new Properties();
		InputStream is = new FileInputStream(Global.classPath + Global.USER_PROPERTY_FILENAME);
		property.load(new InputStreamReader(is, "utf-8"));
		is.close();
		String userName = property.getProperty("userName");
		String password = property.getProperty("password");
		User user = new User(userName, password);

		return user;
	}
	
	public void changePassword() throws Exception {
		System.out.println("������ԭ����:");
		Scanner scan=new Scanner(System.in);
		String oldPassword=scan.nextLine();
		if(!oldPassword.equals(Global.currentUser.getPassword())) {
			System.out.println("�������ԭ���벻��ȷ�����޸�ʧ��");
			return;
		}
		System.out.println("������������:");
		String newPassword1=scan.nextLine();
		System.out.println("���ٴ�����������:");
		String newPassword2=scan.nextLine();
		if(!newPassword1.equals(newPassword2)) {
			System.out.println("�������벻һ�£����޸�ʧ��");
			return;
		}
		User user=new User();
		user.setPassword(newPassword1);
		writeUserPropery(user);
		//����ȫ�ֱ���ĵ�ǰ�û���Ϣ
		user.setUserName(Global.currentUser.getUserName());
		Global.currentUser = user; 
		System.out.println("�����޸ĳɹ�������ǣ�");
	}

	public void writeUserPropery(User user) throws Exception {
		Properties property = new Properties();
		InputStream is = new FileInputStream(Global.classPath + Global.USER_PROPERTY_FILENAME);
		property.load(new InputStreamReader(is, "utf-8"));
		is.close();
		
		property.setProperty("password", user.getPassword());
		OutputStream os = new FileOutputStream(Global.classPath + Global.USER_PROPERTY_FILENAME);
		property.store(new OutputStreamWriter(os,"utf-8"), "");
		os.close();
		
		
	}

}
