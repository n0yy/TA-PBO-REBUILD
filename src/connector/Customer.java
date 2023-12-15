package connector;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Customer extends Connector {
    
    public Customer(String url) {
        super(url);
        
    }

    public void insertDataCustomer() {
        System.out.print("\nNama\t\t: "); String name = s.nextLine();
        System.out.print("Umur\t\t: "); byte age = Byte.parseByte(s.nextLine());
        System.out.print("No. Telp\t: "); String telp = s.nextLine();

        insert(name, telp, age);
    }

    public void getAllCustomer() {
    try {
        ResultSet res = this.statement.executeQuery("SELECT * FROM customer");
        System.out.println("----------------------------------------------------------------------");
        System.out.printf("%-30s%-15s%-5s%n", "Nama", "Telp", "Umur");
        System.out.println("----------------------------------------------------------------------");
        while (res.next()) {
            String nama = res.getString("nama");
            String telp = res.getString("telp");
            int umur = res.getInt("umur");
            System.out.printf("%-30s%-15s%-5d%n", nama, telp, umur);
        }
        System.out.println("----------------------------------------------------------------------");
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
}


}
