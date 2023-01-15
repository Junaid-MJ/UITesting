package StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class StepDefsHelper {
    public static WebDriver getDriver(){
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/test/resources/chromedriver.exe");
        return new ChromeDriver();

    }

    public static Properties ReadSystemProperties() throws IOException {
        FileReader reader=new FileReader("Project.properties");

        Properties p=new Properties();
        p.load(reader);
        return p;
    }


}
