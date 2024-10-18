package com.shosha.springboot.demo.util;

public class test {
    public static void main(String[] args) {
        Integer number1 = 5;
        Integer number2 = 6;

        String number3 = number1.toString();
        String number4 = number2.toString();

        StringBuilder number5 = new StringBuilder();
        number5.append(number3);
        StringBuilder number6 = new StringBuilder();
        number6.append(number4);


        number1 = number2;
        if (number1.equals(number2)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

        number3 = number4;
        if (number1.equals(number3)) {
            System.out.println("true");
        }else {
            System.out.println("false");

        }

        number5=number6;
        if (number5.toString().equals(number6.toString())){
            System.out.println("true");
        }else {
            System.out.println("false");
        }

    }
}