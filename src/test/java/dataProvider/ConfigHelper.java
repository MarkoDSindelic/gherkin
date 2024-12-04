package dataProvider;

import managers.FileReaderManager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigHelper {


   public ConfigHelper(){

   }

   public static String get(String pageName) {
       return FileReaderManager.getInstance().getConfigFileReader().getApplicationURL().concat(pageName);

   }
}
