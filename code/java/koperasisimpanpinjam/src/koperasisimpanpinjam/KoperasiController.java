/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koperasisimpanpinjam;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author YOGIE
 */
public class KoperasiController implements Initializable {
    

    @FXML
    private TextField tfpNRekeningID;

    @FXML
    private TextField tfpNsaldo;

    @FXML
    private Button btniDaftarkan;

    @FXML
    private Button btnpTambahRek;

    @FXML
    private Button btnpRefresh;

    @FXML
    private TableColumn<Rekening, Integer> cpNorek;

    @FXML
    private Button btniRefresh;

    @FXML
    private TableColumn<Perusahaan, String> cpAlamat;

    @FXML
    private TableView<Perusahaan> tblpKoperasi;

    @FXML
    private TextField tfiAlamat;

    @FXML
    private TextField tfiNama;

    @FXML
    private TextField tfpAlamat;

    @FXML
    private TextField tfiNik;

    @FXML
    private TableColumn<Rekening, Integer> cpSaldo;

    @FXML
    private TableColumn<Individu, String> ciAlamat;

    @FXML
    private TableView<Rekening> tbliKoperasi2;

    @FXML
    private Button btniDeposit;

    @FXML
    private TextField tfpNib;

    @FXML
    private TableColumn<Perusahaan, String> cpNama;

    @FXML
    private TextField tfpDepoWD;

    @FXML
    private TextField tfiNorek;

    @FXML
    private Button btnpClear;

    @FXML
    private Button btnpWD;

    @FXML
    private TextField tfiNSaldo;

    @FXML
    private TextField tfiNpwp;

    @FXML
    private TextField tfiNNorek;

    @FXML
    private TextField tfiSaldo;

    @FXML
    private TableColumn<Perusahaan, Integer> cpRekeningID;

    @FXML
    private TableColumn<Rekening, Integer> ciNorek;

    @FXML
    private TableView<Rekening> tblpkoperasi2;

    @FXML
    private TextField tfpNNorek;

    @FXML
    private TableColumn<Individu, Integer> ciRekeningID;

    @FXML
    private Button btniWD;

    @FXML
    private TableColumn<Individu, String> ciNama;

    @FXML
    private TextField tfiDepoWD;

    @FXML
    private TextField tfpNama;

    @FXML
    private TableColumn<Rekening, Integer> ciSaldo;

    @FXML
    private TextField tfiNRekeningID;

    @FXML
    private TextField tfpRekeningID;

    @FXML
    private TextField tfpSaldo;

    @FXML
    private TextField tfiRekeningID;
    
    @FXML
    private TextField tfpRekDepoWD;
    
    @FXML
    private TextField tfiRekDepoWD;

    @FXML
    private TableView<Individu> tbliKoperasi;

    @FXML
    private TableColumn<Individu, Long> ciNik;

    @FXML
    private Button btnpDaftarkan;

    @FXML
    private Label LBStatus;
    
    @FXML
    private Label LiCek;
    
    @FXML
    private Label LpCek;

    @FXML
    private Button btniTambahRek;

    @FXML
    private Button btnpDeposit;

    @FXML
    private Button btniClear;

    @FXML
    private TextField tfpNorek;

    @FXML
    private TableColumn<Individu, Long> ciNpwp;

    @FXML
    private TableColumn<Perusahaan, Long> cpNib;
    
    private DataModel dm;
    
