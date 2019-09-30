/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.ESPEmusic.connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author galle
 */
public class Connection {
    private static final String db = "recordMusic";
    private static final String URL = "jdbc:mariadb://localhost:3307/" + db;
    private static final String USERNAME = "root";
    private static final String PASSSWORD = "root";

    java.sql.Connection conn=null;
    
    public java.sql.Connection connect(){
                 
        try{
        Class.forName("org.mariadb.jdbc.Driver");
            conn=DriverManager.getConnection(URL, USERNAME, PASSSWORD);
            System.out.println("ENTRA");
            if(conn !=null)        {
                System.out.println("OK");
            }
            else{
                System.out.println("ERROR");
            }
        }
        catch(ClassNotFoundException e)
        {
            System.out.println(e);

        } catch (SQLException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
}
