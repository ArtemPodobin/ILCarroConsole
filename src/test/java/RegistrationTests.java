import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase {

    @BeforeMethod
    public void precondition(){
        if(app.getUser().isLogged()) app.getUser().logout();
    }

    @Test
    public void registrationPositive(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        User user = User.builder()
                .name("John")
                .lastName("Snow")
                .email("john_" + i + "@mail.com")
                .password("$Asdf1234")
                .build();

        app.getUser().openRegistrationForm();
        logger.info("openRegistrationForm invoked");
        app.getUser().fillRegistrationForm(user);
        logger.info("fillRegistrationForm invoked");
        app.getUser().submitLogin();
        logger.info("submitLogin invoked");
        logger.info("registrationPositive starts with credentials: login "
                + user.getEmail() + " & password: " + user.getPassword());
        Assert.assertTrue(app.getUser().isLoggedSuccess());

}
    @Test
    public void registrationNegativeWrongPassword(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;

        User user = User.builder()
                .name("John")
                .lastName("Snow")
                .email("john_" + i + "@mail.com")
                .password("jhsdf1234")
                .build();

        app.getUser().openRegistrationForm();
        app.getUser().fillRegistrationForm(user);
        app.getUser().clickLogin();
        Assert.assertTrue(!app.getUser().isLoggedSuccess());

    }

    @Test
    public void registrationNegativeWrongEmail(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        User user = User.builder()
                .name("John")
                .lastName("Snow")
                .email("john_" + i + "mail.com")
                .password("$jAhsdf1234")
                .build();


        app.getUser().openRegistrationForm();
        app.getUser().fillRegistrationForm(user);
        app.getUser().clickLogin();
        Assert.assertTrue(!app.getUser().isLoggedSuccess());
    }

}
