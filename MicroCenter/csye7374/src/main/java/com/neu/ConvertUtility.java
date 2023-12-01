package com.neu;

public class ConvertUtility {

	public static int StringToInt(String s) {
        int num = 0;

        try {
            num = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            System.err.println("Error! No numbers in  "+s+" String");
            e.printStackTrace();
        }
        return num;
    }

    public static double StringToDouble(String s) {
        double num = 0;

        try {
            num = Double.parseDouble(s);
        } catch (NumberFormatException e) {
            System.err.println("Error! No doubles in  "+s+" String");
            e.printStackTrace();
        }
        return num;
    }
    
}
