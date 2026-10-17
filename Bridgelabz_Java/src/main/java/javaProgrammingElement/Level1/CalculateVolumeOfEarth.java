package javaProgrammingElement.Level1;

public class CalculateVolumeOfEarth {
    public static void main(String[] args){
        //Store the value of pie and radius of the earth
        final double pi = Math.PI;
        double radius = 6378.0;

        //Calculate volume of earth in cubic Kilometers
        double volumeOfEarthInCubicKm = (4.0/3.0) * pi * radius*radius*radius;

        //Calculate the volume of the earth in cubic miles
        double kmToMiles = 0.621371;
        double volumeOfEarthInCubicMiles = volumeOfEarthInCubicKm * kmToMiles * kmToMiles * kmToMiles;

        System.out.printf("The volume of earth in cubic kilometers is %.2f " +
                " and cubic miles is %.2f%n", volumeOfEarthInCubicKm, volumeOfEarthInCubicMiles);

    }
}

