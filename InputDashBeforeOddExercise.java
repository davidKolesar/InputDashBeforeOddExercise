import java.util.*;

public class Solution {

    public static String dashatize(int num) {
        
        StringBuffer buffer = new StringBuffer();
        int currentIndex = 0;
        boolean isPreviousDash = false;

        //evaluate if 0
        if (num == 0)
        {
            return "0";
        }

        /* This converts negative numbers to positive ones. The conversion to long
         * is performed because Integer.MIN_VALUE is -2147483648 but, when using signed integers, 
         * the complement binary representations of +2147483648 and -2147483648 are identical. Ergo,
         * one has to convert to long in order to possess enough bits (64 bits)*/
        Long positiveNumber = new Long(num);
        positiveNumber = Math.abs(positiveNumber);

        //split num into individual digits
        char[] splittableNumber = String.valueOf(positiveNumber).toCharArray();

        if (splittableNumber[0] == '-')
        {
            currentIndex++;
        }

        //convert char[] to int && add to list
        for (char c : splittableNumber)
        {
            currentIndex++;
            int charValue = Integer.parseInt(String.valueOf(c));

            //determine if odd
            if (charValue % 2 != 0)
            {
                //if odd, determine if it is the first character in array
                if (currentIndex != 1)
                {
                    //if not, determine if previous character is dash                    
                    if (!isPreviousDash)
                    {
                        buffer.append("-");
                    }
                }
                //write value 
                buffer.append(charValue);

                //if odd, determine if it is the last character in array
                if (currentIndex != splittableNumber.length)
                {
                    buffer.append("-");
                    isPreviousDash = true;
                }
            }
            //otherwise, write the number
            else
            {
                buffer.append(charValue);
                isPreviousDash = false;
            }
        }
        return buffer.toString();
    }
}