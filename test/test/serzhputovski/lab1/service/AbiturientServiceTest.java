package test.serzhputovski.lab1.service;

import com.serzhputovski.lab1.entity.Abiturient;
import com.serzhputovski.lab1.service.AbiturientService;
import com.serzhputovski.lab1.service.impl.AbiturientServiceImpl;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class AbiturientServiceTest {

    private AbiturientService abiturientService;
    private List<Abiturient> abiturients;

    @BeforeMethod
    public void setUp() {
        abiturientService = new AbiturientServiceImpl();
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

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(result).hasSize(2);
        softly.assertThat(result)
                .extracting(Abiturient::getSurname)
                .containsExactlyInAnyOrder("Ivanov", "Fedorov");
        softly.assertAll();
    }

    @Test
    public void testFindAbiturientsWithGradeAbove() {
        int threshold = 320;
        List<Abiturient> result = abiturientService.findAbiturientsWithGradeAbove(abiturients, threshold);

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(result).hasSize(2);
        softly.assertThat(result)
                .extracting(Abiturient::getSurname)
                .containsExactlyInAnyOrder("Petrov", "Sidorov");
        softly.assertAll();
    }

    @Test
    public void testFindTopNAbiturients() {
        int n = 2;
        int passingThreshold = 300;
        List<Abiturient> result = abiturientService.findTopNAbiturients(abiturients, n, passingThreshold);

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(result).hasSize(2);
        softly.assertThat(result.get(0).getSurname()).isEqualTo("Sidorov");
        softly.assertThat(result.get(1).getSurname()).isEqualTo("Petrov");
        softly.assertAll();
    }
}
