public class Solution {
    // you need treat n as an unsigned value
    // TODO
    public static int reverseBits(int n) {
        return Integer.reverse(n);
    }

    public static void main(String[] args) {
        System.out.println(reverseBits(0b00000010100101000001111010011100));
    }
}