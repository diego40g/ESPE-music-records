/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.connection;

/**
 *
 * @author galle
 */
public class Querys {
    Connection connectionBD;
    java.sql.Connection dataBase;
    
    public Querys(){
        connectionBD = new Connection();
        dataBase = connectionBD.connect();
    }
}
