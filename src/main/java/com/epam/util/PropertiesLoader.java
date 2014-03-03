package com.epam.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {

    /**
     * Read a properties file from the classpath and return a Properties object
     * @param filename
     * @return
     * @throws IOException
     */
    static public Properties readProperties(String filename) throws IOException {
        Properties props = new Properties();
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        InputStream stream = loader.getResourceAsStream(filename);
        props.load(stream);
        return props;
    }
}