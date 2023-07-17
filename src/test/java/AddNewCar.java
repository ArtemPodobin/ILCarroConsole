import manager.ProviderData;
import models.Car;
import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewCar extends TestBase{

    @BeforeMethod
    public void precondition(){

        if(app.getUser().isLogged() == false)
            app.getUser().login(
                     User.builder()
                             .email("asd@fgh.com")
                             .password("$Asdf1234")
                             .build());
    }

    @Test(dataProvider = "userAddDtoCSV", dataProviderClass = ProviderData.class)
    public void addNewCarPositive(Car car){

    app.getCar().openCarForm();
    app.getCar().fillCarForm(car);
    app.getUser().submitLogin();
    Assert.assertTrue(app.getCar().isElementPresent(By.xpath("//h1[normalize-space()='Car added']")));

    }
    @AfterMethod
    public void postcondition(){
        app.getCar().click(By.xpath(("//button[normalize-space()='Search cars']")));

    }

}
