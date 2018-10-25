package com.example.aldino.kriptografi.PerSubs;

import java.util.Scanner;

public class PerSubs {
    private static Scanner in;



    public static String encrypt2(String plaintext, int shift) {
        char[][] rail = new char[shift][plaintext.length()];
        //matrix
        for (int i = 0; i < shift; i++) {
            for (int j = 0; j < plaintext.length(); j++) {
                rail[i][j] = ' ';
            }
        } //for

        // untuk testing
        /*for (int i = 0; i < key; i++) {
                for (int j = 0; j < message.length(); j++) {
                    System.out.println(rail[i][j]);
                }
                System.out.println();
            }*/
        //membuat huruf di matrix zig zag
        int row = 0;
        int check = 0;

        for (int i = 0; i < plaintext.length(); i++) {
            if (check == 0) {
                rail[row][i] = plaintext.charAt(i);
                row++;
                if (row == shift) {
                    check = 1;
                    row--;
                }
            } else if (check == 1) {
                row--;
                rail[row][i] = plaintext.charAt(i);
                if (row == 0) {
                    check = 0;
                    row = 1;
                }
            } //if-else
        }//for

        //yang ini
        String teksEnkripsi = "";
        for (int i = 0; i < rail.length; i++) {
            for (int j = 0; j < rail[i].length; j++) {
                teksEnkripsi += rail[i][j];
                System.out.print(rail[i][j]);
            }
            System.out.println();
        }
        teksEnkripsi = teksEnkripsi.replaceAll("\\.", "");
        System.out.println("Hasil Enkripsi : " + teksEnkripsi);

//        ------------ Substitusi --------------

        if (shift > 26) {
            shift = shift % 26;
        } else if (shift < 0) {
            shift = (shift % 26) + 26;
        }


        String chipertext = "";
//        chipertext = teksEnkripsi;
        int length = teksEnkripsi.length();
        for (int i = 0; i < length; i++) {
            char ch = teksEnkripsi.charAt(i);
            if (Character.isLetter(ch)) {
                if (Character.isLowerCase(ch)) {
                    char c = (char) (ch + shift);
                    if (c > 'z') {
                        chipertext += (char) (ch - (26 - shift));
                    } else {
                        chipertext += c;
                    }
                }
                if (Character.isUpperCase(ch)) {
                    char c = (char) (ch + shift);
                    if (c > 'Z') {
                        chipertext += (char) (ch - (26 - shift));
                    } else {
                        chipertext += c;
                    }
                }
            } else {
                chipertext += ch;
            }
        }
        System.out.println("Hasil Enkripsi akhir: " + chipertext);

        return chipertext;
    }

    public static String decrypt2(String plaintext, int shift) {
//        ---------- Substitusi -------------
        if (shift > 26) {
            shift = shift % 26;
        } else if (shift < 0) {
            shift = (shift % 26) + 26;
        }

        String chipertext = "";
        int length = plaintext.length();
        for (int i = 0; i < length; i++) {
            char ch = plaintext.charAt(i);
            if (Character.isLetter(ch)) {
                if (Character.isLowerCase(ch)) {
                    char c = (char) (ch - shift);
                    if (c < 'a') {
                        chipertext += (char) (ch + (26 - shift));
                    } else {
                        chipertext += c;
                    }
                }
                if (Character.isUpperCase(ch)) {
                    char c = (char) (ch - shift);
                    if (c < 'A') {
                        chipertext += (char) (ch + (26 - shift));
                    } else {
                        chipertext += c;
                    }
                }
            } else {
                chipertext += ch;
            }
        }
        System.out.println("Deskripsi Substitusi = " + chipertext);


//        ------------- Permutasi --------------------


        char[][] rail = new char[shift][chipertext.length()];
        for (int i = 0; i < shift; i++) {
            for (int j = 0; j < chipertext.length(); j++) {
                rail [i][j] = '_';
            }
        }
        // untuk testing
//            System.out.println("TEST");
        int pointer = 0;
        for (int j = 0; j < rail.length; j++) {
            for (int k = 0; k < chipertext.length()/2; k++) {
                if (pointer<chipertext.length()) {
                    rail[j][k] = chipertext.charAt(pointer++);
                }
                System.out.print(rail[j][k]);
            }
            System.out.println();
        }
        System.out.println("\n");

        //membuat huruf di matrix zig zag
        int row = 0;
        int check = 0;


        String teksDekripsi = "";
//            check = 0;
//            row = 0;
        //converting rails back into a single line message


        for (int i = 0; i < chipertext.length(); i++) {
            for (int j = 0; j < rail.length; j++) {
                if (rail[j][i]!='_') {
                    teksDekripsi+=rail[j][i];
                }
            }
        }

        System.out.println("Deskripsi Permutasi = " + teksDekripsi);

        return teksDekripsi;
    }

    public static String key(String password, String npassword) {
        String pass = "";
        String npass = "";
        int length = password.length();
        int length2 = npassword.length();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                char ps = password.charAt(i);
                char nps = npassword.charAt(j);
                if (ps == nps) {
                    pass += ps;
                } else {
                    pass = null;
                }
            }
        }
        return pass;
    }
}
