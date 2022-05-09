package helpers;

import net.minidev.json.JSONObject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbHandler {

    private static String connectionUrl = "jdbc:mysql://localhost/Pubs?user=root";

    public static void addNewEmployeeWithSalary(int idCard, int salary){
        try(Connection connect = DriverManager.getConnection(connectionUrl)){
            connect.createStatement().execute("INSERT employee (identity_card, salary) VALUES ('"+idCard+"', '"+salary+"')");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static JSONObject getEmployeeForIdCard(int idCard){
        JSONObject json = new JSONObject();

        try(Connection connect = DriverManager.getConnection(connectionUrl)){
            ResultSet rs = connect.createStatement().executeQuery("SELECT * FROM employee where identity_card = '"+idCard+"'");
            rs.next();
            json.put("idCard", rs.getString("identity_card"));
            json.put("salary", rs.getString("salary"));
        } catch (SQLException e){
            e.printStackTrace();
        }
        return json;
    }
    
}
