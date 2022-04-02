package com.company;
import java.math.BigInteger;
import java.util.Scanner;

public class Knapsack {
    static BigInteger one = new BigInteger("1");

    public Knapsack() {
    }



    public static int secretKey(int[] var0, int var1) {
        Scanner var2 = new Scanner(System.in);
        boolean var3 = false;
        int var4 = 0;

        for(int var5 = 0; var5 < var1; ++var5) {
            var3 = false;

            do {
                System.out.print("Enter super-increasing value a(" + var5 + "): ");
                var0[var5] = var2.nextInt();
                if (var0[var5] > var4) {
                    var3 = true;
                    var4 += var0[var5];
                } else {
                    System.out.println("Value is not super-increasing. Please try again!");
                }
            } while(!var3);
        }

        return var4;
    }

    public static BigInteger multiplier(BigInteger var0) {
        Scanner var1 = new Scanner(System.in);
        boolean var2 = false;
        BigInteger var3 = one;

        do {
            System.out.print("\nEnter multiplier(w) value: ");
            int var4 = var1.nextInt();
            var3 = BigInteger.valueOf((long)var4);
            BigInteger var5 = var0.gcd(var3);
            if (var5.equals(one)) {
                var2 = true;
            } else {
                System.out.println("GCD of m and w is not 1. Please try again!");
            }
        } while(!var2);

        return var3;
    }

    public static BigInteger modulus(int var0) {
        Scanner var1 = new Scanner(System.in);
        int var2 = 0;

        while(var2 < var0) {
            System.out.print("\nEnter modulus(m) value: ");
            var2 = var1.nextInt();
            if (var2 < var0) {
                System.out.println("Value is not larger than sum of knapsack. Please try again!");
            }
        }

        BigInteger var3 = BigInteger.valueOf((long)var2);
        return var3;
    }

    public static void publicKey(int[] var0, int[] var1, int var2, BigInteger var3, BigInteger var4) {
        System.out.print("\nPublic key: ");

        for(int var5 = 0; var5 < var2; ++var5) {
            BigInteger var6 = BigInteger.valueOf((long)var0[var5]);
            BigInteger var7 = var3.multiply(var6).mod(var4);
            var1[var5] = var7.intValue();
            if (var5 == var2 - 1) {
                System.out.println(var1[var5]);
            } else {
                System.out.print(var1[var5] + ", ");
            }
        }

    }

    public static int char_bitLength(int var0) {
        int var1 = 0;
        if (var0 % 10 != 0 && var0 < 10) {
            for(boolean var2 = false; var1 < 10; var1 += var0) {
            }
        } else {
            var1 = var0;
        }

        System.out.println("char_bit_length: " + var1);
        return var1;
    }

    public static void char_padding(char[] var0, int var1, String[] var2) {
        for(int var3 = 0; var3 < var0.length; ++var3) {
            String var4 = Integer.toBinaryString(var0[var3]);
            int var5;
            if (var4.length() != 7) {
                var5 = 7 - var4.length();

                for(int var6 = 0; var6 < var5; ++var6) {
                    var4 = "0" + var4;
                }
            }

            for(var5 = 0; var5 < var1 - 10; ++var5) {
                var4 = var4 + "0";
            }

            var4 = var4 + "111";
            var2[var3] = var4;
        }

    }

    public static void encryption(int[][] var0, String[] var1, int var2, int var3, int[] var4) {
        for(int var5 = 0; var5 < var1.length; ++var5) {
            int var6 = Integer.parseInt(var1[var5], 2);
            int var7 = 0;

            for(int var8 = 0; var8 < var3 / var2; ++var8) {
                for(int var9 = 0; var9 < var2; ++var9) {
                    if (var1[var5].charAt(var7) == '1') {
                        var0[var5][var8] += var4[var9];
                    }

                    ++var7;
                }
            }
        }

    }

    public static void decryption(BigInteger var0, BigInteger var1, int var2, int[] var3, int[] var4, String[] var5, int var6) {
        BigInteger var7 = var1.modInverse(var0);
        String var8 = "";
        String var9 = "";
        int var10 = 0;
        int var11 = 0;

        for(int var12 = 0; var12 < var3.length; var12 += var6 / var2) {
            var8 = "";

            for(int var13 = 0; var13 < var6 / var2; ++var13) {
                var9 = "";
                BigInteger var14 = BigInteger.valueOf((long)var3[var11]);
                BigInteger var15 = var14.multiply(var7);
                var15 = var15.mod(var0);
                int var16 = var15.intValue();
                int var17 = var2 - 1;

                for(int var18 = 0; var18 < var2; ++var18) {
                    if (var16 >= var4[var17]) {
                        var9 = "1" + var9;
                        var16 -= var4[var17];
                    } else {
                        var9 = "0" + var9;
                    }

                    --var17;
                }

                ++var11;
                var8 = var8 + var9;
            }

            var5[var10] = var8;
            ++var10;
        }

    }

    public static void reverse_char_padding(char[] var0, String[] var1, int var2) {
        for(int var3 = 0; var3 < var0.length; ++var3) {
            int var5 = Integer.parseInt(var1[var3].substring(var2 - 3), 2);
            String var6 = var1[var3].substring(0, var5);
            int var7 = Integer.parseInt(var6, 2);
            var0[var3] = (char)var7;
        }

    }
}

