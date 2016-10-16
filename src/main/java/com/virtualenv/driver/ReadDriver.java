package com.virtualenv.driver;

import com.sun.prism.ResourceFactory;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * Created by wasey on 10/15/16.
 */
public class ReadDriver {
    private static ReadDriver instance = null;
    private Properties appProperties;

    private ReadDriver(){
        appProperties = new Properties();
        try {
            appProperties.load(new FileInputStream(new File("/Users/wasey/IdeaProjects/kargo/Drivers/driver.properties")));
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public static ReadDriver getInstance(){
        if(instance == null){
            instance = new ReadDriver();
        }
        return instance;
    }


    public <T> T getProperty(String key){
        Object value = appProperties.getProperty(key);
        return (T) value;
    }
}
