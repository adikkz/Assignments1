package homeworks;

import java.util.Arrays;
import java.util.Scanner;

public class Hw21_6 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter some integers between 1 and 100 (and 0 when done): ");
        int[] myArray = new int[1000];
        int number;
        int count = 0;
        do
        {
            number = scan.nextInt();
            myArray[count] = number;
            count++;
        }
        while (number != 0);

        int[] mySort = new int [count - 1];

        for(int i = 0; i< (count-1); i++) {
            mySort[i] = myArray[i];
        }

        Arrays.sort(mySort);
        int n = 0;

        for(int i = 0; i < mySort.length; i++) {
            int occurance = 0;
            if(n >= mySort[i]) {
                continue;
            }
            else {
                n = mySort[i];
                for (int j=0; j<mySort.length; j++)
                    if (n == mySort[j])
                        occurance++;
                System.out.print(n +  " occurs " + occurance );
                {
                    if (occurance == 1) {
                        System.out.println(" time.");
                    }
                    else {
                        System.out.println(" times.");
                    }
                }
            }
        }
    }
}
