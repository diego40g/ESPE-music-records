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
    private final List<Band> listBand;
    private List<MembersBand> listMembersBand;
    private List<Song> listSong;
    private List<Album> listAlbum;
    private List<Manager> listManager;
    
    public Querys(){
        connectionBD = new Connection();
        dataBase = connectionBD.connect();
        listAdmin = new ArrayList<AdministratorRecordMusic>();
        listBand = new ArrayList<Band>();
        listSong = new ArrayList<Song>();
        listAlbum = new ArrayList<Album>();
        listManager = new ArrayList<Manager>();
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
    
    public List<Band> allBand(){
        Band band = null;
        try {
                  
            String sql = "SELECT * FROM BAND GROUP BY NAME_BAND";
            PreparedStatement order = dataBase.prepareStatement(sql);
            ResultSet rs = order.executeQuery();
            
            while (rs.next()){
                band = new Band();
                band.setNameBand(rs.getString("NAME_BAND"));
                band.setNumberParticipants(rs.getInt("NUMBER_PARTICIPANTS"));
                band.setGenderBand(rs.getString("GENDER_BAND"));
                listBand.add(band);
            }            
            order.close();
            order = null;            
        } catch (SQLException ex) {
            Logger.getLogger(Band.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return listBand;           
    }
    
    public List<Song> allSong(){
        Song song = null;
        try {
                  
            String sql = "SELECT * FROM SONG";
            PreparedStatement order = dataBase.prepareStatement(sql);
            ResultSet rs = order.executeQuery();
            
            while (rs.next()){
                song = new Song();
                song.setNameSong(rs.getString("NAME_SONG"));
                song.setDuration(rs.getTime("DURATION"));
                song.setGenderSong(rs.getString("GENDER_SONG"));
                listSong.add(song);
            }            
            order.close();
            order = null;            
        } catch (SQLException ex) {
            Logger.getLogger(Song.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return listSong;           
    }
    
    public List<Album> allAlbum(){
        Album album = null;
        try {
                  
            String sql = "SELECT * FROM ALBUM";
            PreparedStatement order = dataBase.prepareStatement(sql);
            ResultSet rs = order.executeQuery();
            
            while (rs.next()){
                album = new Album();
                album.setNameAlbum(rs.getString("NAME_ALBUM"));
                album.setGenderAlbum(rs.getString("GENDER_ALBUM"));
                album.setNumberSongs(rs.getString("NUMBER_SONGS"));
                listAlbum.add(album);
            }            
            order.close();
            order = null;            
        } catch (SQLException ex) {
            Logger.getLogger(Album.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return listAlbum;           
    }
    
    public List<Manager> allManager(){
        Manager manager = null;
        try {
                  
            String sql = "SELECT * FROM MANAGER";
            PreparedStatement order = dataBase.prepareStatement(sql);
            ResultSet rs = order.executeQuery();
            
            while (rs.next()){
                manager = new Manager();
                manager.setCodeManager(rs.getString("CODE_MANAGER"));
                manager.setLastNameManager(rs.getString("LASTNAME_MANAGER"));
                manager.setNameManager(rs.getString("NAME_MANAGER"));
                manager.setEmailManager(rs.getString("EMAIL_MANAGER"));
                manager.setPhoneManager(rs.getString("PHONE_MANAGER"));
                listManager.add(manager);
            }            
            order.close();
            order = null;            
        } catch (SQLException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return listManager;           
    }
    
    public List<MembersBand> allMembersBand(){
        MembersBand membersBand = null;
        try {
                  
            String sql = "SELECT * FROM MEMBERS_BAND";
            PreparedStatement order = dataBase.prepareStatement(sql);
            ResultSet rs = order.executeQuery();
            
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
    
    public List<MembersBand> membersPosition(String position){
        MembersBand membersBand = null;
        try {
                  
            String sql = "SELECT * FROM MEMBERS_BAND WHERE POSITION = '" + position + "'";
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
                  
            String sql = "SELECT NAME_SONG FROM SONG WHERE CODE_BAND IN (SELECT CODE_BAND FROM BAND WHERE NAME_BAND='" + band + "')ORDER BY NAME_SONG;";
            PreparedStatement order = dataBase.prepareStatement(sql);
            ResultSet rs = order.executeQuery();
            listSong = new ArrayList<Song>();
            while (rs.next()){
                song = new Song();
                song.setNameSong(rs.getString("NAME_SONG"));
                
                listSong.add(song);
            }            
            order.close();
            order = null;            
        } catch (SQLException ex) {
            Logger.getLogger(MembersBand.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return listSong;           
    }
    
    public List<String> bandBySong (String songName){
        List<String> res = new ArrayList<String>();;
        String respuesta;
        try {
                  
            String sql = "SELECT NAME_BAND,GENDER_BAND FROM BAND WHERE CODE_MUSICAL IN (SELECT CODE_MUSICAL FROM SONG WHERE NAME_SONG='" + songName + "');";
            PreparedStatement order = dataBase.prepareStatement(sql);
            ResultSet rs = order.executeQuery();
            
            while (rs.next()){
                respuesta = new String();
                respuesta += rs.getString("NAME_BAND");  
                respuesta += ",";
                respuesta += rs.getString("GENDER_BAND");
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
