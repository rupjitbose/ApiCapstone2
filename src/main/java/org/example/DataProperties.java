package org.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DataProperties {


    private String s="";
    private Properties properties;
    public String getProperty(String key) throws IOException {
        properties=new Properties();
        FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/src/main/data.properties");
        properties.load(fis);
        if(System.getProperty("app-id")!=null && System.getProperty("base-uri")!=null){

        }
        s=System.getProperty("app-id")!=null ?System.getProperty("app-id"):properties.getProperty(key);
        s=System.getProperty("base-uri")!=null ?System.getProperty("app-id"):properties.getProperty(key);
        //s=properties.getProperty(key);
        return s;
    }
}
