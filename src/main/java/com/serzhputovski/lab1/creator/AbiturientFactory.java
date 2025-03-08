package com.serzhputovski.lab1.creator;

import com.serzhputovski.lab1.entity.Abiturient;
import com.serzhputovski.lab1.validator.AbiturientValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AbiturientFactory {

    private static final Logger logger = LogManager.getLogger(AbiturientFactory.class);

    public Abiturient createAbiturient(int id,
                                       String surname,
                                       String name,
                                       String patronymic,
                                       String address,
                                       String phone,
                                       int grade) {
        logger.debug("Creating a new Abiturient instance with id: {}, surname: {}, name: {}, patronymic: {}, address: {}, phone: {}, grade: {}",
                id, surname, name, patronymic, address, phone, grade);

        Abiturient abiturient = new Abiturient(id, surname, name, patronymic, address, phone, grade);

        if (!AbiturientValidator.isValid(abiturient)) {
            logger.error("Abiturient validation failed for id: {}", id);
            throw new IllegalArgumentException("Invalid Abiturient data for id: " + id);
        }

        logger.info("Abiturient created successfully: {}", abiturient);
        return abiturient;
    }
}
