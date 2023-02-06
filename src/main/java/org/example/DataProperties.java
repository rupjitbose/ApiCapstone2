package org.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DataProperties {

    Properties properties;
    public String getProperty(String key) throws IOException {
        properties=new Properties();
        FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/src/main/data.properties");
        properties.load(fis);
        String s= properties.getProperty(key);
        return s;
    }
}
