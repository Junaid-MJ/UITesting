package Pages;

import org.openqa.selenium.By;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class LoginPage {
    By usernameTxtBox= By.xpath("//*[@id='user-name']");
    By passwordTxtBox= By.xpath("//*[@id='password']");
    By loginButton= By.xpath("//*[@id='login-button']");
    By productLabel= By.xpath("//*[text()='Products']");
    By warningMessage= By.xpath("//*[@data-test='error' ]");







    public By get(String element) throws ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Class c= this.getClass();
        Object obj = c.newInstance();

        Method method=c.getDeclaredMethod(element,null);
        method.setAccessible(true);
       By result= (By) method.invoke(obj,null);
       return result;


    }
    public By getUsernameTxtBox() {
        return usernameTxtBox;
    }

    public By getPasswordTxtBox() {
        return passwordTxtBox;
    }

    public By LoginButton() {
        return loginButton;
    }

    public By getProductLabel() {
        return productLabel;
    }

    public By getWarningMessage() {
        return warningMessage;
    }



}
