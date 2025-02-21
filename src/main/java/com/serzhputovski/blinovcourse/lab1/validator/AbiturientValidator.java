package com.serzhputovski.blinovcourse.lab1.validator;

import com.serzhputovski.blinovcourse.lab1.entity.Abiturient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AbiturientValidator {

    private static final Logger logger = LogManager.getLogger(AbiturientValidator.class.getName());

    public static boolean isValid(Abiturient abiturient) {
        if (abiturient == null) {
            logger.error("Abiturient is null");
            return false;
        }
        if (abiturient.getId() <= 0) {
            logger.error("Invalid id: " + abiturient.getId());
            return false;
        }
        if (abiturient.getGrade() < 0 && abiturient.getGrade() > 400) {
            logger.error("The grade must be between 0 and 400. Invalid grade: " + abiturient.getGrade());
            return false;
        }
        if (abiturient.getSurname() == null || abiturient.getSurname().isEmpty()) {
            logger.error("Surname is null or empty");
            return false;
        }
        if (abiturient.getName() == null || abiturient.getName().isEmpty()) {
            logger.error("Name is null or empty");
            return false;
        }
        if (abiturient.getPhone() == null || !abiturient.getPhone().matches("\\+375[0-9]{7,9}")) {
            logger.error("Invalid phone number: " + abiturient.getPhone());
            return false;
        }
        logger.info("Abiturient is valid: " + abiturient.getId());
        return true;
    }
}
