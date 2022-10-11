import java.util.*;

public class Main {
    public static void main(String[] args) {
        String Answer = null;
        System.out.println("Welcome to the CLI Stock Retriever");
        do{

            Scanner scan = new Scanner(System.in);
            System.out.print("What ticker would like info on? (Enter \"EXIT\" to stop): ");
            String Stock = scan.next();

        }while(Answer!="EXIT");
    }
}