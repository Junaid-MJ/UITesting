package Pages;

import org.openqa.selenium.By;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class YourCartPage {
    By removeButton;
    By checkoutButton=By.xpath("//*[text()='Checkout']");
    By field;
    By continueButton=By.xpath("//*[@id='continue']");
    By checkoutLabel= By.xpath("//*[text()='Checkout: Overview']");
    By checkoutCompleteLabel= By.xpath("//*[text()='THANK YOU FOR YOUR ORDER']");
    By finishButton= By.xpath("//*[text()='Finish']");
    By error= By.xpath("//*[@data-test='error']");


    public By RemoveButton() {
        return removeButton;
    }
    public By CheckoutButton() {
        return checkoutButton;
    }
    public By field() {
        return field;
    }
    public By ContinueButton() {
        return continueButton;
    }
    public By CheckoutLabel() {return checkoutLabel;}
    public By FinishButton() {return finishButton;}
    public By Error(){return error;}

    public By CheckoutCompleteLabel() {
        return checkoutCompleteLabel;
    }


    public void setRemoveButton(String productName){
        this.removeButton=By.xpath("//div[text()='"+productName+"']/parent::*/parent::*//*[text()='Remove']");
    }

    public void setField(String fieldName){
        this.field=By.xpath("//*[@id='"+fieldName+"']");
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
