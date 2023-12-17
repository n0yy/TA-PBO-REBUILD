import java.util.Scanner;
import connector.*;

public class Menu {
    Scanner input = new Scanner(System.in);
    Customer customer = new Customer("Ticket.db");
    Film film = new Film("Ticket.db");
    Invoice invoice = new Invoice("Ticket.db");


    public Menu() {
        System.out.println("\n======== MENU ========");
        System.out.println("1. Tambah Data Film");
        System.out.println("2. Buat Invoice");
        System.out.println("3. Keluar Program\n");
    }

    public void insertFilm() {
        film.insertDataFilm();
    }

    public void generateInvoice() {
        System.out.println("---------------------- Pemesanan Tiket -------------------------");
        System.out.print("Nama Lengkap\t: ");
        String nama = input.nextLine();
        System.out.print("Umur\t\t: ");
        int umur = input.nextInt();
        System.out.print("No. Telp\t: ");
        String telp = input.next();
        
        film.getAllFilm();
        
        System.out.println("-------------------------- PILIH FILM --------------------------");
        System.out.print("Masukan id film (ex: 5) : ");
        int idFilm = input.nextInt();
        System.out.print("Masukan quantity\t: ");
        int quantity = input.nextInt();
        
        customer.insert(nama, telp, umur);
        invoice.generate(idFilm, quantity);
    }

}
