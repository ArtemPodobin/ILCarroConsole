import manager.ProviderData;

import models.Search;
import org.openqa.selenium.By;
import org.testng.Assert;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchTest extends TestBase {
   @BeforeMethod
    public void precondition() {
        app.getUser().openSearchForm();
    }


    @Test(dataProvider = "carSearchDtoCSV", dataProviderClass = ProviderData.class)
    public void searchTestYearDate(Search search) {
        app.getSearch().fillSearchForms(search);
        app.getUser().clickLogin();
        app.getUser().pause(5000);
        Assert.assertTrue(app.getCar().isElementPresent(By.cssSelector(".search-results")));
    }

}