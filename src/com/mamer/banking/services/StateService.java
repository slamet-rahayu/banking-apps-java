package com.mamer.banking.services;

import com.mamer.banking.db.H2Connection;
import com.mamer.banking.model.StateModels;

import java.util.Arrays;

public class StateService {

    H2Connection h2Connection = new H2Connection();
    StateModels stateModels = new StateModels();

    public static void main(String[] args){
        StateService stateService = new StateService();
        stateService.insert("o", "o");
    }

    public void insert(String name, String values){
        String table = stateModels.table;
        String[] columns = stateModels.columns;
        String strColumns = Arrays.toString(columns)
                .replace("[", "")
                .replace("]", "");
        final String query = "insert into " + table + "("+strColumns+")" + "values (?,?)";
        System.out.println(query);
    }
}
