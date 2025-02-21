package com.serzhputovski.blinovcourse.lab1.validator;

import com.serzhputovski.blinovcourse.lab1.entity.Abiturient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AbiturientValidator {

    private static final Logger logger = LogManager.getLogger(AbiturientValidator.class);

    public static boolean isValid(Abiturient abiturient) {
        if (abiturient == null) {
            logger.error("Abiturient is null");
            return false;
        }
        if (!validateId(abiturient.getId())) {
            return false;
        }
        if (!validateGrade(abiturient.getGrade())) {
            return false;
        }
        if (!validateSurname(abiturient.getSurname())) {
            return false;
        }
        if (!validateName(abiturient.getName())) {
            return false;
        }
        if (!validatePhone(abiturient.getPhone())) {
            return false;
        }
        logger.info("Abiturient is valid: " + abiturient.getId());
        return true;
    }

    private static boolean validateId(int id) {
        if (id <= 0) {
            logger.error("ID must be greater than zero. Invalid id: " + id);
            return false;
        }
        return true;
    }

    private static boolean validateGrade(int grade) {
        if (grade < 0 || grade > 400) {
            logger.error("The grade must be between 0 and 400. Invalid grade: " + grade);
            return false;
        }
        return true;
    }

    private static boolean validateSurname(String surname) {
        if (surname == null || surname.isEmpty()) {
            logger.error("Surname is null or empty");
            return false;
        }
        return true;
    }

    private static boolean validateName(String name) {
        if (name == null || name.isEmpty()) {
            logger.error("Name is null or empty");
            return false;
        }
        return true;
    }

    private static boolean validatePhone(String phone) {
        if (phone == null || !phone.matches("\\+375[0-9]{7,9}")) {
            logger.error("Invalid phone number: " + phone);
            return false;
        }
        return true;
    }
}
