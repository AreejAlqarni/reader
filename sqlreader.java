package com.stc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class sqlreader {
    //jdbc:postgresql://localhost:5432/postgres
    static Connection con = null;

    public unifiedFormat conectdatabase(String dbname, String user, String password) {

        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dbname, user, password);
            if (con != null) {
                System.out.println("good");

            } else {
                System.out.println("bad");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        return null;
    }

    public static Object readerdatabase() {
        try {
            // Connection connection = DriverManager.getConnection(dbname, user, password);
            String selectSQL = "SELECT * FROM employee";
            PreparedStatement preparedStatement = con.prepareStatement(selectSQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            unifiedFormat employee = null;
            while (resultSet.next()) {

                List<unifiedFormat> userList = new ArrayList<>();
                String columnName1 = resultSet.getString("first_name");
                int salary = resultSet.getInt("salary");
                String columnName2 = resultSet.getString("department");
                String columnName3 = resultSet.getString("gender");

                employee = new unifiedFormat(columnName1, salary, columnName2, columnName3);
                userList.add(employee);

                System.out.println("firstName: " + columnName1);
                System.out.println("salary: " + salary);
                System.out.println("department: " + columnName2);
                System.out.println("gender: " + columnName3);
                System.out.println();
            }
            resultSet.close();
            preparedStatement.close();
            con.close();
            return employee;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}






