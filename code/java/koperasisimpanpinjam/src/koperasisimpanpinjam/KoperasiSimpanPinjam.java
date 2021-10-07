/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koperasisimpanpinjam;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author YOGIE
 */
public class KoperasiSimpanPinjam extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Koperasi.fxml"));
        
        Scene scene = new Scene(root);
        stage.setTitle("KOPERASI");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
          launch(args);
//        try {
//            DataModel satu=new DataModel("MYSQL");
//            Rekening Yogi = new Rekening(17865, 12341000.);
//            Rekening udin = new Rekening(67576, 234234234.);
//            Individu u = new Individu("YOGI ANDARU", "KOTA METRO",34212319912123L, 223123428399123L, Yogi);
//            Perusahaan z = new Perusahaan("rgdfgdrgdfgd", "sefsdfsef","sefsdfsefsdfse", udin);
//            satu.addNasabah(u);
//            satu.addNasabah(z);
//            System.out.println("MASOK GAN");
//            
//            
//        } catch (SQLException ex) {
//            System.out.println("YAH COK GAGAL MASOK");
//            Logger.getLogger(KoperasiSimpanPinjam.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
}
