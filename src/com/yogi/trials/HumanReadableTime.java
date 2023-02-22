package com.yogi.trials;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class HumanReadableTime {

    private static String[] redableHourNames = {"Midnight", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Noon"};
    private static String[] readableMinuteNames = {"zero","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten",
    "Eleven","Twelve","Thirteen","Fourteen","Fifteen", "Sixteen","Seventeen","Eighteen","Nineteen","Twenty",
            "Twenty one","Twenty two","Twenty three","Twenty four","Twenty five","Twenty six","Twenty seven","Twenty eight","Twenty nine",};
    public static void main(String[] args) {
        String inputTime = "";
        if(args != null && args.length > 0 ){
          //  Scanner scanner = new Scanner(System.in);
            inputTime = args[0];
        }else{
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
            Date date = new Date();
            inputTime = simpleDateFormat.format(date);
        }


        // System.out.println(String.format("input time is HR %s, Minutes %s",args[0] , args[1] ));
        String[] hourMinArray = inputTime.split(":");
        int maxHourTotest = Integer.parseInt(hourMinArray.length>0?hourMinArray[0]:"-1"); // max value 24 although application handles exceptions
        int maxMinsTotest = Integer.parseInt(hourMinArray.length>1?hourMinArray[1]:"0");; // max value 60 although application handles exceptions
        boolean checkFullRanges = false;

        //Full range testing start
        if (checkFullRanges) {

            for (int i = 0; i <= maxHourTotest; i++) {

                for (int j = 0; j < 60; j++) {
                    System.out.println(" Time in English :: " + appendTimeDirective(i, j));
                }
            }
            //Full range testing end
        } else {
            System.out.println(appendTimeDirective(maxHourTotest, maxMinsTotest));
        }


        //System.out.println(unformattedOutput);


    }


    private static String appendTimeDirective(int inputHour, int inputMin) {

        if (inputHour >= 24 || inputMin >= 60 || inputHour <0 || inputMin <0) throw new RuntimeException("Incorrect hour or minute entered");

        String minStr = "";
        if (inputMin == 0) {
            String redableHour =getReadableHour(inputHour);
            minStr = ("Noon".equalsIgnoreCase(redableHour)  || "Midnight".equalsIgnoreCase(redableHour) ) ? redableHour : redableHour + " O' Clock";
        } else if (inputMin == 30) {
            minStr = "Half Past " + getReadableHour(inputHour);
        } else if (inputMin > 0 && inputMin < 30) {
            minStr = " " + ((inputMin == 15) ? "Quarter " : readableMinuteNames[inputMin] ) + "  past " + getReadableHour(inputHour);
        } else {
            minStr = " " + ((60 - inputMin) == 15 ? "Quarter " : readableMinuteNames[(60 - inputMin)] ) + "  to " + getReadableHour((inputHour + 1));
        }

        return minStr;
    }

    private static String getReadableHour(int inputHour) {
        return "" + redableHourNames[(inputHour > 12 ? inputHour % 12 : inputHour)];

    }
}
