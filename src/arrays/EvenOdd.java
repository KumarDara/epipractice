package arrays;

import java.util.Arrays;

public class EvenOdd {
    public static void evnOdd(int[] input) {
        int even = 0, odd = input.length - 1;
        while (even < odd) {
            if(input[even] % 2 == 0) {
                even++;
            } else {
                int tmp = input[even];
                input[even] = input[odd];
                input[odd--] = tmp;
            }
        }

    }

    public static void main(String[] args) {
        int[] input = new int[] {1,5,2,4,7,6,9};
        evnOdd(input);
        System.out.println(Arrays.toString(input));
    }
}
