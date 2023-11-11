import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'getNetProfit' function below.
     *
     * The function is expected to return a LONG_INTEGER_ARRAY.
     * The function accepts STRING_ARRAY events as parameter.
     */
    public static HashMap<String, Integer> numOfStocksMap = new HashMap<>();
    public static HashMap<String, Integer> priceMap = new HashMap<>();
    public static int profit = 0;
    public static List<Long> queryArr = new ArrayList<>();

    public static List<Long> getNetProfit(List<String> events) {
    // Write your code here
        for (String event : events) {
            if(event.contains("BUY")){
                String[] temp = event.split(" ");
                String company = temp[1];
                int stocks = Integer.parseInt(temp[2]);
                buyStocks(company, stocks);
            }
            else if(event.contains("SELL")){
                String[] temp = event.split(" ");
                String company = temp[1];
                int stocks = Integer.parseInt(temp[2]);
                sellStocks(company, stocks);
            }
            else if(event.contains("CHANGE")){
                String[] temp = event.split(" ");
                String company = temp[1];
                int stocks = Integer.parseInt(temp[2]);
                changePrice(company, stocks);
            }
            else{

            }
        }
        return queryArr;
    }
    
    public static void buyStocks(String company, int stocks){
        // add to the number map
        if(numOfStocksMap.get(company) != null){
            numOfStocksMap.put(company, numOfStocksMap.get(company) + stocks);
            // add to the price map
            priceMap.put(company, 0);
        }
        else{
            numOfStocksMap.put(company, stocks);
            }
        
    }
    public static void sellStocks(String company, int stocks){

    }
    public static void changePrice(String company, int stocks){
        
    }

}