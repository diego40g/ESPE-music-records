/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.ESPEmusic.connection;

import ec.edu.espe.ESPEmusic.model.*;
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
    private List<MembersBand> listMembersBand;
    
    public Querys(){
        connectionBD = new Connection();
        dataBase = connectionBD.connect();
        listAdmin = new ArrayList<AdministratorRecordMusic>();
        listMembersBand = null;
    }
    
    public List<AdministratorRecordMusic> allAdmin(){
        AdministratorRecordMusic administratorRecordMusic = null;
        try {
                  
            String sql = "SELECT * FROM ADMINISTRADOR_RECORD_MUSIC";
            PreparedStatement order = dataBase.prepareStatement(sql);
            ResultSet rs = order.executeQuery();
            
            while (rs.next()){
                administratorRecordMusic = new AdministratorRecordMusic();
                administratorRecordMusic.setCodeAdmin(rs.getString("CODE_ADMIN"));               
                administratorRecordMusic.setLastNameAdmin(rs.getString("LASTNAME_ADMIN"));
                administratorRecordMusic.setNameAdmin(rs.getString("NAME_ADMIN"));
                administratorRecordMusic.setEmailAdmin(rs.getString("EMAIL_ADMIN"));
                administratorRecordMusic.setPhoneAdmin(rs.getString("PHONE_ADMIN"));
                listAdmin.add(administratorRecordMusic);
            }            
            order.close();
            order = null;            
        } catch (SQLException ex) {
            Logger.getLogger(AdministratorRecordMusic.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return listAdmin;           
    }
    
    public List<MembersBand> membersOfBand(String band){
        MembersBand membersBand = null;
        try {
                  
            String sql = "SELECT * FROM MEMBERS_BAND MB WHERE MB.CODE_MUSICAL IN (SELECT CODE_MUSICAL FROM BAND WHERE NAME_BAND='" + band + "')";
            PreparedStatement order = dataBase.prepareStatement(sql);
            ResultSet rs = order.executeQuery();
            listMembersBand = new ArrayList<MembersBand>();
            while (rs.next()){
                membersBand = new MembersBand();
                membersBand.setCodeMusical(rs.getString("CODE_MUSICAL"));               
                membersBand.setLastName(rs.getString("LASTNAME"));
                membersBand.setName(rs.getString("NAME"));
                membersBand.setPosition(rs.getString("POSITION"));
                membersBand.setEmail(rs.getString("EMAIL"));
                membersBand.setPhone(rs.getString("PHONE"));
                listMembersBand.add(membersBand);
            }            
            order.close();
            order = null;            
        } catch (SQLException ex) {
            Logger.getLogger(MembersBand.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return listMembersBand;           
    }
}
