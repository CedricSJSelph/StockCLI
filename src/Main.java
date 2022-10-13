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
    public static String[] stockInformationAPI(String stockName) throws IOException {
        String StockInformation[] = new String[5];
        //https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=IBM&outputsize=full&apikey=demo
        String urlName = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol="+stockName+"&outputsize=full&apikey=UV3XPIKPFL8VOWIA";
        URL url = new URL(urlName);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        Map<String, String> parameters = new HashMap<>();
        parameters.put("param1", "val");

        con.setDoOutput(true);
        DataOutputStream out = new DataOutputStream(con.getOutputStream());
        out.writeBytes(ParameterStringBuilder.getParamsString(parameters));
        out.flush();
        out.close();

        con.setConnectTimeout(5000);
        con.setReadTimeout(5000);

        //parameters.forEach((key, value) -> System.out.println(key + " : " + value));

        //Temp data:
        StockInformation[0] = "0.0";
        StockInformation[1] = "0.0";
        StockInformation[2] = "0.0";
        StockInformation[3] = "0.0";
        StockInformation[4] = "0.0";

        return StockInformation;
    }

    public class ParameterStringBuilder {
        public static String getParamsString(Map<String, String> params)
                throws UnsupportedEncodingException{
            StringBuilder result = new StringBuilder();
            for (Map.Entry<String, String> entry : params.entrySet()) {
                result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
                result.append("=");
                result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
                result.append("&");
            }

            String resultString = result.toString();
            return resultString.length() > 0
                    ? resultString.substring(0, resultString.length() - 1)
                    : resultString;
        }
    }
}