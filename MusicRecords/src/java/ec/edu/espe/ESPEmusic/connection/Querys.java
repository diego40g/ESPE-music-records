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
    private List<Song> listSongs;
    
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
    
    public List<MembersBand> MembersPosition(String position){
        MembersBand membersBand = null;
        try {
                  
            String sql = "SELECT * FROM MEMBERS_BAND WHERE POSITION = '" + position + "')";
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
    public List<Song> songByNameBand (String band){
        Song song = null;
        try {
                  
            String sql = "SELECT NOMBRE_CANCION FROM CANCION WHERE CODIGO_BANDA IN (SELECT CODIGO_BANDA FROM BANDA WHERE NOMBRE_BANDA='" + band + "')ORDER BY NOMBRE_CANCION;";
            PreparedStatement order = dataBase.prepareStatement(sql);
            ResultSet rs = order.executeQuery();
            listSongs = new ArrayList<Song>();
            while (rs.next()){
                song = new Song();
                song.setNombreCancion(rs.getString("NOMBRE_CANCION"));
                
                listSongs.add(song);
            }            
            order.close();
            order = null;            
        } catch (SQLException ex) {
            Logger.getLogger(MembersBand.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return listSongs;           
    }
    public List<String> bandaSong (String songName){
        List<String> res = new ArrayList<String>();;
        String respuesta;
        try {
                  
            String sql = "//SELECT NOMBRE_BANDA,GENERO_BANDA FROM BAND WHERE CODIGO_MUSICO IN (SELECT CODIGO_MUSICO FROM SONG WHERE NOMBRE_CANCION='" + songName + "')ORDER BY NOMBRE_CANCION;";
            PreparedStatement order = dataBase.prepareStatement(sql);
            ResultSet rs = order.executeQuery();
            
            while (rs.next()){
                respuesta = new String();
                respuesta += rs.getString("NOMBRE_BANDA");  
                respuesta += ",";
                respuesta += rs.getString("GENERO_BANDA");
                res.add(respuesta);
            }            
            order.close();
            order = null;            
        } catch (SQLException ex) {
            Logger.getLogger(MembersBand.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return res;           
    }
    
}   
