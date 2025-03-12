package test.serzhputovski.lab1.creator;

import com.serzhputovski.lab1.creator.AbiturientFactory;
import com.serzhputovski.lab1.creator.impl.AbiturientFactoryImpl;
import com.serzhputovski.lab1.entity.Abiturient;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

public class AbiturientFactoryTest {

    private final AbiturientFactory factory = new AbiturientFactoryImpl();

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

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(abiturient).isNotNull();
        softly.assertThat(abiturient.getId()).isEqualTo(id);
        softly.assertThat(abiturient.getSurname()).isEqualTo(surname);
        softly.assertThat(abiturient.getName()).isEqualTo(name);
        softly.assertThat(abiturient.getPatronymic()).isEqualTo(patronymic);
        softly.assertThat(abiturient.getAddress()).isEqualTo(address);
        softly.assertThat(abiturient.getPhone()).isEqualTo(phone);
        softly.assertThat(abiturient.getGrade()).isEqualTo(grade);
        softly.assertAll();
    }

    @Test
    public void testCreateInvalidAbiturient() {
        int id = 1;
        String surname = "Ivanov";
        String name = "Ivan";
        String patronymic = "Ivanovich";
        String address = "Address1";
        String phone = "invalid_phone";
        int grade = 350;

        try {
            factory.createAbiturient(id, surname, name, patronymic, address, phone, grade);
        } catch (IllegalArgumentException e) {
            SoftAssertions softly = new SoftAssertions();
            softly.assertThat(e).isInstanceOf(IllegalArgumentException.class);
            softly.assertThat(e.getMessage()).contains("Invalid Abiturient data");
            softly.assertAll();
        }
    }
}
