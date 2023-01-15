package Pages;

import org.openqa.selenium.By;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class HomePage {
    By menuButton= By.xpath("//*[@class='bm-burger-button']");
    By logout=By.xpath("//a[text()='Logout']");



    public By MenuButton() {
        return menuButton;
    }

    public By Logout() {
        return logout;
    }


    public By get(String element) throws ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Class c= this.getClass();
        Object obj = c.newInstance();

        Method method=c.getDeclaredMethod(element,null);
        method.setAccessible(true);
        By result= (By) method.invoke(obj,null);
        return result;


    }

}
