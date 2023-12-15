package connector;

import java.sql.ResultSet;

public class Film extends Connector {
    public Film(String url) {
        super(url);
    }


    public void insertDataFilm() {
        System.out.print("\nJudul\t\t: "); String nama = s.nextLine();
        System.out.print("Rating\t\t: "); Float rating = Float.parseFloat(s.nextLine());
        System.out.print("Genres\t\t: "); String genres = s.nextLine();
        System.out.print("Price\t: "); int price = Integer.parseInt(s.nextLine());
        System.out.print("18++ (0/1) | (No/Yes)\t: "); int isAdult = Integer.parseInt(s.nextLine());
        System.out.print("Duration\t: "); int duration = Integer.parseInt(s.nextLine());

        insert(nama, rating, genres, price, isAdult, duration);
    }

    public void getAllFilm() {
        try {
            ResultSet res = this.statement.executeQuery("SELECT * FROM film");
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("%-5s%-50s%-15s%-40s%-15s%-15s%n", "id", "Nama", "Rating", "Genres", "Harga", "18+");
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
            while (res.next()) {
                int id = res.getInt("id");
                String nama = res.getString("nama");
                float rating = res.getFloat("rating");
                String genres = res.getString("genres");
                int price = res.getInt("harga");
                int isAdult = res.getInt("iniFilmDewasa");
                String adult;
    
                if (isAdult == 1) {
                    adult = "Ya";
                } else if (isAdult == 0) {
                    adult = "Tidak";
                } else {
                    adult = "Undefined";
                }
    
                System.out.printf("%-5s%-50s%-15s%-40s%-15d%-15s%n", id, nama, rating, genres, price, adult);
            }
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
