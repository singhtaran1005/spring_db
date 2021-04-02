package com.example.demo.controllers;

import com.example.demo.DAO.Person;
import com.example.demo.DBManager.DBOperations;
import com.example.demo.request.CreateRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.SQLException;
import java.util.List;

@RequestMapping
public class PersonController {

    @RequestMapping(value = "/getPerson", method = RequestMethod.GET)
    public List<Person> getPersons() {

        //calling dao to get the objects from db
        return DBOperations.getPersons();
    }


    @RequestMapping(value = "/insertPerson",method = RequestMethod.POST)
    public void insertPerson(@RequestBody CreateRequest request) throws SQLException {
       DBOperations.insertPerson(request);
    }
}
