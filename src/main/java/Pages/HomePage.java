package Pages;

import org.openqa.selenium.By;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class HomePage {
    private By menuButton= By.xpath("//*[@class='bm-burger-button']");
    private By logout=By.xpath("//a[text()='Logout']");

    private By product;
    private By cartButton=By.xpath("//*[@class='shopping_cart_link']");


    public By getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = By.xpath("//*[text()='"+product+"']/parent::*/parent::*/parent::*//*[text()='Add to cart']");
    }

    public By MenuButton() {
        return menuButton;
    }

    public By Logout() {
        return logout;
    }

    public By CartButton() {
        return cartButton;
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
