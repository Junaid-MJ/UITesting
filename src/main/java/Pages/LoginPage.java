package Pages;

import org.openqa.selenium.By;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class LoginPage {
    private By usernameTxtBox= By.xpath("//*[@id='user-name']");
    private By passwordTxtBox= By.xpath("//*[@id='password']");
    private By loginButton= By.xpath("//*[@id='login-button']");
    private By productLabel= By.xpath("//*[text()='Products']");
    private By warningMessage= By.xpath("//*[@data-test='error' ]");







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
