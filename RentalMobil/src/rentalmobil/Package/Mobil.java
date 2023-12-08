/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rentalmobil.Package;

/**
 *
 * @author nurka
 */
public class Mobil {
    private String id;
    private String jenis;
    private String sewa;
    private String stok;

    public Mobil() {
        this.id = "";
        this.jenis = "";
        this.sewa = "";
        this.stok = "";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getSewa() {
        return sewa;
    }

    public void setSewa(String sewa) {
        this.sewa = sewa;
    }

    public String getStok() {
        return stok;
    }

    public void setStok(String stok) {
        this.stok = stok;
    }        
}
