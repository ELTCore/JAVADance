// �½����ݿ�mis������ѧ����tstudent��,���ֶζ������£�

// �ֶ���		���ĺ���	��������		 		��ע
// id				ѧ��			Varchar(20)		����
// name		����			Varchar(20)     	NOT NULL
// gender		�Ա�			Varchar(20)		NOT NULL
// birth			��������	DATE					NOT NULL
// score		�ɼ�			Decimal(9,1)		NOT NULL

// ����Java����ʵ�ֻ����Ĳ���Ͳ�ѯ���ܣ�
// n ����ѧ��������Ϣ�����浽���ݿ�
// n ����ѧ��ѧ�ţ���ѯ��ʾ��ѧ��ѧ�������м�¼

package test01;

import java.sql.*;
import java.util.Scanner;

public class Driver {
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/mis?useSSL=false&serverTimezone=UTC";

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
			Scanner sc = new Scanner(System.in);
			String sql = "";
			int choose = 0;
			do {
				System.out.println("1. ������Ϣ");
				System.out.println("2. ��ѯ��Ϣ");
				System.out.print("��ѡ����: ");
				choose = sc.nextInt();

				if (choose == 1) {
					String id;
					String name;
					String gender;
					String birth;
					float score;

					System.out.print("\n������ѧ��ID:");
					id = sc.next();
					System.out.print("\n������ѧ������:");
					name = sc.next();
					System.out.print("\n������ѧ���Ա�:");
					gender = sc.next();
					System.out.print("\n������ѧ������(��ʽ:YYYY-MM-DD):");
					birth = sc.next();
					System.out.print("\n������ѧ���ɼ�:");
					score = sc.nextFloat();

					sql = "INSERT INTO tstudent VALUES ('" + id + "', '" + name + "', '" + gender + "', '" + birth
							+ "', " + score + ")";

					stmt.executeUpdate(sql);
				}
				if (choose == 2) {
					System.out.println("�������ѯID: ");
					sql = "SELECT id, name, gender, birth, score FROM tstudent WHERE id = '" + sc.next() + "'";
				}
			} while (choose != 1 && choose != 2);
			sc.close();

			if (choose == 1) {
				sql = "SELECT * FROM tstudent";
			}
			ResultSet rs = stmt.executeQuery(sql);

			// չ����������ݿ�
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String gender = rs.getString("gender");
				String birth = rs.getString("birth");
				float score = rs.getFloat("score");

				System.out.print("\nID: " + id);
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
			System.out.println("\n\nGoodbye.");
		}
	}
}