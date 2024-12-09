package dataProvider;

import managers.FileReaderManager;


public class ConfigHelper {


   public ConfigHelper(){

   }

   public static String get(String pageName) {
       return FileReaderManager.getInstance().getConfigFileReader().getApplicationURL().concat(pageName);

   }
}
