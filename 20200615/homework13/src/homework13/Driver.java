// �½����ݿ�mis������ѧ����tstudent��,���ֶζ������£�

// �ֶ���	���ĺ���	��������		 ��ע
// id		ѧ��		Varchar(20)	    ����
// name		����		Varchar(20)     NOT NULL
// gender	�Ա�		Varchar(20)		NOT NULL
// birth	��������	 DATE			NOT NULL
// score	�ɼ�		Decimal(9,1)	NOT NULL

// ����Java����ʵ�ֻ����Ĳ���Ͳ�ѯ���ܣ�

// n ����ѧ��������Ϣ�����浽���ݿ�

// n ����ѧ��ѧ�ţ���ѯ��ʾ��ѧ��ѧ�������м�¼

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
			// ע�� JDBC ����
			Class.forName(JDBC_DRIVER);

			// ������
			System.out.println("�������ݿ�...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// ִ�в�ѯ
			System.out.println(" ʵ����Statement����...");
			stmt = conn.createStatement();
			String sql;

			sql = "SELECT id, name, gender, birth, score FROM tstudent";

			ResultSet rs = stmt.executeQuery(sql);

			// չ����������ݿ�
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String gender = rs.getString("gender");
				String birth = rs.getString("birth");
				float score = rs.getFloat("score");

				System.out.print("ID: " + id);
				System.out.print(", ����: " + name);
				System.out.print(", �Ա�: " + gender);
				System.out.print(", ��������: " + birth);
				System.out.print(", �ɼ�: " + score);
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