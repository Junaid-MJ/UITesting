package Pages;

import org.openqa.selenium.By;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class YourCartPage {
    By removeButton= By.xpath("//*[text()='Remove']");

    public By get(String element) throws ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Class c= this.getClass();
        Object obj = c.newInstance();

        Method method=c.getDeclaredMethod(element,null);
        method.setAccessible(true);
        By result= (By) method.invoke(obj,null);
        return result;


    }
    public By RemoveButton() {
        return removeButton;
    }
}
