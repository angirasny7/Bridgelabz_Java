package javaProgrammingElement.Level1;

public class UniversityFee {
    public static void main(String[] args){
        //Store fee and  discountPercent
        int fee = 125000;
        int discountPercent = 10;

        //Calculate discount
        int discount = (int)(((float)10/100)*125000);

        //Calculate the fee to be paid
        int feeToBePaid = fee - discount;

        System.out.println("The discount amount is INR " + discount +
                " and the final discounted fee is INR " + feeToBePaid);
    }
}

