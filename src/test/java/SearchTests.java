import manager.TestNgListener;
import org.openqa.selenium.json.JsonOutput;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(TestNgListener.class)
public class SearchTests extends TestBase{
    @BeforeMethod
    public void precondition(){
        app.getSearch().openSearchForm();

    }

    @Test
    public void searchPositiveTest(){
        app.getSearch().fillSearchForm("Haifa", "7/14/2023", "3/19/2024");
        app.getSearch().pause(1000);
        app.getSearch().submitForm();
    }


}