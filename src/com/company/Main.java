package com.company;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] var0) {
        Scanner var1 = new Scanner(System.in);
        System.out.print("Enter size of knapsack: ");
        int var2 = var1.nextInt();
        int[] var3 = new int[var2];
        int var4 = Knapsack.secretKey(var3, var2);
        BigInteger var5 = Knapsack.modulus(var4);
        BigInteger var6 = Knapsack.multiplier(var5);
        int[] var7 = new int[var2];
        Knapsack.publicKey(var3, var7, var2, var6, var5);
        var1.nextLine();
        System.out.print("\nEnter mode of operation (Encrypt / Decrypt): ");
        String var8 = var1.nextLine();
        System.out.println();
        int var9 = Knapsack.char_bitLength(var2);
        int var16;
        int var17;
        if (var8.equalsIgnoreCase("encrypt")) {
            System.out.print("\nEnter message for encryption: ");
            String var10 = var1.nextLine();
            char[] var11 = var10.toCharArray();
            String[] var12 = new String[var11.length];
            Knapsack.char_padding(var11, var9, var12);
            int[][] var13 = new int[var11.length][var9 / var2];
            Knapsack.encryption(var13, var12, var2, var9, var7);
            System.out.print("\nCiphertext: ");

            for(int var14 = 0; var14 < var13.length; ++var14) {
                int[] var15 = var13[var14];
                var16 = var15.length;

                for(var17 = 0; var17 < var16; ++var17) {
                    int var18 = var15[var17];
                    System.out.print(var18 + " ");
                }
            }

            System.out.println();
        } else {
            boolean var21 = true;

            String[] var20;
            do {
                System.out.print("\nEnter cipher text: ");
                String var22 = var1.nextLine();
                var20 = var22.split("\\s", 0);
                if (var20.length % (var9 / var2) != 0) {
                    System.out.println("\nCiphertext does not match with knapsack size. Please try again!");
                    var21 = false;
                }
            } while(!var21);

            int[] var19 = new int[var20.length];
            System.out.println();

            for(int var23 = 0; var23 < var19.length; ++var23) {
                var19[var23] = Integer.parseInt(var20[var23]);
            }

            String[] var24 = new String[var19.length / (var9 / var2)];
            Knapsack.decryption(var5, var6, var2, var19, var3, var24, var9);
            char[] var25 = new char[var24.length];
            Knapsack.reverse_char_padding(var25, var24, var9);
            System.out.print("Plaintext: ");
            char[] var26 = var25;
            var16 = var25.length;

            for(var17 = 0; var17 < var16; ++var17) {
                char var27 = var26[var17];
                System.out.print(var27);
            }
        }

    }
}
