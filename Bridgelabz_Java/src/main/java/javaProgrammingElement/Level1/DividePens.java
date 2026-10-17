package javaProgrammingElement.Level1;

public class DividePens {
    public static void main(String[] args){
        //Store the number of pens and students
        int totalPens = 14;
        int totalStudents = 3;

        //Calculate pens per student
        int pensPerStudent = totalPens/totalStudents;

        //Calculate the remaining pens
        int remainingPens = totalPens % totalStudents;

        //Display the result
        System.out.println("The Pen Per Student is " + pensPerStudent +
                " and the remaining pen not distributed is " + remainingPens);

    }
}

