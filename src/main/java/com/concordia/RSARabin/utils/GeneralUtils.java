package com.concordia.RSARabin.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GeneralUtils {

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
}
