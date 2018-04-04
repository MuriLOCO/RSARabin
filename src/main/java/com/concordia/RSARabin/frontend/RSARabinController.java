package com.concordia.RSARabin.frontend;

import java.math.BigInteger;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Predicate;

import com.concordia.RSARabin.utils.Utils;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class RSARabinController implements Initializable {

  private static final BigInteger BIG_INTEGER_ONE = new BigInteger("1");
	
  @FXML
  private ImageView btnMenuExit, btnMenuEncrypt, btnMenuDecrypt;

  @FXML
  private AnchorPane hSettings, hEncrypt, hDecrypt;

  @FXML
  private Button btnClear, btnDecryption, btnEncryption;

  @FXML
  private TextField tfKPqLengh, tfELengh, tfKeyDecrypt;

  @FXML
  private TextArea taPlainTextEncrypt, taPlainTextDecrypt, taCipherTextEncrypt, taCipherTextDecrypt;

  @FXML
  private ComboBox<String> cbDecryptionMethod;
  
  @FXML
  private void handleButtonAction(MouseEvent event) throws Exception {
    if (event.getTarget() == btnMenuExit) {
      System.exit(0);

    } else if (event.getTarget() == btnMenuEncrypt) {
      hSettings.setVisible(true);
      hEncrypt.setVisible(true);
      hDecrypt.setVisible(false);
      cbDecryptionMethod.setVisible(false);

    } else if (event.getTarget() == btnMenuDecrypt) {
      hSettings.setVisible(true);
      hEncrypt.setVisible(false);
      hDecrypt.setVisible(true);
      cbDecryptionMethod.setVisible(true);

    } else if (event.getTarget() == btnClear || event.getTarget().toString().contains("Clear")) {
      /*taPlainTextEncrypt.setText("");
      taPlainTextDecrypt.setText("");     
      tfKeyDecrypt.setText("");
      taCipherTextEncrypt.setText("");
      taCipherTextDecrypt.setText("");
      tfKPqLengh.setText("");
      tfeLengh.setText("");*/

    } else if (event.getTarget() == btnEncryption || event.getTarget().toString().contains("Encrypt")) {
    	//Phase 1
        int primeLengh = Integer.parseInt(tfKPqLengh.getText());
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
        taCipherTextEncrypt.setText(cipherMessage.toString());
        
    } else if (event.getTarget() == btnDecryption || event.getTarget().toString().contains("Decrypt")) {
     
    }
  }

  @Override
  public void initialize(URL url, ResourceBundle rb) {

  }

}
