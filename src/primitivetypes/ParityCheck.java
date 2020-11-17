package primitivetypes;

public class ParityCheck {
    public static void main(String[] args) {
        System.out.println("parity:"+getParityCacheTable(145892325));
    }
    public static short getParityNavie(int number) {
        short noOfBits = 0;
        while(number > 0) {
            noOfBits ^= number & 1;
            number >>= 1;
        }
        return noOfBits;
    }

    public static short getParityBrainKerringam(int number) {
        short noOfBits = 0;
        while(number != 0) {
            noOfBits ^= 1;
            number &= (number - 1);
        }
        return noOfBits;
    }

    public static short getParityCacheTable(int number) {
        short[] cache = prepareLookupTable();
        //getting the last 8 bits of the number
        //reducing the number by 8 bits
        return (short) (cache[number & 0xff] ^ cache[(number >> 8) & 0xff] ^ cache[(number >> 16) & 0xff] ^ cache[(number >> 24) & 0xff]);
    }

    public static short[] prepareLookupTable() {
        short[] cache = new short[256];
        for(short i=0; i<255; i++) {
            cache[i] = (short) ((i & 1) ^ cache[i>>1]);
        }

        return cache;
    }
}
