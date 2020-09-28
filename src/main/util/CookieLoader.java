package util;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.StringTokenizer;

public class CookieLoader {
    public static void loadCookie(WebDriver driver) {
        try {
            FileReader fileReader = new FileReader("src/test/cookie.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line, "=");
                String name = tokenizer.nextToken();
                String value = tokenizer.nextToken();
                driver.manage().addCookie(new Cookie(name, value));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
