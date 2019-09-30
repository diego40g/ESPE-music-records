/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.ESPEmusic.connection;

import ec.edu.espe.ESPEmusic.model.AdministratorRecordMusic;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author galle
 */
public class Querys {
    Connection connectionBD;
    java.sql.Connection dataBase;
    private final List<AdministratorRecordMusic> listAdmin;
    
    public Querys(){
        connectionBD = new Connection();
        dataBase = connectionBD.connect();
        listAdmin = new ArrayList<AdministratorRecordMusic>();
    }
    
    public List<AdministratorRecordMusic> consultaAdminJSON(){
        AdministratorRecordMusic administratorRecordMusic = null;
        try {
                  
            String sql = "SELECT * FROM ADMINISTRADOR_RECORD_MUSIC";
            PreparedStatement order = dataBase.prepareStatement(sql);
            ResultSet rs = order.executeQuery();
            
            while (rs.next()){
                administratorRecordMusic = new AdministratorRecordMusic();
                administratorRecordMusic.setCodigoAdmin(rs.getString("CODIGO_ADMIN"));               
                administratorRecordMusic.setApellidoAdmin(rs.getString("APELLIDO_ADMIN"));
                administratorRecordMusic.setNombreAdmin(rs.getString("NOMBRE_ADMIN"));
                administratorRecordMusic.setEmailAdmin(rs.getString("EMAIL_ADMIN"));
                administratorRecordMusic.setTelefonoAdmin(rs.getString("TELEFONO_ADMIN"));
                listAdmin.add(administratorRecordMusic);
            }            
            order.close();
            order = null;            
        } catch (SQLException ex) {
            Logger.getLogger(AdministratorRecordMusic.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return listAdmin;           
    }
}
