package sample;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDB {
    static Connection con = null;
    public static Connection getConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/Bank";
            con = DriverManager.getConnection(url , "root" , "");
            System.out.println("connecter");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
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

