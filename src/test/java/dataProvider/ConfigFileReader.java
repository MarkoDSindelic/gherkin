package dataProvider;

import enums.DriverType;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

    private Properties properties;
    private final String propertyFilePath = "configs\\Configuration.properties";


    public ConfigFileReader(){

        BufferedReader reader;

        try {

            reader = new BufferedReader(new FileReader( propertyFilePath/*"configs\\Configuration.properties"*/));
            properties = new Properties();

            try {
                properties.load(reader);
                reader.close();
            }catch (IOException e){
                e.printStackTrace();
            }

        }catch(IOException e){
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }

    public String getApplicationURL(){
        String url = properties.getProperty("url");
        if(url != null) return url;
        else throw new RuntimeException("url not specified in the Configuration.properties file");
    }

    public DriverType getBrowser(){

        String browserName = properties.getProperty("browser");
        if(browserName == null || browserName.equalsIgnoreCase("chrome")) return DriverType.CHROME;
        else if(browserName.equalsIgnoreCase("firefox")) return DriverType.FIREFOX;
        else if(browserName.equalsIgnoreCase("edge")) return DriverType.EDGE;
        else throw new RuntimeException("Browser not found : " + browserName);

    }


    public Boolean getBrowserWindowSize(){

        String windowSize = properties.getProperty("windowMaximize");
        if(windowSize != null) return Boolean.valueOf(windowSize);
        return true;
    }

}
