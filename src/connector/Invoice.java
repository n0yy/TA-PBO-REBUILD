package connector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class Invoice extends Connector {
    private Random rand;
    public Invoice(String url) {
        super(url);
        this.rand = new Random();
    }

    public void generate(int idFilm, int quantity) {
        try {
            ResultSet lastCustomer = this.statement.executeQuery("SELECT * FROM customer "  +
                                                                 "ORDER BY id DESC LIMIT 1");
            int idCustomer = lastCustomer.getInt("id");
            String namaCustomer = lastCustomer.getString("nama");

            ResultSet film = this.statement.executeQuery("SELECT * FROM Film WHERE id=" + idFilm);
            String namaFilm = film.getString("nama");
            int priceFilm = film.getInt("harga");
            int totalPrice = priceFilm * quantity;
            int seat = this.rand.nextInt(50) + 1;
            int jamTayang = rand.nextInt(24);

            // masukin ke table invoice
            String query = "INSERT INTO Invoice (id_customer, id_film, seat, jam_tayang, price, quantity) VALUES ('" + idCustomer + "', '" + idFilm + "', '" + seat + "', '" + jamTayang + "', '" + totalPrice + "', '" + quantity + "')";
            this.statement.executeUpdate(query);

            // GENERATE INVOICE
            System.out.println("---------------------------- INVOICE ----------------------------");
            System.out.println("Nama\t\t : " + namaCustomer);
            System.out.println("Film\t\t : " + namaFilm);
            System.out.println("Quantity\t : " + quantity);
            System.out.println("Total Harga \t : " + totalPrice);
            System.out.print("Seat\t\t : ");
            for (int i = 0; i < quantity; i++) {
                System.out.print(seat+i + " ");
            }
            System.out.println("\nJam Tayang\t : " + jamTayang + ".00 WIB");
            System.out.println("------------------------------------------------------------------");
             
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


}
