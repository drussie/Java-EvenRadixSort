/*******************************************************
 * Purpose/description: A method implementing Radix sort that only accepts even arrays
 * Author's Panther ID: 2685885
 * Certification:
 * I hereby certify that this work is my own and none of it is the work of
 * any other person
 */

import java.util.ArrayList;
import java.util.Scanner;

public class EvenRadixSort {

    public static void radixsort(int[] arr) {
        //Creates and initializes array buckets of size arr.length + 1
        ArrayList<Integer>[] buckets = new ArrayList[arr.length + 1];
// initializes every item of buckets to the new arraylist
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<Integer>();
        }
// Initializing variables
        boolean flag = false;
        int temp = -1;
        int divisor = 1;
// While loop iterates until flag is true
        while(!flag) {
            flag = true;
//sorts each individual digit
            for (int i = 0; i < arr.length; i++) {
                temp = arr[i] / divisor; //retrieves each digit of ith array element

                if (temp % 2 != 0) { //checks for even number
                    System.out.println("*** Abort *** the input has at least one key with odd digits");
                    System.exit(0);
                }
// inserts number into buckets
                buckets[temp % 10].add(arr[i]);
// checks divisor increment for next digit
                if (flag && temp > 0) {
                    flag = false;
                }
            }
// Stores the bucket elements in an array
            int a = 0;
            for (int k = 0; k < buckets.length; k = k + 2) {
                for (Integer i : buckets[k]) {
                    arr[a++] = i;
                }

                buckets[k].clear(); // removes elements from the bucket
            }

            divisor *= 10; // moves to the next digit
        }
    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        System.out.println("Enter number of items to sort:");
        int numItems  = scnr.nextInt();

        int [] array = new int [numItems];

        System.out.println("Enter elements into array:");

        for (int i = 0; i < numItems; i++ ) {
            array[i] = scnr.nextInt();
        }

        radixsort(array);

        System.out.println("Items sorted:\t ");
        for (int i = 0; i < numItems; i++) {
            System.out.println(array[i] + " ");
        }
    }
}
