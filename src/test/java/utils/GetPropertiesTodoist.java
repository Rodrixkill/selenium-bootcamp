package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GetPropertiesTodoist {
    private static GetPropertiesTodoist getPropertiesTodoist = null;

    public String getHost() {
        return host;
    }
    public String getEmail() { return email; }

    public String getPassword() { return password; }

    private String host;
    private String email;
    private String password;

    private GetPropertiesTodoist(){
        Properties properties = new Properties();
        String nameFile = "todoist.properties";
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(nameFile);
        if (inputStream != null){
            try {
                properties.load(inputStream);
                host = properties.getProperty("host");
                email = properties.getProperty("email");
                password = properties.getProperty("password");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static GetPropertiesTodoist getInstance(){
        if (getPropertiesTodoist == null)
            getPropertiesTodoist = new GetPropertiesTodoist();
        return getPropertiesTodoist;
    }
}
