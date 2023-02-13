package com.tutorial.Perpustakaan.configDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectApp {
    String urlDb = "jdbc:postgresql://localhost/enig_pus";
     String usernm = "postgres";
     String pswd = "Rahasia";

    public Connection connect() {
        Connection isConn = null;
        try {
            isConn = DriverManager.getConnection(urlDb, usernm, pswd);
            System.out.println("Anda terkoneksi ke database !");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return isConn;
    }
}