    @FXML
    void ihandlebtnDaftar(ActionEvent event) {
        Individu rek1 = new Individu(Integer.parseInt(tfiRekeningID.getText()),tfiNama.getText(), tfiAlamat.getText(),
                                    Long.parseLong(tfiNik.getText()), 
                                    Long.parseLong(tfiNpwp.getText()), 
                                    new Rekening(Integer.parseInt(tfiNorek.getText()),
                                    Double.parseDouble(tfiSaldo.getText())));
        try {
            dm.addNasabah(rek1);
            LiCek.setText("AKUN TERDAFTARKAN");
            btniClear.fire();
            btniRefresh.fire();
            btnpClear.fire();
            btnpRefresh.fire();
        } catch (SQLException ex) {
            LiCek.setText("AKUN GAGAL TERDAFTARKAN");
            Logger.getLogger(KoperasiController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void ihandlebtnRefresh(ActionEvent event) {
        ObservableList<Rekening> data2 = dm.IgetRekening();
        ciNorek.setCellValueFactory(new PropertyValueFactory<>("noRekening"));
        ciSaldo.setCellValueFactory(new PropertyValueFactory<>("saldo"));
        ObservableList<Individu> data = dm.getIndividu();
        ciRekeningID.setCellValueFactory(new PropertyValueFactory<>("rekeningid"));
        ciNama.setCellValueFactory(new PropertyValueFactory<>("nama"));
        ciAlamat.setCellValueFactory(new PropertyValueFactory<>("alamat"));
        ciNik.setCellValueFactory(new PropertyValueFactory<>("nik"));
        ciNpwp.setCellValueFactory(new PropertyValueFactory<>("npwp"));
     
        tbliKoperasi.setItems(null);
        tbliKoperasi.setItems(data);
        tbliKoperasi2.setItems(null);
        tbliKoperasi2.setItems(data2);
        btniTambahRek.setDisable(true);

    }

    @FXML
    void ihandleClear(ActionEvent event) {
    try {
        tfiRekeningID.setText("" + dm.nextRekeningID());
        tfiNorek.setText(tfiRekeningID.getText() + "01");
        tfiNama.setText("");
        tfiAlamat.setText("");
        tfiNik.setText("");
        tfiNpwp.setText("");
        tfiSaldo.setText("");

    } catch (SQLException ex) {
        Logger.getLogger(KoperasiController.class.getName()).log(Level.SEVERE, null, ex);
    }

    }

    @FXML
    void ihandlebtnTambahrek(ActionEvent event) {
        try {
            Rekening acc =  new Rekening(Integer.parseInt(tfiNNorek.getText()),
                            Double.parseDouble(tfiNSaldo.getText()));
            
            dm.addRekening(Integer.parseInt(tfiNRekeningID.getText()),acc);          
            IviewDataRekening(Integer.parseInt(tfiNRekeningID.getText()));
            btnpRefresh.fire();
            tfiSaldo.setText("");
            btniRefresh.fire();
            tfpSaldo.setText("");
            
        } catch (SQLException ex) {
            Logger.getLogger(KoperasiController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    void ihandlebtnDeposit(ActionEvent event) {
        try {
            dm.tambahSaldo(Integer.parseInt(tfiRekDepoWD.getText()), Integer.parseInt(tfiDepoWD.getText()));
            btnpRefresh.fire();
            tfiSaldo.setText("");
            btniRefresh.fire();
            tfpSaldo.setText("");        
        } catch (SQLException ex) {
            Logger.getLogger(KoperasiController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    void ihandlebtnWD(ActionEvent event) {
        try {
            dm.tarikSaldo(Integer.parseInt(tfiRekDepoWD.getText()), Integer.parseInt(tfiDepoWD.getText()));
            btnpRefresh.fire();
            tfiSaldo.setText("");
            btniRefresh.fire();
            tfpSaldo.setText("");
        } catch (SQLException ex) {
            Logger.getLogger(KoperasiController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    void phandlebtnDaftar(ActionEvent event) {
        Perusahaan rek2 = new Perusahaan(Integer.parseInt(tfpRekeningID.getText()),tfpNama.getText(), tfpAlamat.getText(),
                tfpNib.getText(), new Rekening(Integer.parseInt(tfpNorek.getText()),
                                    Double.parseDouble(tfpSaldo.getText())));
        try {
            dm.addNasabah(rek2);
            LpCek.setText("AKUN TERDAFTARKAN");
            btniClear.fire();
            btniRefresh.fire();
            btnpClear.fire();
            btnpRefresh.fire();
        } catch (SQLException ex) {
            LpCek.setText("AKUN GAGAL TERDAFTARKAN");
            Logger.getLogger(KoperasiController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    void phandlebtnRefresh(ActionEvent event) {
        ObservableList<Rekening> data3 = dm.PgetRekening();
        cpNorek.setCellValueFactory(new PropertyValueFactory<>("noRekening"));
        cpSaldo.setCellValueFactory(new PropertyValueFactory<>("saldo"));
        ObservableList<Perusahaan> data = dm.getPerusahaan();
        cpRekeningID.setCellValueFactory(new PropertyValueFactory<>("rekeningid"));
        cpNama.setCellValueFactory(new PropertyValueFactory<>("nama"));
        cpAlamat.setCellValueFactory(new PropertyValueFactory<>("alamat"));
        cpNib.setCellValueFactory(new PropertyValueFactory<>("nib"));
     
        tblpKoperasi.setItems(null);
        tblpKoperasi.setItems(data);
        tblpkoperasi2.setItems(null);
        tblpkoperasi2.setItems(data3);
        btnpTambahRek.setDisable(true);

    }

    @FXML
    void phandlebtnClear(ActionEvent event) {
    try {
        tfpRekeningID.setText("" + dm.nextRekeningID());
        tfpNorek.setText(tfpRekeningID.getText() + "01");
        tfpNama.setText("");
        tfpAlamat.setText("");
        tfpNib.setText("");
        tfpSaldo.setText("");

    } catch (SQLException ex) {
        Logger.getLogger(KoperasiController.class.getName()).log(Level.SEVERE, null, ex);
    }
        

    }

    @FXML
    void phandlebtnTambahRek(ActionEvent event) {
        try {
            Rekening acc =  new Rekening(Integer.parseInt(tfpNNorek.getText()),
                            Double.parseDouble(tfpNsaldo.getText()));
            
            dm.addRekening(Integer.parseInt(tfpNRekeningID.getText()),acc);          
            PviewDataRekening(Integer.parseInt(tfpNRekeningID.getText()));
            btnpRefresh.fire();
            tfiSaldo.setText("");
            btniRefresh.fire();
            tfpSaldo.setText("");
            
        } catch (SQLException ex) {
            Logger.getLogger(KoperasiController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    void phandlebtnDeposit(ActionEvent event) {
        try {
            dm.tambahSaldo(Integer.parseInt(tfpRekDepoWD.getText()), Integer.parseInt(tfpDepoWD.getText()));
            btnpRefresh.fire();
            tfiSaldo.setText("");
            btniRefresh.fire();
            tfpSaldo.setText("");        
        } catch (SQLException ex) {
            Logger.getLogger(KoperasiController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    void phandlebtnWD(ActionEvent event) {
        try {
            dm.tarikSaldo(Integer.parseInt(tfpRekDepoWD.getText()), Integer.parseInt(tfpDepoWD.getText()));
            btnpRefresh.fire();
            tfiSaldo.setText("");
            btniRefresh.fire();
            tfpSaldo.setText("");        
        } catch (SQLException ex) {
            Logger.getLogger(KoperasiController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            dm = new DataModel("SQLITE");
            LBStatus.setText(dm.conn == null ? "Connection lost" : "Connected");
            btniClear.fire();
            btniRefresh.fire();
            btnpClear.fire();
            btnpRefresh.fire();
            tfiRekeningID.setText(""+dm.nextRekeningID());
            tfiNorek.setText(tfiRekeningID.getText()+"01");
            tfpRekeningID.setText(""+dm.nextRekeningID());
            tfpNorek.setText(tfiRekeningID.getText()+"01");
            // TODO
        } catch (SQLException ex) {
            Logger.getLogger(KoperasiController.class.getName()).log(Level.SEVERE, null, ex);
        }
        tbliKoperasi.getSelectionModel().selectedIndexProperty().addListener(listener->{
            if (tbliKoperasi.getSelectionModel().getSelectedItem()!=null){
                Individu rek =  tbliKoperasi.getSelectionModel().getSelectedItem();
                IviewDataRekening(rek.getRekeningid());
                btniTambahRek.setDisable(false);
                tfiNRekeningID.setText(""+rek.getRekeningid());
                try {
                    tfiNNorek.setText(""+dm.nextRekeningNumber(rek.getRekeningid()));
                } catch (SQLException ex) {
                    Logger.getLogger(KoperasiController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        tblpKoperasi.getSelectionModel().selectedIndexProperty().addListener(listener->{
            if (tblpKoperasi.getSelectionModel().getSelectedItem()!=null){
                Perusahaan rek =  tblpKoperasi.getSelectionModel().getSelectedItem();
                PviewDataRekening(rek.getRekeningid());
                btnpTambahRek.setDisable(false);
                tfpNRekeningID.setText(""+rek.getRekeningid());
                try {
                    tfpNNorek.setText(""+dm.nextRekeningNumber(rek.getRekeningid()));
                } catch (SQLException ex) {
                    Logger.getLogger(KoperasiController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }    
    public void IviewDataRekening(int RekeningID){
        ObservableList<Rekening> data = dm.getRekenings(RekeningID);
        ciNorek.setCellValueFactory(new PropertyValueFactory<>("noRekening"));
        ciSaldo.setCellValueFactory(new PropertyValueFactory<>("saldo"));
        tbliKoperasi2.setItems(null);
        tbliKoperasi2.setItems(data);
//        cpNorek.setCellValueFactory(new PropertyValueFactory<>("noRekening"));
//        cpSaldo.setCellValueFactory(new PropertyValueFactory<>("saldo"));
//        tblpkoperasi2.setItems(null);
//        tblpkoperasi2.setItems(data);
    }
    public void PviewDataRekening(int RekeningID){
        ObservableList<Rekening> data = dm.getRekenings(RekeningID);
//        ciNorek.setCellValueFactory(new PropertyValueFactory<>("noRekening"));
//        ciSaldo.setCellValueFactory(new PropertyValueFactory<>("saldo"));
//        tbliKoperasi2.setItems(null);
//        tbliKoperasi2.setItems(data);
        cpNorek.setCellValueFactory(new PropertyValueFactory<>("noRekening"));
        cpSaldo.setCellValueFactory(new PropertyValueFactory<>("saldo"));
        tblpkoperasi2.setItems(null);
        tblpkoperasi2.setItems(data);
    }
    
}
