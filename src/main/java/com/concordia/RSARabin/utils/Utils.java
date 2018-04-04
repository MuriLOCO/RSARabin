package com.concordia.RSARabin.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Random;
import java.util.function.Predicate;

public class Utils {
	
  /**
  * Gets the user response according with the message input
  * @param systemMessage - Message chose to show as System Message
  * @return Response of user in String format
  */
  public static String getUserResponse(String systemMessage) {
	 try {
		 System.out.print(systemMessage);
	     InputStreamReader streamReadeText = new InputStreamReader(System.in);
	     BufferedReader bufferedReaderText = new BufferedReader(streamReadeText);
	     return bufferedReaderText.readLine();
	 } catch (IOException e) {
	     throw new RuntimeException();
	  }
	}
  /**
   * Method to compute the N
   * @param p - Prime number p
   * @param q - Prime number q
   * @return - Computation between the two primes
   */
  public static BigInteger computeN(BigInteger p, BigInteger q) {
    return p.multiply(q);
  }

  /**
   * Method to encrypt using RSA
   * @param message - Message
   * @param n - Computation of p and q
   * @param e - Random integer 1 < e < Φ(n)
   * @return Encrypted message with RSA
   */
  public static BigInteger encrypt(BigInteger message, BigInteger n, BigInteger e) {
    return message.modPow(e, n);
  }

  /**
   * Calculates the Φ(n)
   * @param p - p prime number
   * @param q - q prime number
   * @return (p-1)*(q-1)
   */
  public static BigInteger calculatePhiN(BigInteger p, BigInteger q) {
    return p.subtract(new BigInteger("1")).multiply(q.subtract(new BigInteger("1")));
  }

  public static BigInteger generateRandomNumberWithCondition(int lengh, Predicate<BigInteger> predicate) {
    Random rand = new Random();
    BigInteger randomNumber = new BigInteger(lengh, rand);
    return predicate.test(randomNumber) ? randomNumber : generateRandomNumberWithCondition(lengh, predicate);
  }
  
  public static String transformToUnicode(String text) {
	  StringBuffer buffer = new StringBuffer();  
	  for (int i = 0; i < text.length(); i++) {	       
	        buffer.append((int) text.charAt(i));
	    }
	  return buffer.toString();
  }
 }
