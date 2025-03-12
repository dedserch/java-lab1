package com.serzhputovski.lab1.validator;

import com.serzhputovski.lab1.entity.Abiturient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AbiturientValidator {

    private static final Logger logger = LogManager.getLogger(AbiturientValidator.class);
    private static final String NAME_REGEX = "^[A-Za-zА-Яа-яЁё]+$";
    private static final String PHONE_REGEX = "\\+375[0-9]{7,9}";

    public static boolean isValid(Abiturient abiturient) {
        boolean valid = abiturient != null &&
                abiturient.getId() > 0 &&
                (abiturient.getGrade() >= 0 && abiturient.getGrade() <= 400) &&
                (abiturient.getSurname() != null && abiturient.getSurname().matches(NAME_REGEX)) &&
                (abiturient.getName() != null && abiturient.getName().matches(NAME_REGEX)) &&
                (abiturient.getPhone() != null && abiturient.getPhone().matches(PHONE_REGEX));
        if (!valid) {
            logger.error("Abiturient is invalid: " + (abiturient == null ? "null" : abiturient.getId()));
        } else {
            logger.info("Abiturient is valid: " + abiturient.getId());
        }
        return valid;
    }
}
