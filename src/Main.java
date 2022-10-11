import java.util.*;
/*

MSFT
--------
Open: $121.66
High: $122.43
Low: $118.81
Current: $121.58
Volumne: 5346108
 */
public class Main {
    public static void main(String[] args) {
        String Answer = null;
        System.out.println("Welcome to the CLI Stock Retriever");
        do{

            Scanner scan = new Scanner(System.in);
            System.out.print("What ticker would like info on? (Enter \"EXIT\" to stop): ");
            String Stock = scan.next();
            String[] info = stockInformationAPI(Stock);

            StockInfo stock = new StockInfo(Float.parseFloat(info[0]),
                                            Float.parseFloat(info[1]),
                                            Float.parseFloat(info[2]),
                                            Float.parseFloat(info[3]),
                                            Float.parseFloat(info[4]),
                                            Stock);

            System.out.println(stock.getName());
            System.out.println("~~~~~~~~~~~~~~~~~~~~");
            System.out.println("Open: "  + stock.getOpen());
            System.out.println("High: " + stock.getHigh());
            System.out.println("Low: " + stock.getLow());
            System.out.println("Current: " + stock.getCurrent());
            System.out.println("Volume: " + stock.getVolume());

        }while(Answer!="EXIT");
    }

    public static String[] stockInformationAPI(String stockName){
        String StockInformation[] = new String[5];
            //Do API stuff
        return StockInformation;
    }
}