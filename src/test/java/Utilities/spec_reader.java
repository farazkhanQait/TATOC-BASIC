package Utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class spec_reader {
	static String str;
	static String[] words;
	static WebElement element;
	static Scanner sc = new Scanner(System.in);

	public static WebElement locate(WebDriver driver, String str) throws IOException {

		File file = new File("/home/farazkhan/Videos/tatoc/src/test/resources/locators.spec");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line;

		while ((line = br.readLine()) != null) {
 
			if (line.contains(str)) {

				words = line.split(":");
				//System.out.println(words[0]);
				//System.out.println(words[1]);
				//System.out.println(words[2]);
				
				String str1 = "id";
				String str2 = "xpath";
				String str3 = "css";
				if (words[1].trim().equals(str1)) {

					element = driver.findElement(By.id(words[2].trim()));
					
					break ;
				}
				if (words[1].trim().equals(str2)) {

					element = driver.findElement(By.xpath(words[2].trim()));
					
					break;

				}
				if (words[1].trim().equals(str3)) {
					element = driver.findElement(By.cssSelector(words[2].trim()));
					
					break;
				}
			}
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		br.close();
		return element;

	}
}
