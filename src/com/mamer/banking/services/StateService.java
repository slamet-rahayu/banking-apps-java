package com.mamer.banking.services;

import com.mamer.banking.db.H2Connection;
import com.mamer.banking.model.StateModels;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StateService extends H2Connection {

    StateModels stateModels = new StateModels();
    String table;
    String[] columns;

    public StateService() {
        table = stateModels.table;
        columns = stateModels.columns;
    }

    public static void main(String[] args){
        StateService stateService = new StateService();
//        JSONObject obj = new JSONObject();
//        obj.put("name", "Slamet");
//        stateService.setState("test", obj.toJSONString());
        String state = stateService.getState("test");
        JSONParser parser = new JSONParser();
        try {
            Object object = parser.parse(state);
            System.out.println(object);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
    }

    public void setState(String key, Object values) {
        String query = "insert into " + table + " ("+columns[0]+","+columns[1]+")" + " values (?,?)";
        try {
            PreparedStatement stmt = connect().prepareStatement(query);
            stmt.setString(1, key);
            stmt.setObject(2, values);
            stmt.execute();
            ResultSet res = stmt.getResultSet();
            System.out.println(res);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public String getState(String key) {
        String query = "select "+columns[1]+" from state where "+columns[0]+" = ?";
        String result = "";
        try {
            PreparedStatement stmt = connect().prepareStatement(query);
            stmt.setString(1, key);
            ResultSet res = stmt.executeQuery();
            if (res.next()) {
                result = res.getString(columns[1]);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

}
