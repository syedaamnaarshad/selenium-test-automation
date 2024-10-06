package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigUtil {
    public static Properties getConfig(String fileName){
        Properties properties = new Properties();
        try (FileInputStream input = new FileInputStream("src/test/resources/configuration/" + fileName + ".properties")) {
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return properties;
    }
}
