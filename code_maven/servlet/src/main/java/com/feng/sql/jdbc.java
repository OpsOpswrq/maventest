package com.feng.sql;

import java.sql.*;

public class jdbc {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://localhost:3306/user?usUnicode=true&characterEncoding=utf-8";
        String username = "root";
        String password = "root";
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        String sql = "select * from users";

//        PreparedStatement preparedStatement = connection.prepareStatement(sql);        connection.rollback();  事务处理 这个是事务回滚 try catch 的实现
//        String sql = "insert into users(id, name, password, email, brithday) values (?,?,?,?,?)";   connection.commit();    这个是事务提交
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//        preparedStatement.setObject();   //这个下标是从1开始的，注意这个细节
        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()){
            System.out.println("id="+resultSet.getInt("id"));
            System.out.println("name="+resultSet.getString("name"));
            System.out.println("password="+resultSet.getString("password"));
            System.out.println("email="+resultSet.getString("email"));
            System.out.println("birthday"+resultSet.getObject("brithday"));
        }
        resultSet.close();
        statement.close();
        connection.close();
    }
}
