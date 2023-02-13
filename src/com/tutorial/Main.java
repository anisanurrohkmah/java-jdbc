package com.tutorial;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Database perpustakaan\n");
        System.out.println("1.\tLihat seluurh buku");
        System.out.println("2.\tCari Data Buku");
        System.out.println("3.\tTambah buku");
        System.out.println("4.\tUbah buku");
        System.out.println("5.\tHapus buku");

        System.out.print("\n\npilih menu: ");

        Scanner inputanAnda = new Scanner(System.in);
        String pilihan;

        pilihan = inputanAnda.next();

        switch (pilihan){
            case "1":
                System.out.println("LIST BUKU");
                tampilkanData();
                break;
            case "2":
                System.out.println("CARI");
                break;
            case "3":
                System.out.println("TAMBAH");
                break;
            case "4":
                System.out.println("EDIT");
                break;
            case "5":
                System.out.println("HAPUS");
                break;
            default:
                System.err.println("Tidak cocok");

                System.out.println("\nApakah anda ingin melanjutkan?");
                pilihan = inputanAnda.next();

                boolean lanjut;
                  lanjut = pilihan.equalsIgnoreCase("y");

        }

    }

    private static void tampilkanData() throws IOException {
        FileReader fileinput;
        BufferedReader bufferInput;

        try {
            fileinput = new FileReader("database.txt");
            bufferInput = new BufferedReader(fileinput);
        }
        catch (Exception e){
            System.err.println("database no found");
            return;
        }

        String data = bufferInput.readLine();
//        System.out.println(data);

        System.out.println("| No |\t Penulis |\tPenerbit  |\t Judul");

        while (data != null) {
            StringTokenizer pisahan = new StringTokenizer(data, ",");


            pisahan.nextToken();
            System.out.printf("| %2d ", 1);
            System.out.printf("|\t%4s ", pisahan.nextToken());
            System.out.printf("|\t%s  ", pisahan.nextToken());
            data = bufferInput.readLine();
        }

    }
}
