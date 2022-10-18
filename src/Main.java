import java.io.*;
import java.io.IOException;
import java.net.*;
import java.util.*;

//API Key UV3XPIKPFL8VOWIA
public class Main {
    public static void main(String[] args) throws IOException {
        String Answer = null;
        System.out.println("Welcome to the CLI Stock Retriever");
        do{
            Scanner scan = new Scanner(System.in);
            System.out.print("What ticker would like info on? (Enter \"EXIT\" to stop): ");
            String Stock = scan.nextLine();
            if((Stock.equals("EXIT")) || (Stock.equals("exit"))) {
                Answer = "EXIT";
            }else{
                double[] info = stockInformationAPI(Stock);
                StockInfo stock = new StockInfo(
                        info[0], //Open
                        info[1], //High
                        info[2], //Low
                        info[3], //Current
                        info[4], //Volume
                        Stock);                    //Name

                System.out.println();
                System.out.println(stock.getName());
                System.out.println("~~~~~~~~~~~~~~~~~~~~");
                System.out.printf("Open: %,.2f \n",stock.getOpen());// + stock.getOpen());
                System.out.printf("High: %,.2f \n",stock.getHigh());
                System.out.printf("Low: %,.2f \n",stock.getLow());
                System.out.printf("Current: %,.2f \n", stock.getCurrent());
                System.out.printf("Volume: %,.2f \n",stock.getVolume());

            }
        }while(Answer!="EXIT");
        System.out.println("You chose to exit, have a nice day <3");
    }
    public static double[] stockInformationAPI(String stockName) throws IOException {
        double StockInformation[] = new double[5];
        //https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=IBM&outputsize=full&apikey=demo
        String urlName = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol="+stockName+"&outputsize=full&apikey=UV3XPIKPFL8VOWIA&datatype=csv";
        URL url = new URL(urlName);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        con.setConnectTimeout(5000);
        con.setReadTimeout(5000);

        int status = con.getResponseCode();

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine).append(",").append("\n");
        }
        in.close();
        con.disconnect();

        StockInformation = parseWebData(content.toString());
        //Temp data

        return StockInformation;
    }
    public static double[] parseWebData(String info) {
        //7)open
        //8)high
        //9)low
        //10)close
        //11)volume

        double tempData[] = {0.0, 0.0, 0.0, 0.0, 0.0};
        String[] temp = info.split(",");
        for(int i = 7; i <12; i++){
            tempData[i-7] = Float.parseFloat(temp[i]);
        }
        return tempData;
    }
}