package Pages;

import org.openqa.selenium.By;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class HomePage {
    private By menuButton= By.xpath("//*[@class='bm-burger-button']");
    private By logout=By.xpath("//a[text()='Logout']");
    private By product;
    private By cartButton=By.xpath("//*[@class='shopping_cart_link']");
    private By sort= By.xpath("//*[@class='product_sort_container']");
    private By sortOption;
    private By alphabeticalListOfItem= By.xpath("//*[@class='inventory_item_name']");
    private By numericListOfItem= By.xpath("//*[@class='inventory_item_price']");



    public By getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = By.xpath("//*[text()='"+product+"']/parent::*/parent::*/parent::*//*[text()='Add to cart']");
    }

    public void setSortOption(String option) {
        this.sortOption = By.xpath("//*[text()='"+option+"']");
    }
    public By SortOption() {
        return sortOption;
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

    public By Sort() {
        return sort;
    }

    public By AlphabeticalListOfItem() {
        return alphabeticalListOfItem;
    }
    public By NumericListOfItem() {
        return numericListOfItem;
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
