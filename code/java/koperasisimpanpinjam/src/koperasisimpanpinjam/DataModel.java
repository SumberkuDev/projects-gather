/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koperasisimpanpinjam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import koperasisimpanpinjam.db.DBHelper;

/**
 *
 * @author YOGIE
 */
public class DataModel {
        public final Connection conn;
        
    public DataModel(String driver) throws SQLException {
        this.conn = DBHelper.getConnection(driver);
    }
    public void addNasabah(Individu rekening) throws SQLException{
        String insertHolder = "INSERT INTO Nasabah (rekening,nama, alamat)"
                + " VALUES (?,?,?)";
        String insertindividu = "INSERT INTO individu (rekening,nik, npwp)"
                + " VALUES (?,?,?)";
        String insertRekening = "INSERT INTO rekening (noRekening, saldo, rekening)"
                + " VALUES (?,?,?)";
        PreparedStatement stmtHolder = conn.prepareStatement(insertHolder);
        stmtHolder.setInt(1, rekening.getRekeningid());
        stmtHolder.setString(2, rekening.getNama());
        stmtHolder.setString(3, rekening.getAlamat());
        stmtHolder.execute();
        
        PreparedStatement stmtindividu = conn.prepareStatement(insertindividu);
        stmtindividu.setInt(1,  rekening.getRekeningid());
        stmtindividu.setLong(2, rekening.getNik());
        stmtindividu.setLong(3, rekening.getNpwp());
        stmtindividu.execute();
        
        PreparedStatement stmtRekening = conn.prepareStatement(insertRekening);
        stmtRekening.setInt(1, rekening.getRekening().get(0).getNoRekening());
        stmtRekening.setDouble(2, rekening.getRekening().get(0).getSaldo());
        stmtRekening.setInt(3, rekening.getRekeningid());
        stmtRekening.execute();
        
    }
    public void addNasabah(Perusahaan rekening) throws SQLException{
        String insertHolder = "INSERT INTO Nasabah (rekening, nama, alamat)"
                + " VALUES (?,?,?)";
        String insertCorporate = "INSERT INTO perusahaan (rekening,nib)"
                + " VALUES (?,?)";
        String insertRekening = "INSERT INTO rekening (noRekening, saldo, rekening)"
                + " VALUES (?,?,?)";
        PreparedStatement stmtHolder = conn.prepareStatement(insertHolder);
        stmtHolder.setInt(1, rekening.getRekeningid());
        stmtHolder.setString(2, rekening.getNama());
        stmtHolder.setString(3, rekening.getAlamat());
        stmtHolder.execute();
        
        PreparedStatement stmtindividu = conn.prepareStatement(insertCorporate);
        stmtindividu.setInt(1, rekening.getRekeningid());
        stmtindividu.setString(2, rekening.getNib());
        stmtindividu.execute();
        
        PreparedStatement stmtRekening = conn.prepareStatement(insertRekening);
        stmtRekening.setInt(1, rekening.getRekening().get(0).getNoRekening());
        stmtRekening.setDouble(2, rekening.getRekening().get(0).getSaldo());
        stmtRekening.setInt(3, rekening.getRekeningid());
        stmtRekening.execute();
    }
    public ObservableList<Individu> getIndividu(){
        ObservableList<Individu> data = FXCollections.observableArrayList();
        String sql="SELECT `rekening`, `nama`,`alamat`, `nik`, `npwp` "
                + "FROM `Nasabah` NATURAL JOIN `individu` "
                + "ORDER BY nama";
        try {
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while (rs.next()){
                String sqlRekening = "SELECT noRekening, saldo "
                    + "FROM rekening WHERE rekening="+rs.getInt(1);
                ResultSet rsRekening = conn.createStatement().executeQuery(sqlRekening);
                ArrayList<Rekening> dataRekening = new ArrayList<>();
                while (rsRekening.next()){
                    dataRekening.add(new Rekening(rsRekening.getInt(1),rsRekening.getDouble(2)));
                }
                data.add(new Individu(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getLong(4),rs.getLong(5), dataRekening));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DataModel.class.getName()).log(Level.SEVERE, null, ex);
        }     
        return data;
    }
    public ObservableList<Perusahaan> getPerusahaan(){
        ObservableList<Perusahaan> data = FXCollections.observableArrayList();
        String sql="SELECT `rekening`, `nama`,`alamat`, `nib` "
                + "FROM `Nasabah` NATURAL JOIN `perusahaan` "
                + "ORDER BY nama";
        try {
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while (rs.next()){
                String sqlRekening = "SELECT noRekening, saldo "
                    + "FROM rekening WHERE rekening="+rs.getInt(1);
                ResultSet rsRekening = conn.createStatement().executeQuery(sqlRekening);
                ArrayList<Rekening> dataRekening = new ArrayList<>();
                while (rsRekening.next()){
                    dataRekening.add(new Rekening(rsRekening.getInt(1),rsRekening.getDouble(2)));
                }
                data.add(new Perusahaan(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4), dataRekening));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DataModel.class.getName()).log(Level.SEVERE, null, ex);
        }     
        return data;
    }
    public ObservableList<Rekening> IgetRekening(){
        ObservableList<Rekening> data2 = FXCollections.observableArrayList();
        String sql="SELECT `rekening`, `nik`,`npwp` "
                + "FROM `individu` "
                + "ORDER BY rekening";
        try {
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while (rs.next()){
                String sqlRekening = "SELECT noRekening, saldo "
                    + "FROM rekening WHERE rekening="+rs.getInt(1);
                ResultSet rsRekening = conn.createStatement().executeQuery(sqlRekening);
                ArrayList<Rekening> dataRekening = new ArrayList<>();
                while (rsRekening.next()){
                    data2.add(new Rekening(rsRekening.getInt(1),rsRekening.getDouble(2)));
                }
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DataModel.class.getName()).log(Level.SEVERE, null, ex);
        }     
        return data2;
    }
    public ObservableList<Rekening> PgetRekening(){
        ObservableList<Rekening> data3 = FXCollections.observableArrayList();
        String sql="SELECT `rekening`, `nama`,`alamat`, `nib` "
                + "FROM `Nasabah` NATURAL JOIN `perusahaan` "
                + "ORDER BY nama";
        try {
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while (rs.next()){
                String sqlRekening = "SELECT noRekening, saldo "
                    + "FROM rekening WHERE rekening="+rs.getInt(1);
                ResultSet rsRekening = conn.createStatement().executeQuery(sqlRekening);
                ArrayList<Rekening> dataRekening = new ArrayList<>();
                while (rsRekening.next()){
                    data3.add(new Rekening(rsRekening.getInt(1),rsRekening.getDouble(2)));
                }
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DataModel.class.getName()).log(Level.SEVERE, null, ex);
        }     
        return data3;
    }
    public ObservableList<Rekening> getRekenings(int rekening){
        ObservableList<Rekening> data = FXCollections.observableArrayList();
        String sql="SELECT `noRekening`, `saldo` "
                + "FROM `rekening` "
                + "WHERE rekening="+rekening;
        try {
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while (rs.next()){
                data.add(new Rekening(rs.getInt(1),rs.getDouble(2)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return data;
    }
    public int nextRekeningID() throws SQLException{
        String sql="SELECT MAX(rekening) from Nasabah";
        ResultSet rs = conn.createStatement().executeQuery(sql);
        while (rs.next()){
                return rs.getInt(1)==0?1000001:rs.getInt(1)+1;
            }
        return 1000001;
    }
    public int nextRekeningNumber(int rekening) throws SQLException{
        String sql="SELECT MAX(noRekening) FROM rekening WHERE rekening="+rekening;
        ResultSet rs = conn.createStatement().executeQuery(sql);
        while (rs.next()){
                return rs.getInt(1)+1;
            }
        return 0;
     
    }
    
    public void addRekening(int rekening, Rekening acc) throws SQLException{
        String insertRek = "INSERT INTO rekening (rekening, noRekening, saldo)"
                + " VALUES (?,?,?)";
  
        PreparedStatement stmtRek = conn.prepareStatement(insertRek);
        stmtRek.setInt(1, rekening);
        stmtRek.setInt(2, acc.getNoRekening());
        stmtRek.setDouble(3, acc.getSaldo());
        stmtRek.execute();
        
    }
    public void tambahSaldo(int noRekening, int saldo) throws SQLException{
        String insertRek = "UPDATE rekening SET saldo = saldo + ? where noRekening = ?";
  
        PreparedStatement stmtRek = conn.prepareStatement(insertRek);
        stmtRek.setInt(1, saldo);
        stmtRek.setInt(2, noRekening);
        stmtRek.execute();
        
    }
        public void tarikSaldo(int noRekening, int saldo) throws SQLException{
        String insertRek = "UPDATE rekening SET saldo = saldo - ? where noRekening = ?";
  
        PreparedStatement stmtRek = conn.prepareStatement(insertRek);
        stmtRek.setInt(1, saldo);
        stmtRek.setInt(2, noRekening);
        stmtRek.execute();
        
    }
    
    
//    public void Deposit(double x) throws SQLException{
//    String insertHolder = "INSERT INTO rekening (rekening, noRekening, saldo)"
//            + " VALUES (?,?,?)";
//
//    PreparedStatement stmtHolder = conn.prepareStatement(insertHolder);
//    stmtHolder.setInt(1, rekening);
//    stmtHolder.setInt(2, acc.getNoRekening());
//    stmtHolder.setDouble(3, acc.getSaldo());
//    stmtHolder.execute();
//        
//    }
}
