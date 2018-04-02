package com.concordia.RSARabin;

import java.math.BigInteger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.concordia.RSARabin.RSA.RSAUtils;
import com.concordia.RSARabin.utils.GeneralUtils;

@SpringBootApplication
public class RsaRabinApplication {


  public static void main(String[] args) throws Exception {
		SpringApplication.run(RsaRabinApplication.class, args);

    BigInteger p = new BigInteger(GeneralUtils.getUserResponse("Please insert a prime p: "));
    if (!p.isProbablePrime(1))
      throw new Exception("p is not prime!");

    BigInteger q = new BigInteger(GeneralUtils.getUserResponse("Please insert a prime q: "));
    if (!q.isProbablePrime(1))
      throw new Exception("q is not prime!");

    BigInteger phiN = RSAUtils.calculatePhiN(p, q);
    System.out.println("Φ(n) is: " + phiN);

    BigInteger e = new BigInteger(GeneralUtils.getUserResponse("Please select a random integer 1 < e < Φ(n): "));
    RSAUtils.isEValid(e, phiN);
    BigInteger gcd = e.gcd(phiN);
    System.out.println("GCD between e and Φ(n) is: " + gcd);
    if (!gcd.equals(new BigInteger("1")))
      throw new Exception("GCD between e and Φ(n) must be 1");

    BigInteger message = new BigInteger(GeneralUtils.getUserResponse("Please select a message: "));

    BigInteger n = RSAUtils.computeN(p, q);
    BigInteger cipherMessage = RSAUtils.encrypt(message, n, e);

    System.out.println("p is: " + p);
    System.out.println("q is: " + q);
    System.out.println("The message is: " + message);
    System.out.println("The cipher message is: " + cipherMessage);
    

	}
}
