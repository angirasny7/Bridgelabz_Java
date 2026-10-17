package javaProgrammingElement.Level1;

public class AverageMarks {
    public static void main(String[] args){
        //Store marks for each subject
        int mathsMarks = 94;
        int physicsMarks = 95;
        int chemistryMarks = 96;

        //Calculate Average Percentage
        float avgPercent = ((mathsMarks + physicsMarks + chemistryMarks)/300.0f) * 100;

        //Print Average Percentage
        System.out.println("Sam's average mark in PCM is " + avgPercent + "%");
    }
}

