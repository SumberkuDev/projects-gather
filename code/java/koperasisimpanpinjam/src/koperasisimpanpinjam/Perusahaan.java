/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koperasisimpanpinjam;

import java.util.ArrayList;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author YOGIE
 */
public class Perusahaan extends Nasabah {
      StringProperty nib;
      IntegerProperty rekeningid;

    public Perusahaan(int rekeningid,String nama, String alamat, String nib, ArrayList<Rekening> rekening) {
        super(nama, alamat, rekening);
        this.nib=new SimpleStringProperty(nib);
        this.rekeningid = new SimpleIntegerProperty(rekeningid);
    }

    public Perusahaan(int rekeningid,String nama, String alamat, String nib, Rekening rekening) {
        super(nama, alamat, rekening);
        this.nib=new SimpleStringProperty(nib);
        this.rekeningid = new SimpleIntegerProperty(rekeningid);
    }
    public int getRekeningid() {
        return rekeningid.get();
    }
    public IntegerProperty rekeningidProperty() {
    return rekeningid;
    }
    public void setRekeningid(int rekeningid) {
        this.rekeningid.set(rekeningid);
    }
    public String getNib() {
        return nib.get();
    }

    public void setNib(String nib) {
        this.nib.set(nib);
    }
    public StringProperty nibProperty() {
        return nib;
    }

    @Override
    public void print() {
        System.out.println ("Nib : "+ nib);
    }
    
}
