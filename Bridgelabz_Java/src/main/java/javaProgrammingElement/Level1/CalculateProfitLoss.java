package javaProgrammingElement.Level1;

public class CalculateProfitLoss {
    public static void main(String[] args){
        //Store the values of Cost Price and Selling Price

        int costPrice = 129;
        int sellingPrice = 191;

        //Calculate Profit
        int profit = sellingPrice - costPrice;

        //Calculate Profit Percentage
        float profitPercent = ((float)profit / costPrice) * 100;

        //Print the output

        System.out.println("The Cost Price is INR " + costPrice + " and Selling Price is INR " + sellingPrice +
                "\nThe Profit is INR " + profit + " and the Profit Percentage is " + profitPercent);
    }
}

