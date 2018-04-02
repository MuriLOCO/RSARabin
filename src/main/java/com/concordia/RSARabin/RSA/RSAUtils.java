package com.concordia.RSARabin.RSA;

import java.math.BigInteger;

public class RSAUtils {

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

  /**
   * Checks if e is a valid number
   * @param e - Chosen e
   * @param phiN - Φ(n)
   * @return true if valid, false if not valid
   * @throws Exception
   */
  public static boolean isEValid(BigInteger e, BigInteger phiN) throws Exception {
    int resultCompareOne = e.compareTo(new BigInteger("1"));
    int resultComparePhiN = e.compareTo(phiN);
    return resultCompareOne == 1 && resultComparePhiN == -1;
  }
}
