package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GetPropertiesYopmail {
    private static GetPropertiesYopmail getPropertiesYopmail = null;
    private String email;

    public String getEmail() {
        return email;
    }

    public String getHost() {
        return host;
    }


    private String host;

    private GetPropertiesYopmail(){
        Properties properties = new Properties();
        String nameFile = "yopmail.properties";
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(nameFile);
        if (inputStream != null){
            try {
                properties.load(inputStream);
                host = properties.getProperty("host");
                email = properties.getProperty("email");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static GetPropertiesYopmail getInstance(){
        if (getPropertiesYopmail == null)
            getPropertiesYopmail = new GetPropertiesYopmail();
        return getPropertiesYopmail;
    }
}
