package Variables;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class configReader {
    public static Properties property;
    private static String configfilepath= "configurations/config.properties";

    public static void initializePropertyFile()
    {
        property=new Properties();
        try {
            InputStream getproperty= new FileInputStream(configfilepath);
            property.load(getproperty);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
