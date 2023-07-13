import manager.ProviderData;
import models.Car;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchTest extends TestBase {
   @BeforeMethod
    public void precondition() {
        app.getUser().openSearchForm();
    }

    @Test
    public void searchTestStringDate() {
                app.getCar().fillSearchForm(Car.builder()
                .location("Tel Aviv")
                .date(app.getCar().getDate())
                .build());
        app.getUser().submitLogin();
        app.getUser().pause(5000);
        Assert.assertTrue(app.getCar().isElementPresent(By.cssSelector(".search-results")));
    }
    @Test(dataProvider = "carSearchDto", dataProviderClass = ProviderData.class)
    public void searchTestYearDate(Car car) {
        app.getCar().fillSearchFormForRandomDates(car);
        app.getUser().submitLogin();
        app.getUser().pause(5000);
        Assert.assertTrue(app.getCar().isElementPresent(By.cssSelector(".search-results")));
    }

}