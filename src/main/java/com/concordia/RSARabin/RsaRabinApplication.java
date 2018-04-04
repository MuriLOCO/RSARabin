package com.concordia.RSARabin;

import java.math.BigInteger;
import java.util.function.Predicate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.concordia.RSARabin.utils.Utils;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

@SpringBootApplication
public class RsaRabinApplication extends Application{

  private static final BigInteger BIG_INTEGER_ONE = new BigInteger("1");

  private double xOffset = 0;
  private double yOffset = 0;
  
  public static void main(String[] args) throws Exception {
		SpringApplication.run(RsaRabinApplication.class, args);
		launch(args);
    /*//Phase 1
    int primeLengh = Integer.parseInt(Utils.getUserResponse("What lengh of p and q do you want?: "));
    Predicate<BigInteger> primePredicate = number -> number.isProbablePrime(1);
    BigInteger p = Utils.generateRandomNumberWithCondition(primeLengh, primePredicate);
    BigInteger q = Utils.generateRandomNumberWithCondition(primeLengh,primePredicate);
    System.out.println("p is: " + p);
    System.out.println("q is: " + q);

    //Phase 2
    BigInteger n = Utils.computeN(p, q);
    System.out.println("n is: " + n);
    BigInteger phiN = Utils.calculatePhiN(p, q);
    System.out.println("Φ(n) is: " + phiN);   
    
    //Phase 3
    int phiNLengh = Integer.parseInt(Utils.getUserResponse("What lengh of e do you want?: "));
    Predicate<BigInteger> ePredicate = number -> number.compareTo(BIG_INTEGER_ONE) == 1 && number.compareTo(phiN) == -1 && number.gcd(phiN).equals(BIG_INTEGER_ONE);   
    BigInteger e = Utils.generateRandomNumberWithCondition(phiNLengh, ePredicate);
    System.out.println("e is: " + e);

    //Phase 4
    String message = Utils.getUserResponse("Please select a message: ");
    String unicodeMessage = Utils.transformToUnicode(message);
    BigInteger numericMessage = new BigInteger(unicodeMessage);    
    BigInteger cipherMessage = Utils.encrypt(numericMessage, n, e);

    System.out.println("The message is: " + message);
    System.out.println("The cipher message is: " + cipherMessage);    */

	}

@Override
public void start(final Stage stage) throws Exception {
  final Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("main.fxml"));
    
    stage.initStyle(StageStyle.TRANSPARENT);
    stage.setTitle("Substitution Cipher");
    root.setOnMousePressed(new EventHandler<MouseEvent>(){
    @Override
    public void handle(final MouseEvent event) {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        }
     });
     root.setOnMouseDragged(new EventHandler<MouseEvent>(){
    @Override
    public void handle(final MouseEvent event) {
             stage.setX(event.getSceneX() - xOffset);
             stage.setY(event.getScreenY() - yOffset);
         }
     });

  final Scene scene = new Scene(root);
    scene.setFill(javafx.scene.paint.Color.TRANSPARENT);
    stage.setScene(scene);
    stage.show();
}
}
