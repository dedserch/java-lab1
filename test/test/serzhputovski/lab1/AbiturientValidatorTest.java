package test.serzhputovski.lab1;

import com.serzhputovski.blinovcourse.lab1.entity.Abiturient;
import com.serzhputovski.blinovcourse.lab1.validator.AbiturientValidator;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class AbiturientValidatorTest {
    @Test
    public void testValidAbiturient() {
        Abiturient abiturient = new Abiturient(1, "Ivanov", "Ivan", "Ivanovich", "ул. Ленина, д.1", "+3751234567", 350);
        Assert.assertTrue(AbiturientValidator.isValid(abiturient), "Valid abiturient should return true");
    }

    @Test
    public void testNullAbiturient() {
        Abiturient abiturient = null;
        Assert.assertFalse(AbiturientValidator.isValid(abiturient), "Null abiturient should return false");
    }

    @Test
    public void testInvalidId() {
        Abiturient abiturient = new Abiturient(0, "Ivanov", "Ivan", "Ivanovich", "ул. Ленина, д.1", "+3751234567", 350);
        Assert.assertFalse(AbiturientValidator.isValid(abiturient), "Abiturient with id 0 should return false");
    }

    @Test
    public void testInvalidGradeLow() {
        Abiturient abiturient = new Abiturient(1, "Ivanov", "Ivan", "Ivanovich", "ул. Ленина, д.1", "+3751234567", -10);
        Assert.assertFalse(AbiturientValidator.isValid(abiturient), "Abiturient with negative grade should return false");
    }

    @Test
    public void testInvalidGradeHigh() {
        Abiturient abiturient = new Abiturient(1, "Ivanov", "Ivan", "Ivanovich", "ул. Ленина, д.1", "+3751234567", 500);
        Assert.assertFalse(AbiturientValidator.isValid(abiturient), "Abiturient with grade above 400 should return false");
    }

    @Test
    public void testInvalidSurname() {
        Abiturient abiturient = new Abiturient(1, "", "Ivan", "Ivanovich", "ул. Ленина, д.1", "+3751234567", 350);
        Assert.assertFalse(AbiturientValidator.isValid(abiturient), "Abiturient with empty surname should return false");
    }

    @Test
    public void testInvalidName() {
        Abiturient abiturient = new Abiturient(1, "Ivanov", "", "Ivanovich", "ул. Ленина, д.1", "+3751234567", 350);
        Assert.assertFalse(AbiturientValidator.isValid(abiturient), "Abiturient with empty name should return false");
    }

    @Test
    public void testInvalidPhone() {
        Abiturient abiturient = new Abiturient(1, "Ivanov", "Ivan", "Ivanovich", "ул. Ленина, д.1", "123456789", 350);
        Assert.assertFalse(AbiturientValidator.isValid(abiturient), "Abiturient with invalid phone number should return false");
    }
}