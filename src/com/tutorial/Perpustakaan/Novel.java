package com.tutorial.Perpustakaan;

public class Novel extends Buku {
    private String code,judul,penerbit,thn,penulis, cari;

    @Override
    public String toString() {
        return "Type : Novel, " +
                "code='" + code + '\'' +
                ", judul='" + judul + '\'' +
                ", penerbit='" + penerbit + '\'' +
                ", thn='" + thn + '\'' +
                ", penulis='" + penulis + '\'' ;
    }

    public Novel(String code, String judul, String penerbit, String thn, String penulis) {
        this.code = code;
        this.judul = judul;
        this.penerbit = penerbit;
        this.thn = thn;
        this.penulis = penulis;
    }

    public void getTitle(){
        this.titleSearch = cari;
    }

    public String getCode() {
        return code;
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

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public void setCari(String cari) {
        this.cari = cari;
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

    public String getPenulis() {
        return penulis;
    }

    public String getCari() {
        return cari;
    }
}
