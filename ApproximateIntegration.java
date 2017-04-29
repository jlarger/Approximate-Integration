/**
 * Created by jameslarger on 10/25/16.
 */
import java.util.Scanner;
import java.lang.Math;

public class ApproximateIntegration
{
    public static void main (String args[])
    {


        /*

            Getting upper / lower bounds and number of rectangles

         */

        System.out.println("Enter your lower bound limit for integration: ");
        Scanner lower = new Scanner(System.in);

        System.out.println("Enter your upper bound limit for integration: ");
        Scanner upper = new Scanner(System.in);

        System.out.println("Enter the number of rectangles you'd like to use: ");
        Scanner rectangles = new Scanner(System.in);


        int userLower = lower.nextInt();
        int userUpper = upper.nextInt();
        int nRectangles = rectangles.nextInt();


        /*
            Establishing arrays that will hold our data with an extra space to accomadate counter
         */
        double rectangleArray[] = new double[nRectangles + 1];

        double midpointArray[] = new double[nRectangles + 2];

        double finalArray[] = new double[nRectangles + 2];



        getRekt(userLower, userUpper, nRectangles, rectangleArray);

        getInBetween(rectangleArray, midpointArray);

        getApproxOfRekt(midpointArray, finalArray);



    }



    public static double[] getRekt(int lower, int upper, int n , double arr[])
    {

        /*

        This method gets the class sizes. We want to get the correct amount of rectangles from the user
        so that we know how many we're dealing with.

        This method takes in the lower and upper bounds plus the amount of rectanges, sets
        x initially to lower bound, makes it stay less than upper bound, because we want to find
        an array of numbers that corresponds with the number of rectangles between the bounds.

        We then take the rectangles that are found and store them in an array to use in other methods.

        */

        int i;
        int x;
        for(i = 0; i < n; i++)
        {
            for (x = lower; x < upper; x++)
            {
                arr[i] = ((x)/(n));
                System.out.println("Rekt: " + arr[i]);
            }
        }

        return arr;
    }

    public static double[] getInBetween(double arr[], double newArr[])
    {

        /*

            In this method, we are getting the numbers that are in between the sizes we found in the
            above method, so that we use these numbers in the actual calculation.

         */
        int i;
        for(i = 0; i < 2; i++)
        {
            newArr[i] = ((arr[i] + arr[i + 1]) / (2));
        }
        return newArr;
    }

    public static double[] getApproxOfRekt(double arr[], double finalArr[])
    {
        /*

            This method is actually plugging the values from getInBetween() method into the
            original function.

         */

        int i;


        for(i = 0; i < arr.length; i++)
        {
           finalArr[i] = (Math.exp(arr[i])); // Math.exp is the same as e^x
           System.out.println(finalArr[i]);
        }

        int sum = 0;

        for(double n : finalArr)
        {
            sum += n;
        }

        System.out.println(sum);
        return finalArr;

    }


}
