package test.serzhputovski.lab1.creator;

import com.serzhputovski.lab1.creator.AbiturientFactory;
import com.serzhputovski.lab1.entity.Abiturient;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class AbiturientFactoryTest {

    private final AbiturientFactory factory = new AbiturientFactory();

    @Test
    public void testCreateValidAbiturient() {
        int id = 1;
        String surname = "Ivanov";
        String name = "Ivan";
        String patronymic = "Ivanovich";
        String address = "Address1";
        String phone = "+3751234567";
        int grade = 350;

        Abiturient abiturient = factory.createAbiturient(id, surname, name, patronymic, address, phone, grade);

        Assertions.assertThat(abiturient).isNotNull();
        Assertions.assertThat(abiturient.getId()).isEqualTo(id);
        Assertions.assertThat(abiturient.getSurname()).isEqualTo(surname);
        Assertions.assertThat(abiturient.getName()).isEqualTo(name);
        Assertions.assertThat(abiturient.getPatronymic()).isEqualTo(patronymic);
        Assertions.assertThat(abiturient.getAddress()).isEqualTo(address);
        Assertions.assertThat(abiturient.getPhone()).isEqualTo(phone);
        Assertions.assertThat(abiturient.getGrade()).isEqualTo(grade);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testCreateInvalidAbiturient() {
        int id = 1;
        String surname = "Ivanov";
        String name = "Ivan";
        String patronymic = "Ivanovich";
        String address = "Address1";
        String phone = "invalid_phone";
        int grade = 350;

        factory.createAbiturient(id, surname, name, patronymic, address, phone, grade);
    }
}
