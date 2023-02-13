package com.tutorial.Perpustakaan;

import com.tutorial.Perpustakaan.configDB.ConnectApp;

import javax.naming.directory.SearchResult;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class inventoryServiceImpl implements inventoryService {

    ConnectApp dbConn = new ConnectApp();
    Connection isConnect = dbConn.connect();

    List<Majalah> majalahs = new ArrayList();
    List<Novel> novels = new ArrayList();

    public void getAllBook() throws SQLException {

        Statement statement = isConnect.createStatement();

        ResultSet resultSet1 = statement.executeQuery("SELECT * FROM majalah");
        while (resultSet1.next()) {
            String code = resultSet1.getString("code");
            String judul = resultSet1.getString("judul");
            String penerbit = resultSet1.getString("penerbit");
            String thn = resultSet1.getString("tahun_terbit");
            majalahs.add(new Majalah(code, judul, penerbit, thn));
        }

        ResultSet resultSet2 = statement.executeQuery("SELECT * FROM novel");
        while (resultSet2.next()) {
            String code = resultSet2.getString("code");
            String judul = resultSet2.getString("judul");
            String penerbit = resultSet2.getString("penerbit");
            String thn = resultSet2.getString("tahun_terbit");
            String penulis = resultSet2.getString("penulis");
            novels.add(new Novel(code, judul, penerbit, thn,penulis));
        }
        statement.close();
        isConnect.close();
        novels.forEach( (n) -> { System.out.println(n); } );
        majalahs.forEach( (n) -> { System.out.println(n); } );
    }


    public void searchBook(String titleCari) throws SQLException{
        Statement statement = isConnect.createStatement();

        ResultSet resultSet1 = statement.executeQuery("SELECT * FROM novel where judul='"+titleCari+"' ");
        while (resultSet1.next()) {
            String code = resultSet1.getString("code");
            String judul = resultSet1.getString("judul");
            String penerbit = resultSet1.getString("penerbit");
            String thn = resultSet1.getString("tahun_terbit");
            String penulis = resultSet1.getString("penulis");
            novels.add(new Novel(code, judul, penerbit, thn, penulis));
            System.out.println(novels);
        }
        ResultSet resultSet = statement.executeQuery("SELECT * FROM majalah where judul='"+titleCari+"' ");
        while (resultSet.next()) {
            String code = resultSet.getString("code");
            String judul = resultSet.getString("judul");
            String penerbit = resultSet.getString("penerbit");
            String thn = resultSet.getString("tahun_terbit");
            majalahs.add(new Majalah(code, judul, penerbit, thn));
            System.out.println(majalahs);
        }
        statement.close();
        isConnect.close();
    }

    public  void addBookN(Novel novel) throws SQLException{
        Statement statement = isConnect.createStatement();
        String sql = "INSERT INTO novel  (code, judul, penerbit, tahun_terbit, penulis )  VALUES ('"+novel.getCode()+"', '"+novel.getJudul()+"','"+novel.getPenerbit()+"','"+novel.getThn()+"','"+novel.getPenulis()+"' )";
        statement.executeUpdate(sql);

        ResultSet resultSet2 = statement.executeQuery("SELECT * FROM novel");
        while (resultSet2.next()) {
            String code = resultSet2.getString("code");
            String judul = resultSet2.getString("judul");
            String penerbit = resultSet2.getString("penerbit");
            String thn = resultSet2.getString("tahun_terbit");
            String penulis = resultSet2.getString("penulis");
            novels.add(new Novel(code, judul, penerbit, thn,penulis));
        }
        System.out.println("=".repeat(25));
        System.out.println("Data sukses disimpan");

        novels.forEach( (n) -> { System.out.println(n); } );
        statement.close();
        isConnect.close();
    };


    public  void addBookM(Majalah majalah) throws SQLException{
        Statement statement = isConnect.createStatement();
        String sql = "INSERT INTO novel  (code, judul, penerbit, tahun_terbit )  VALUES ('"+majalah.getCode()+"', '"+majalah.getJudul()+"','"+majalah.getPenerbit()+"','"+majalah.getThn()+"' )";
        statement.executeUpdate(sql);

        ResultSet resultSet2 = statement.executeQuery("SELECT * FROM novel");
        while (resultSet2.next()) {
            String code = resultSet2.getString("code");
            String judul = resultSet2.getString("judul");
            String penerbit = resultSet2.getString("penerbit");
            String thn = resultSet2.getString("tahun_terbit");
            majalahs.add(new Majalah(code, judul, penerbit, thn));
        }
        System.out.println("=".repeat(25));
        System.out.println("Data sukses disimpan");

        majalahs.forEach( (n) -> { System.out.println(n); } );
        statement.close();
        isConnect.close();
    };

}
