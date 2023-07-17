package manager;

import models.Car;
import models.Search;
import models.User;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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
    public Iterator<Object[]> userRegDtoCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/reg_dataset.csv")));
        String line = reader.readLine();
        while (line != null){
            String[] split = line.split(",");
            list.add(new Object[]{ User.builder()
                    .name(split[0])
                    .lastName(split[1])
                    .email(split[2])
                    .password(split[3])
                    .build()
            });
            line = reader.readLine();
        }
        return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]> userLogDtoCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/login_dataset.csv")));
        String line = reader.readLine();

        while(line != null){
            String[] split = line.split(",");
            list.add(new Object[]{ User.builder()
                    .email(split[0])
                    .password(split[1])
                    .build()
            });
            line = reader.readLine();
        }
        return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]> userAddDtoCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/add_dataset.csv")));
        String line = reader.readLine();

        while(line != null){
            String[] split = line.split(";");
            list.add(new Object[]{ Car.builder().location(split[0])
                    .make(split[1])
                    .model(split[2])
                    .year(split[3])
                    .fuel(split[4])
                    .seats(split[5])
                    .carClass(split[6])
                    .carRegNumber(split[7])
                    .price(split[8])
                    .build()
            });
            line = reader.readLine();
        }
        return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]> carSearchDtoCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/search_dataset.csv")));
        String line = reader.readLine();

        while(line != null){
            String[] split = line.split(";");
            list.add(new Object[]{ Search.builder().city(split[0])
                    .startDate(split[1])
                    .endDate(split[2])
                    .build()
            });
            line = reader.readLine();
        }
        return list.iterator();
    }
}