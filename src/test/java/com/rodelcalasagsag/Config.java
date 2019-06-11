package com.rodelcalasagsag;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class Config {
  private static final JSONObject config = getConfigJSON();
  public static final String BROWSER_NAME = (String) config.get("browserName");
  public static final String HUB_URL = (String) config.get("hubURL");
  public static final String USERNAME = (String) config.get("username");
  public static final String PASSWORD = (String) config.get("password");
  public static final long DEFAULT_EXPLICIT_WAIT_TIME =
      Long.parseLong((String) config.get("defaultExplicitWait"));

  private static JSONObject getConfigJSON() {
    JSONParser parser = new JSONParser();
    String configPath =
        System.getProperty("user.dir") + "/src/test/resources/com/rodelcalasagsag/config.json";

    try {
      return (JSONObject) parser.parse(new FileReader(configPath));
    } catch (IOException | ParseException e) {
      throw new Error(e);
    }
  }
}
