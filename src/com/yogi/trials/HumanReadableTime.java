`package com.yogi.trials;

public class HumanReadableTime {

    private static String[] redableHourNames = {"Midnight", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Noon"};

    public static void main(String[] args) {

        // System.out.println(String.format("input time is HR %s, Minutes %s",args[0] , args[1] ));
        int maxHourTotest = 13; // max value 24 although application handles exceptions
        int maxMinsTotest = 00; // max value 60 although application handles exceptions
        boolean checkFullRanges = true;

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

        if (inputHour >= 24 || inputMin >= 60) throw new RuntimeException("Incorrect hour or minute entered");

        String minStr = "";
        if (inputMin == 0) {
            minStr = getReadableHour(inputHour) + " O' Clock";
        } else if (inputMin == 30) {
            minStr = "Half Past " + getReadableHour(inputHour);
        } else if (inputMin > 0 && inputMin < 30) {
            minStr = " " + ((inputMin == 15) ? "Quarter " : inputMin + " minute/s ") + "  past " + getReadableHour(inputHour);
        } else {
            minStr = " " + ((60 - inputMin) == 15 ? "Quarter " : (60 - inputMin) + " minute/s ") + "  to " + getReadableHour((inputHour + 1));
        }

        return minStr;
    }

    private static String getReadableHour(int inputHour) {
        return "" + redableHourNames[(inputHour > 12 ? inputHour % 12 : inputHour)];

    }
}
`