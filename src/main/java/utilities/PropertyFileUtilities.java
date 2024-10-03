package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertyFileUtilities {

	
	public String readDataFromPropertFile( String propType) throws Throwable {
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("src/test/resource/config/config.properties");
		prop.load(fis);
		String value=prop.getProperty(propType);
		return value;
	}
}
