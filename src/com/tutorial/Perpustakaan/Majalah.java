package com.tutorial.Perpustakaan;

public class Majalah extends Buku{
    private String code,judul,penerbit,thn, cari;

    @Override
    public String toString() {
        return "Type : Majalah, " +
                "code='" + code + '\'' +
                ", judul='" + judul + '\'' +
                ", penerbit='" + penerbit + '\'' +
                ", thn='" + thn + '\'' ;
    }

    public Majalah(String code, String judul, String penerbit, String thn) {
        this.code = code;
        this.judul = judul;
        this.penerbit = penerbit;
        this.thn = thn;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
    }

    public void setThn(String thn) {
        this.thn = thn;
    }

    public String getCode() {
        return code;
    }

    public String getJudul() {
        return judul;
    }

    public String getPenerbit() {
        return penerbit;
    }

    public String getThn() {
        return thn;
    }

    public String getCari() {
        return cari;
    }

    public void setCari(String cari) {
        this.cari = cari;
    }

    public void getTitle(){
        this.titleSearch = cari;
    }


}
