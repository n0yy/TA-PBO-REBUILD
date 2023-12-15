package connector;

import java.sql.*;
import java.util.Scanner;

public class Connector {
    private String url;
    public Connection conn = null;
    public Statement statement = null;
    public Scanner s = null;
    
    public Connector(String url) {
        this.url = url;
        this.s = new Scanner(System.in);
        try {
            Class.forName("org.sqlite.JDBC");
            this.conn = DriverManager.getConnection("jdbc:sqlite:" + this.url);
            this.statement = conn.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Terjadi Error : " + e.getMessage());
        } 
    }

    public void insertTo(String query) {
        try {
            int res = this.statement.executeUpdate(query);

            if (res > 0) {
                System.out.println("Data Berhasil ditambahkan!");
            } else {
                System.out.println("Data Tidak dapat ditambahkan!");
            }
        } catch (Exception e) {
            System.out.println("Terjadi Error : " + e.getMessage());
        }
    }

    
    public void insert(String name, String telp, int umur) {
        String query = "INSERT INTO customer (nama, telp, umur) VALUES ('" + name + "', '" + telp + "', " + umur + ")";
        insertTo(query);
    }

    
    public void insert(String title, Float rating, String genres, int harga, int isAdult, int duration) {
        String query = "INSERT INTO Film (nama, rating, genres, harga, iniFilmDewasa, durasi) VALUES ('" + title + "', '" + rating + "', '" + genres + "', " + harga + ", " + isAdult + ", " + duration + ")";
        insertTo(query);
    }
    


}
