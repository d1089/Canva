package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

	public String PropertiesReaderBrowser() throws IOException {
		String path = System.getProperty("user.dir");
		File file = new File(path+"/src/main/java/asset/resources/conf.properties");
		FileInputStream fileInput = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fileInput);	
		String browserName = prop.getProperty("Browser");
		return browserName;
	}
}
