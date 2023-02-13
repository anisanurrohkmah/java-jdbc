package com.tutorial.Perpustakaan;

import java.sql.SQLException;
import java.util.List;

public interface inventoryService {

     public void addBookM(Majalah majalah) throws SQLException;
     public void addBookN(Novel novel) throws SQLException;
    public void searchBook(Buku titleSearch) throws SQLException;
     public void getAllBook() throws SQLException;
//    public List<Novel> getAllBookN() throws SQLException;

}
