package studentManage.tools;

import studentManage.vo.User;

//全局信息
public class Global {
	public static String classPath; //存放各种文件目录的绝对地址，文件存放于当前目录下的data子目录中
	public static User currentUser; //当前登录用户信息
	
	//各种文件的文件名常量定义
	public static final String USER_PROPERTY_FILENAME="user.property";
	public static final String TXT_FILENAME="student.txt";
	public static final String XLS_FILENAME="student.xls";
	public static final String XML_FILENAME="student.xml";
	public static final String JSON_FILENAME="student.json";
	
	public static final String SCORE_TXT_FILENAME="score.txt";
	public static final String SCORE_XLS_FILENAME="score.xls";
	public static final String SCORE_XML_FILENAME="score.xml";
	public static final String SCORE_JSON_FILENAME="score.json";
	
	
	

}
