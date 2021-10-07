/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koperasisimpanpinjam;

import java.util.ArrayList;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author YOGIE
 */
public class Individu extends Nasabah{
    private LongProperty nik;
    private LongProperty npwp;
    private IntegerProperty rekeningid;

    public Individu(int rekeningid,String nama, String alamat,long nik, long npwp , ArrayList<Rekening> rekening) {
        super(nama, alamat, rekening);
        this.nik = new SimpleLongProperty(nik);
        this.npwp = new SimpleLongProperty(npwp);
        this.rekeningid = new SimpleIntegerProperty(rekeningid);
    }

    public Individu(int rekeningid,String nama, String alamat,long nik, long npwp, Rekening rekening) {
        super(nama, alamat, rekening);
        this.nik = new SimpleLongProperty(nik);
        this.npwp = new SimpleLongProperty(npwp);
        this.rekeningid = new SimpleIntegerProperty(rekeningid);
    }
        public long getNik() {
        return nik.get();
    }

    public void setNik(long nik) {
        this.nik.set(nik);
    }

    public long getNpwp() {
        return npwp.get();
    }
    public int getRekeningid() {
        return rekeningid.get();
    }

    public void setNpwp(long npwp) {
        this.npwp.set(npwp);
    }
    public void setRekeningid(int rekeningid) {
        this.rekeningid.set(rekeningid);
    }

    public LongProperty nikProperty() {
        return nik;
    }
    
    public IntegerProperty rekeningidProperty() {
    return rekeningid;
    }

    public LongProperty npwpProperty() {
        return npwp;
    }

    @Override
    public void print() {
        System.out.println ("NIk : "+ nik);
        System.out.println ("Npwp : "+ npwp);
    }
    
}
