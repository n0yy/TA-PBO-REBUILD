
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        
        do {
            Menu menu = new Menu();
            System.out.print("Pilih : "); int choices = input.nextInt();

            if (choices == 1) {
                menu.insertFilm();
            } else if (choices == 2) {
                menu.generateInvoice();
            } else {
                break;
            }
            
        } while (true);

        input.close();

    }
}
