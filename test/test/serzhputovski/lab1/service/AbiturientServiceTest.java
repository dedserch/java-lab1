package test.serzhputovski.lab1.service;

import com.serzhputovski.lab1.entity.Abiturient;
import com.serzhputovski.lab1.service.AbiturientService;
import org.assertj.core.api.Assertions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class AbiturientServiceTest {

    private AbiturientService abiturientService;
    private List<Abiturient> abiturients;

    @BeforeMethod
    public void setUp() {
        abiturientService = new AbiturientService();
        abiturients = new ArrayList<>();

        abiturients.add(new Abiturient(1, "Ivanov", "Ivan", "Ivanovich", "Address1", "Phone1", 280));
        abiturients.add(new Abiturient(2, "Petrov", "Petr", "Petrovich", "Address2", "Phone2", 350));
        abiturients.add(new Abiturient(3, "Sidorov", "Sidor", "Sidorovich", "Address3", "Phone3", 400));
        abiturients.add(new Abiturient(4, "Smirnov", "Sergey", "Sergeevich", "Address4", "Phone4", 310));
        abiturients.add(new Abiturient(5, "Fedorov", "Fedor", "Fedorovich", "Address5", "Phone5", 290));
    }

    @Test
    public void testFindUnsatisfactoryAbiturients() {
        int unsatisfactoryThreshold = 300;
        List<Abiturient> result = abiturientService.findUnsatisfactoryAbiturients(abiturients, unsatisfactoryThreshold);
        // Ожидаем, что будут выбраны абитуриенты с оценками меньше 300 (Ivanov и Fedorov)
        Assertions.assertThat(result).hasSize(2);
        Assertions.assertThat(result)
                .extracting(Abiturient::getSurname)
                .containsExactlyInAnyOrder("Ivanov", "Fedorov");
    }

    @Test
    public void testFindAbiturientsWithGradeAbove() {
        int threshold = 320;
        List<Abiturient> result = abiturientService.findAbiturientsWithGradeAbove(abiturients, threshold);
        // Ожидаем, что будут выбраны абитуриенты с оценками выше 320 (Petrov и Sidorov)
        Assertions.assertThat(result).hasSize(2);
        Assertions.assertThat(result)
                .extracting(Abiturient::getSurname)
                .containsExactlyInAnyOrder("Petrov", "Sidorov");
    }

    @Test
    public void testFindTopNAbiturients() {
        int n = 2;
        int passingThreshold = 300;
        List<Abiturient> result = abiturientService.findTopNAbiturients(abiturients, n, passingThreshold);
        // Из абитуриентов с оценками >= 300 (Petrov, Sidorov, Smirnov)
        // ожидаем, что топ-2 будут с самыми высокими оценками: Sidorov (400) и Petrov (350)
        Assertions.assertThat(result).hasSize(2);
        Assertions.assertThat(result.get(0).getSurname()).isEqualTo("Sidorov");
        Assertions.assertThat(result.get(1).getSurname()).isEqualTo("Petrov");
    }
}
