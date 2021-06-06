package com.bms.utils;

import java.util.Scanner;

public class ConsoleUtil {

    Scanner scanner = new Scanner(System.in);

    public ConsoleUtil() {
    }

    public void println(String s){
        System.out.println(s);
    }

    public void print(String s){
        System.out.print(s);
    }

    public int nextInt() {
        return scanner.nextInt();
    }
}
