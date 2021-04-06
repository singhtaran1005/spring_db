package com.example.demo.controllers;

import com.example.demo.DAO.Person;
import com.example.demo.DBManager.DBOperations;
import com.example.demo.request.CreateRequest;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RequestMapping
public class PersonController {

    @GetMapping("/getPersons")
    public List<Person> getPersons() throws SQLException {

        //calling dao to get the objects from db
        return DBOperations.getPersons();
    }

    @PostMapping("/createTable")
    public void createTable(@RequestParam(value = "name") String name) throws SQLException {
        DBOperations.createTable(name);
    }

    @PostMapping("/insertPerson")
    public void insertPerson(@RequestBody CreateRequest request) throws SQLException {

        DBOperations.insertPerson(request);
    }
}
