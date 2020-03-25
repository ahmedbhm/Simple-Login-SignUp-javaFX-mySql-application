package classes;

import java.sql.*;
import java.util.ArrayList;

public class Database {
    private final String Username="root";
    private final String Password="";
    private final String path="jdbc:mysql://localhost:3307/MiniProjet";
    private Connection conn=null;

    public Database() throws SQLException {
        conn=Connect();
    }

    public Connection Connect() throws SQLException {
        return DriverManager.getConnection(path, Username, Password);
    }
    public boolean passwordVirify(String username,String password) throws SQLException {
        boolean e=false;
        Statement stat = conn.createStatement();
        String selectQuery = "Select * from client where username='"+username+"' and password='"+password+"'";
        ResultSet results = stat.executeQuery(selectQuery);
        while (results.next())
        {
            e=true;
        }
        stat.close();
        return e;
    }
    public  int clientExist(String username) throws SQLException {
        int id=0;
        Statement stat = conn.createStatement();
        String selectQuery = "Select id from client where username='"+username+"'";
        ResultSet results = stat.executeQuery(selectQuery);
        while (results.next())
        {
            id=results.getInt(1);
        }
        stat.close();
        return id;
    }
    public void AddClient(String username,String password) throws SQLException {
        String query ="INSERT INTO client(username,password) VALUES ('"+username+"','"+password+"')";
        Statement stat = conn.createStatement();
        stat.executeUpdate(query);
    }
}

