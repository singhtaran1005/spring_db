package com.example.demo.DBManager;

import com.example.demo.DAO.Person;
import com.example.demo.request.CreateRequest;

import java.sql.*;
import java.util.List;

public class DBOperations {

    private static volatile Connection connection;  //if thread t1 ->open so that no other thread should made open connection (singleton pattern) ->volatile


    public static Connection getConnection() throws SQLException {
        if (connection == null) {
            synchronized (DBOperations.class) {
                if (connection == null) {
                    connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/", "root", "taranmysql");

                }
            }
        }

        return connection;
    }

    public static void CloseConnection() throws SQLException {
        if (connection != null) {
            synchronized (DBOperations.class) {
                if (connection != null) {
                    connection.close();
                }
            }
        }
    }

    //creating db table from backend ->
    public static void createTable(String name) throws SQLException {

        getConnection();

        Statement statement = connection.createStatement();
        boolean isCreated = statement.execute("CREATE TABLE " + name + " ( id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(20), age INT, " +
                "address VARCHAR(50))");
        if (isCreated) {
            System.out.println("table" + name + "is successfully created");
        }
        CloseConnection();
    }

    public static void insertPerson(CreateRequest request) throws SQLException {
//        PreparedStatement
//        Person person = new Person(request.getName(), request.getAge(), request.getAddress());
//        Statement statement = connection.createStatement();
//        int rows_affected = statement.executeUpdate("INSERT INTO person VALUES ()");
    }

    public Person getPersonById() {
        return null;
    }

    public static List<Person> getPersons() {


        //getting persons from db
        return null;
    }

    public static void deletePerson(int id) {

    }

    public static void updatePerson(Person person) {


    }
}
