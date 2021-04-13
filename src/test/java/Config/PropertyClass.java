package Config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyClass {

    public Properties readPropertiesFile() throws IOException {
        File fileName;
        FileInputStream fis = null;
        Properties prop = null;
        try {
            prop = new Properties();
            fileName=new File("D:\\Bills2U_Automation\\Bills2U_Automation\\src\\main\\resources\\PROPERTY FILE\\Bills2U.Data.properties");
            fis = new FileInputStream(fileName);

            // create Properties class object
            if (fis != null) {
                // load properties file into it
                prop.load(fis);
            } else {
                throw new FileNotFoundException("property file '" + fileName + "' not found in the classpath");
            }

        } catch (Exception e) {

            e.printStackTrace();
        } finally {
            if (fis != null) {
                fis.close();
            }
        }

        return prop;
    }
}
