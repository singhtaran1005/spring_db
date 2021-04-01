package com.example.demo.DBManager;

import com.example.demo.DAO.Person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class DBOperations {

    private static volatile Connection connection;  //if thread t1 ->open so that no other thread should made open connection (singleton pattern) ->volatile


    public static Connection getConnection() throws SQLException {
            if(connection!=null)
            {
                synchronized (DBOperations.class){
                    if(connection!=null)
                    {
                        connection= DriverManager.getConnection("jdbc:mysql:127.0.0.1:/3306");
                    }
                }
            }
        return null;
    }

    public static void CloseConnection() {

    }
    public static void insertPerson(){

    }
    public Person getPersonById(){
    return null;
    }

    public static List<Person> getPersons() {


        //getting persons from db
        return null;
    }

    public static void deletePerson(int id){

    }
    public static void updatePerson(Person person){


    }
}
