package arrays;

import java.util.Arrays;

public class RemoveDuplicates {
    public static void removeDuplicates(int[] input) {
        for(int i=1;i <input.length;i++) {
            if(input[i] != 0 && input[i] == input[i-1]) {
                int j=i;
                while(j < input.length-1 && input[j] != 0) {
                    input[j] = input[j+1];
                    j++;
                }
                input[input.length - 1] = 0;
                i--;
            }
        }
    }

    public static void removeDuplicatesWithoutShifting(int[] input) {
        int writeIndex = 1;
        for (int i = 1; i < input.length; ++i) {
            if (input[writeIndex - 1] != input[i]) {
                input[writeIndex++] = input[i];
            }
        }
        while(writeIndex < input.length) {
            input[writeIndex++] = 0;
        }
    }

    public static int removeProvidedNumber(int[] input, int key) {
        int writeIndex = 0;
        int noOfOcc = 0;
        for (int i = 0; i < input.length; ++i) {
            if (key != input[i]) {
                input[writeIndex++] = input[i];
            }
        }
        while(writeIndex < input.length) {
            input[writeIndex++] = 0;
            noOfOcc++;
        }
        return noOfOcc;
    }

    public static void main(String[] args) {
        int[] input = new int[] {2,3,5,5,7,11,11,11,13};//{2,2,2,2,2,2,2,2,2,2,2,3,3,3,3,3,3,3,3,3,3};//{2,3,5,5,7,11,11,11,13};
        //removeDuplicatesWithoutShifting(input);
        System.out.println(removeProvidedNumber(input, 9));
        System.out.println(Arrays.toString(input));
    }
}
