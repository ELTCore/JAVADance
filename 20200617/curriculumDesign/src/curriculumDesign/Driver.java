package curriculumDesign;

import curriculumDesign.tools.Global;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String classPath = Driver.class.getResource("data").getPath();
		Global.classPath = classPath + "/";

	}

}
