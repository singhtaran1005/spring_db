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
                    connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/person_4", "root", "taranmysql");
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
            System.out.println("table " + name + " is successfully created");
        }

        CloseConnection();
    }

    public static void insertPerson(CreateRequest request) throws SQLException {

        getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO person VALUES (null , ? , ? , ?)");
        preparedStatement.setString(1, request.getName());
        preparedStatement.setInt(2,request.getAge());
        preparedStatement.setString(3, request.getAddress());


//        preparedStatement.executeUpdate();
//        Person person = new Person(request.getName(), request.getAge(), request.getAddress());
//        Statement statement = connection.createStatement();
        int rows_affected = preparedStatement.executeUpdate();

        if(rows_affected>0)
        {
            System.out.println("Successfully inserted the record");
        }
        else {
            System.out.println("Unable to insert into the record");
        }
        CloseConnection();
    }

    public Person getPersonById() {
        return null;
    }

    public static List<Person> getPersons() {

        return null;

        //getting persons from db
    }

    public static void deletePerson(int id) {

    }

    public static void updatePerson(Person person) {


    }
}
