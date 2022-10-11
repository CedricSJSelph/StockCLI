import java.util.*;

public class Main {
    public static void main(String[] args) {
        String Answer = null;
        System.out.println("Welcome to the CLI Stock Retriever");

        do{
            Scanner scan = new Scanner(System.in);

            System.out.print("What ticker would like info on? (Enter \"EXIT\" to stop): ");
            String Stock = scan.nextLine();

            if((Stock.equals("EXIT")) || (Stock.equals("exit"))) {
                Answer = "EXIT";
            }else{
                String[] info = stockInformationAPI(Stock);

                StockInfo stock = new StockInfo(
                        Float.parseFloat(info[0]), //Open
                        Float.parseFloat(info[1]), //High
                        Float.parseFloat(info[2]), //Low
                        Float.parseFloat(info[3]), //Current
                        Float.parseFloat(info[4]), //Volume
                        Stock);                    //Name

                System.out.println();
                System.out.println(stock.getName());
                System.out.println("~~~~~~~~~~~~~~~~~~~~");
                System.out.println("Open: " + stock.getOpen());
                System.out.println("High: " + stock.getHigh());
                System.out.println("Low: " + stock.getLow());
                System.out.println("Current: " + stock.getCurrent());
                System.out.println("Volume: " + stock.getVolume());

            }
        }while(Answer!="EXIT");

        System.out.println("You chose to exit, have a nice day <3");
    }

    public static String[] stockInformationAPI(String stockName){
        String StockInformation[] = new String[5];
            //Do API stuff
        //Temp data:
        StockInformation[0] = "0.0";
        StockInformation[1] = "0.0";
        StockInformation[2] = "0.0";
        StockInformation[3] = "0.0";
        StockInformation[4] = "0.0";

        return StockInformation;
    }
}