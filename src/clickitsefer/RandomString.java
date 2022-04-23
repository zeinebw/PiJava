/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clickitsefer;

import java.nio.charset.Charset;
import java.util.Random;

/**
 *
 * @author hp
 */
public class RandomString {
    public static String getAlphaNumericString(int n)
    {
  
        // length is bounded by 256 Character
        byte[] array = new byte[256];
        new Random().nextBytes(array);
  
        String randomString
            = new String(array, Charset.forName("UTF-8"));
  
        // Create a StringBuffer to store the result
        StringBuffer r = new StringBuffer();
  
        // remove all spacial char
        String  AlphaNumericString
            = randomString
                  .replaceAll("[^A-Za-z0-9]", "");
  
        // Append first 20 alphanumeric characters
        // from the generated random String into the result
        for (int k = 0; k < AlphaNumericString.length(); k++) {
  
            if (Character.isLetter(AlphaNumericString.charAt(k))
                    && (n > 0)
                || Character.isDigit(AlphaNumericString.charAt(k))
                       && (n > 0)) {
  
                r.append(AlphaNumericString.charAt(k));
                n--;
            }
        }
  
        // return the resultant string
        return r.toString();
    }
}
