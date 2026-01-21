package com.klu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCCrud {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/fsads3";
        String usr = "root";
        String pwd = "Nandu@2006";

        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, usr, pwd);
            System.out.println("Connection established");

            Statement st = con.createStatement();

            String createDept =
                    "CREATE TABLE IF NOT EXISTS Dept (" +
                    "dept_id INT PRIMARY KEY AUTO_INCREMENT, " +
                    "dept_name VARCHAR(20))";

            st.execute(createDept);
            System.out.println("Department table created");

            String createEmp =
                    "CREATE TABLE IF NOT EXISTS Emp (" +
                    "emp_id INT PRIMARY KEY AUTO_INCREMENT, " +
                    "emp_name VARCHAR(50), " +
                    "sal DOUBLE, " +
                    "dept_id INT, " +
                    "FOREIGN KEY (dept_id) REFERENCES Dept(dept_id))";

            st.execute(createEmp);
            System.out.println("Employee table created");
          

            con.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}