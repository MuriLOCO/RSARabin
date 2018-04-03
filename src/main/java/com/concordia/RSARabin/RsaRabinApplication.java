package com.concordia.RSARabin;

import java.math.BigInteger;
import java.util.function.Predicate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.concordia.RSARabin.utils.GeneralUtils;

@SpringBootApplication
public class RsaRabinApplication {


  public static void main(String[] args) throws Exception {
		SpringApplication.run(RsaRabinApplication.class, args);

    //Phase 1
    int primeLengh = Integer.parseInt(GeneralUtils.getUserResponse("What lengh of p and q do you want?: "));
    Predicate<BigInteger> isPrimePredicate = bigInteger -> bigInteger.isProbablePrime(1);
    BigInteger p = RSAUtils.generateRandomNumberWithCondition(primeLengh, isPrimePredicate);
    BigInteger q=RSAUtils.generateRandomNumberWithCondition(primeLengh,isPrimePredicate);
    System.out.println("p is: " + p);
    System.out.println("q is: " + q);

    //Phase 2
    BigInteger phiN = RSAUtils.calculatePhiN(p, q);
    System.out.println("Φ(n) is: " + phiN);

    int phiNLengh = Integer.parseInt(GeneralUtils.getUserResponse("What lengh of e do you want?: "));
    Predicate<BigInteger>validEPredicate=bigInteger->bigInteger.compareTo(new BigInteger("1"))==1&&e.compareTo(phiN)==-1&&bigInteger.gcd(phiN)==1));
    BigInteger e = RSAUtils.generateRandomNumberWithCondition(phiNLengh, validEPredicate);
    System.out.println("e is: " + e);


    BigInteger message = new BigInteger(GeneralUtils.getUserResponse("Please select a message: "));

    BigInteger n = RSAUtils.computeN(p, q);
    BigInteger cipherMessage = RSAUtils.encrypt(message, n, e);


    System.out.println("The message is: " + message);
    System.out.println("The cipher message is: " + cipherMessage);
    

	}
}
