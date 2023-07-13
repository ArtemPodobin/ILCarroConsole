package manager;

import models.Car;
import models.User;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProviderData {

    @DataProvider
    public Iterator<Object[]> userDto(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{User.builder()
                .email("asd@fgh.com")
                .password("$Asdf1234")
                .build()
        });
        list.add(new Object[]{User.builder()
                .email("asd@fgh.com")
                .password("$Asdf1234")
                .build()
        });        list.add(new Object[]{User.builder()
                .email("asd@fgh.com")
                .password("$Asdf1234")
                .build()
        });
        return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]> carDto(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{Car.builder().location("Tel Aviv")
                .make("KIA")
                .model("Sportage")
                .year("2023")
                .fuel("Petrol")
                .seats("5")
                .carClass("B")
                .carRegNumber("100-200-10")
                .price("150")
                .about("")
                .build()
        });
        list.add(new Object[]{Car.builder().location("Tel Aviv")
                .make("Renaut")
                .model("Sportage")
                .year("2022")
                .fuel("Petrol")
                .seats("3")
                .carClass("B")
                .carRegNumber("100-211-10")
                .price("120")
                .about("")
                .build()
        });
        list.add(new Object[]{Car.builder().location("Tel Aviv")
                .make("KIA")
                .model("Grande")
                .year("2.19")
                .fuel("Diesel")
                .seats("5")
                .carClass("B")
                .carRegNumber("100-230-10")
                .price("100")
                .about("")
                .build()
        });
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> carSearchDto() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{Car.builder().location("Tel Aviv")
                .pickUpDate("10.05.2024")
                .dropDownDate("12.05.2024")
                .build()});
        return list.iterator();
    }
}