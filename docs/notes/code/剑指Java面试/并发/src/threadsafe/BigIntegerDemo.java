package threadsafe;

import java.math.BigInteger;

public class BigIntegerDemo {
    public static void main(String[] args) {
        BigInteger x = BigInteger.valueOf(10);
        BigInteger y = BigInteger.valueOf(10);
        x = x.add(y);
        System.out.println(x);
    }
}
