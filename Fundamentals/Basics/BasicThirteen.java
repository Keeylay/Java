import java.util.Arrays;
import java.util.ArrayList;

public class BasicThirteen {
    public static void main(String[] args) {
        // printNumbers();
        // printEvens();
        // printSum();
        int[] arr = {1,2,3,4,5,6};
        printArray(arr);
        printMax(arr);
        printAverage(arr);
    }

    public static void printNumbers() {

        for (int i = 1; i <= 255; i++){ 
            System.out.println(i);
        }
    }
    public static void printEvens() {

        for (int i = 1; i <= 255; i +=2){ 
            System.out.println(i);
        }
    }
    public static void printSum() {
        int sum = 0;
        for (int i = 1; i <= 255; i++){ 
            sum += i;
        }
        System.out.println(sum);
    }
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++){ 
            System.out.println(arr[i]);
        }
    }
    public static int printMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++){ 
            if(max < arr[i]){
                max = arr[i];
            }
        }
        return max;
    }
    public static void printAverage(int[] average) {
        int sum = 0;
        int avg;
        for (int i = 1; i <= average.length-1; i++){ 
            sum += average[i];
        }
        avg = sum/average.length;
        System.out.println(avg);
    }
}
