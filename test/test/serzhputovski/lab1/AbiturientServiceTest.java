package test.serzhputovski.lab1;

import com.serzhputovski.blinovcourse.lab1.creator.DefaultAbiturientFactory;
import com.serzhputovski.blinovcourse.lab1.entity.Abiturient;
import com.serzhputovski.blinovcourse.lab1.service.AbiturientService;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AbiturientServiceTest {

    private AbiturientService service;
    private Abiturient[] abiturients;

    @BeforeClass
    public void setUp() {
        service = new AbiturientService();
        DefaultAbiturientFactory factory = new DefaultAbiturientFactory();
        abiturients = factory.createAbiturients();
    }

    @Test
    public void testGetUnsatisfactoryAbiturients() {
        Abiturient[] unsatisfactory = service.getUnsatisfactoryAbiturients(abiturients);
        Assert.assertEquals(unsatisfactory.length, 4);
    }

    @Test
    public void testGetAbiturientsWithGradeAbove() {
        Abiturient[] above = service.getAbiturientsWithGradeAbove(abiturients, 380);
        Assert.assertEquals(above.length, 2);
    }

    @Test
    public void testGetTopAbiturients() {
        Abiturient[] top = service.getTopAbiturients(abiturients, 3);
        Assert.assertEquals(top.length, 3);
        Assert.assertEquals(top[0].getGrade(), 400);
        Assert.assertEquals(top[1].getGrade(), 390);
        Assert.assertEquals(top[2].getGrade(), 380);
    }

    @Test
    public void testGetPassingAbiturients() {
        Abiturient[] passing = service.getPassingAbiturients(abiturients);
        Assert.assertEquals(passing.length, 6);
    }
}
