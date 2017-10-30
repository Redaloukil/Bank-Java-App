package sample;

import javafx.fxml.FXML;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class ClientDB {
    static Connection con = null;


    public static Connection getConnection(){
        String url = "jdbc:mysql://localhost:3306/Bank";
        String username = "root";
        String password = "";
        System.out.println("Connecting database...");
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Database connected!");
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
        return con;
    }

    public static void getClients(){
        List<Client> clientList = new ArrayList<Client>();
        try{
            String sql = "SELECT * FROM 'Users' WHERE 1";
            Connection con = ClientDB.getConnection();
            PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Client client = new Client();
                client.setId(resultSet.getInt(1));
                client.setUsername(resultSet.getString(2));
                client.setPassword(resultSet.getString(3));
                clientList.add(client);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

