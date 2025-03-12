package com.serzhputovski.lab1.creator.impl;

import com.serzhputovski.lab1.creator.AbiturientFactory;
import com.serzhputovski.lab1.entity.Abiturient;
import com.serzhputovski.lab1.validator.AbiturientValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AbiturientFactoryImpl implements AbiturientFactory {
    private static final Logger logger = LogManager.getLogger(AbiturientFactoryImpl.class);

    @Override
    public Abiturient createAbiturient(int id,
                                       String surname,
                                       String name,
                                       String patronymic,
                                       String address,
                                       String phone,
                                       int grade) {
        logger.debug("Creating Abiturient with id: {}", id);

        Abiturient abiturient = new Abiturient(id, surname, name, patronymic, address, phone, grade);

        if (!AbiturientValidator.isValid(abiturient)) {
            logger.error("Validation failed for Abiturient with id: {}", id);
            throw new IllegalArgumentException("Invalid Abiturient data for id: " + id);
        }

        logger.info("Abiturient successfully created: {}", abiturient);
        return abiturient;
    }
}
