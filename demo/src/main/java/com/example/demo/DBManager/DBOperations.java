package com.example.demo.DBManager;

import com.example.demo.DAO.Person;

import java.sql.Connection;
import java.util.List;

public class DBOperations {

    private static volatile Connection connection;  //if thread t1 ->open so that no other thread should made open connection (singleton pattern) ->volatile


    public static Connection getConnection(){
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
