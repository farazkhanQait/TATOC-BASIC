package Utilities;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class config_reader {

	public static String getPropValues() throws IOException {

		Properties prop = new Properties();

		File file = new File("/home/farazkhan/Videos/tatoc/src/test/resources/config1.properties");
		FileReader fr = new FileReader(file);

		prop.load(fr);

		String browserName = prop.getProperty("browserName");

		System.out.println(browserName);

		return browserName;
	}

}
