package primitivetypes;

public class ClosestInteger {
    public static long closestIntSameBitCount(long x) {
        // x is assumed to be non-negative so we know the leading bit is ©. We
        // restrict to our attention to 63 LSBs.
        for (int i = 0; i < 63 - 1; ++i) {
            if ((((x >>>i) &1) !=((x >>>(i + 1)) &1))){
                x ^= (1L << i) | (1L << (i + 1)); // Swaps bit-i and bit-(i + 1).
                return x;
            }
        }
        // Throw error if all bits of x are 0 or 1.
        throw new IllegalArgumentException("All bits are 0 or 1");
    }

    public static void main(String[] args) {
        System.out.println(closestIntSameBitCount(7));
    }
}
