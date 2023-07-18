package reading_file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
	
	// .properties
	// application.properties
	// key=value
	// key2=value2
	// key3=
	
	public static void main(String[] args) {
		
		Properties prop = new Properties();
		FileInputStream fis;
		
		try {
			fis = new FileInputStream("src\\main\\java\\properties\\application.properties");
			prop.load(fis);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
		
		String url = prop.getProperty("application.url.qa");
		System.out.println(url);
		
	}

}
