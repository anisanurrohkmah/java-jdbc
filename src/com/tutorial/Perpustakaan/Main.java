package com.tutorial.Perpustakaan;
import com.tutorial.Perpustakaan.configDB.ConnectApp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.sql.SQLException;
public class Main {
    public static void main(String[] args) throws SQLException {

        boolean isMenu = true;

        ConnectApp dbConn = new ConnectApp();
        Connection isConnect = dbConn.connect();

        inventoryServiceImpl ivenImplemen = new inventoryServiceImpl();

        Majalah iniMajalah = new Majalah("", "", "", "");
        Novel iniNovel = new Novel("", "", "", "", "");


        while (isMenu) {
            System.out.println("=".repeat(25));
            System.out.println("Welcome To Enigpus Inventory");
            System.out.println("=".repeat(25));
            System.out.println("1.\tTambahkan buku");
            System.out.println("2.\tLihat list buku");
            System.out.println("3.\tCari buku berdasarkan judul");
            System.out.println("4.\tKeluar dari aplikasi");
            System.out.println("=".repeat(25));

            System.out.print("pilih menu: ");
            Scanner choice = new Scanner(System.in);
            String yourChoice = choice.nextLine();

            if (yourChoice.equalsIgnoreCase("1")) {
                  isMenu = false;
                System.out.println("=".repeat(25));
                System.out.println("Inputkan jenis buku : ");
                System.out.println("1.\tNovel");
                System.out.println("2.\tMajalah");

                System.out.println("=".repeat(25));
                Scanner opsi = new Scanner(System.in);
                String varietyBook = opsi.nextLine();

                if (varietyBook.equalsIgnoreCase("1")) {
                    System.out.print("Masukkan code buku : ");
                    String newCode = opsi.nextLine();
                    System.out.print("Masukkan judul buku : ");
                    String newTitle = opsi.nextLine();
                    System.out.print("Masukkan nama penerbit buku : ");
                    String newTerbit = opsi.nextLine();
                    System.out.print("Masukkan tahun terbit buku : ");
                    String newTahun = opsi.nextLine();
                    System.out.print("Masukkan penulis : ");
                    String newPenulis = opsi.nextLine();

                    Novel newNovel = new Novel(newCode, newTitle, newTerbit, newTahun, newPenulis);
                    ivenImplemen.addBookN((newNovel));
                } else if (varietyBook.equalsIgnoreCase("2")) {
                    System.out.print("Masukkan code buku : ");
                    String newCode = opsi.nextLine();
                    System.out.print("Masukkan judul buku : ");
                    String newTitle = opsi.nextLine();
                    System.out.print("Masukkan nama penerbit buku : ");
                    String newTerbit = opsi.nextLine();
                    System.out.print("Masukkan tahun terbit buku : ");
                    String newTahun = opsi.nextLine();

                    Majalah newMj = new Majalah(newCode, newTitle, newTerbit, newTahun);
                    ivenImplemen.addBookM((newMj));
                } else {
                    System.out.println("Salah kode jenis buku");
                }

            } else if (yourChoice.equalsIgnoreCase("2")) {
                isMenu = false;
                ivenImplemen.getAllBook();

                System.out.println("apakah anda masih ingin bertransaksi ? Y/T ");
                String next = choice.nextLine();
                if (yourChoice.equalsIgnoreCase("Y")) {
                    isMenu = true;
                }

            } else if (yourChoice.equalsIgnoreCase("3")) {
                  isMenu = false;
                System.out.print("ketik judul buku yang anda cari : ");
                String titleCari = choice.nextLine();

                System.out.println("Hasil pencarian buku dengan judul " + titleCari);
                System.out.println("=".repeat(25));


                ivenImplemen.searchBook(titleCari);

            } else if (yourChoice.equalsIgnoreCase("4")) {
                System.exit(0);
            }   else {
                System.out.println("aksi salah! tidak ditemukan");
            }
        }
    }

}
