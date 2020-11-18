package primitivetypes;

public class CountBits {
    public static void main(String[] args) {
        System.out.println("noOfBits:"+getCountUsingCacheTable(145892345));
        System.out.println(2 ^3);
    }
    public static short getBitsCount(int number) {
        short noOfBits = 0;
        while(number > 0) {
            noOfBits += number & 1;
            number >>= 1;
        }
        return noOfBits;
    }

    public static short getBitsCountBrainKerringam(int number) {
        short noOfBits = 0;
        while(number > 0) {
            noOfBits++;
            number &= (number - 1);
        }
        return noOfBits;
    }

    public static short getCountUsingCacheTable(int number) {
        short noOfBits = 0;
        short[] cache = prepareLookupTable();
        //getting the last 8 bits of the number
        //reducing the number by 8 bits
        return (short) (cache[number & 0xff] + cache[(number >> 8) & 0xff] + cache[(number >> 16) & 0xff] + cache[(number >> 24) & 0xff]);
    }

    public static short[] prepareLookupTable() {
        short[] cache = new short[256];
        for(short i=0; i<255; i++) {
            cache[i] = (short) ((i & 1) + cache[i>>1]);
        }

        return cache;
    }
}
