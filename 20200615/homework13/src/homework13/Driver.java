// 新建数据库mis，建立学生表（tstudent）,各字段定义如下：

// 字段名	中文含义	数据类型		 备注
// id		学号		Varchar(20)	    主键
// name		姓名		Varchar(20)     NOT NULL
// gender	性别		Varchar(20)		NOT NULL
// birth	出生日期	 DATE			NOT NULL
// score	成绩		Decimal(9,1)	NOT NULL

// 开发Java程序，实现基本的插入和查询功能：

// n 输入学生各项信息，保存到数据库

// n 输入学生学号，查询显示该学号学生的所有记录

package homework13;

import java.sql.*;

public class Driver {
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/msi?useSSL=false&serverTimezone=UTC";

	static final String USER = "root";
	static final String PASS = "Byzq8023";

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {
			// 注册 JDBC 驱动
			Class.forName(JDBC_DRIVER);

			// 打开链接
			System.out.println("链接数据库...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// 执行查询
			System.out.println(" 实例化Statement对象...");
			stmt = conn.createStatement();
			String sql;

			sql = "SELECT id, name, gender, birth, score FROM tstudent";

			ResultSet rs = stmt.executeQuery(sql);

			// 展开结果集数据库
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String gender = rs.getString("gender");
				String birth = rs.getString("birth");
				float score = rs.getFloat("score");

				System.out.print("ID: " + id);
				System.out.print(", 姓名: " + name);
				System.out.print(", 性别: " + gender);
				System.out.print(", 出生日期: " + birth);
				System.out.print(", 成绩: " + score);
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {

			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
			System.out.println("Goodbye.");
		}
	}
}