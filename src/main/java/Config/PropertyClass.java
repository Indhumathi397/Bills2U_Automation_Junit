package Config;

import java.io.*;
import java.util.Properties;

public class PropertyClass {

    public Properties readPropertiesFile() throws IOException {
        File fileName=null;
        FileInputStream fis = null;
        Properties prop = null;
        try {
            prop = new Properties();
            fileName=new File("D:\\Intellij workspace\\Bills2U_Automation\\src\\main\\resources\\PROPERTY FILE");
            fis = new FileInputStream(fileName);

            // create Properties class object
            if (fis != null) {
                // load properties file into it
                prop.load(fis);
            } else {
                throw new FileNotFoundException("property file '" + fileName + "' not found in the classpath");
            }

        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        } finally {
            fis.close();
        }

        return prop;
    }
}
