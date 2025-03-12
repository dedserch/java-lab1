package com.serzhputovski.lab1.service.impl;

import com.serzhputovski.lab1.entity.Abiturient;
import com.serzhputovski.lab1.service.AbiturientService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class AbiturientServiceImpl implements AbiturientService {
    private static final Logger logger = LogManager.getLogger(AbiturientService.class);

    public List<Abiturient> findUnsatisfactoryAbiturients(List<Abiturient> abiturients, int unsatisfactoryThreshold) {
        logger.debug("Searching abiturients with grade lower than unsatisfactory threshold: {}", unsatisfactoryThreshold);
        List<Abiturient> result = new ArrayList<>();
        for (Abiturient abiturient : abiturients) {
            if (abiturient.getGrade() < unsatisfactoryThreshold) {
                result.add(abiturient);
            }
        }
        logger.info("Found {} unsatisfactory abiturients", result.size());
        return result;
    }

    public List<Abiturient> findAbiturientsWithGradeAbove(List<Abiturient> abiturients, int threshold) {
        logger.debug("Searching abiturients with grade above threshold: {}", threshold);
        List<Abiturient> result = new ArrayList<>();
        for (Abiturient abiturient : abiturients) {
            if (abiturient.getGrade() > threshold) {
                result.add(abiturient);
            }
        }
        logger.info("Found {} abiturients with grade above {}", result.size(), threshold);
        return result;
    }

    public List<Abiturient> findTopNAbiturients(List<Abiturient> abiturients, int n, int passingThreshold) {
        logger.debug("Selecting top {} abiturients among those with grade at least {}", n, passingThreshold);
        List<Abiturient> passingAbiturients = new ArrayList<>();
        for (Abiturient abiturient : abiturients) {
            if (abiturient.getGrade() >= passingThreshold) {
                passingAbiturients.add(abiturient);
            }
        }
        logger.info("Abiturients with passing grade (>= {}): {}", passingThreshold, passingAbiturients);
        passingAbiturients.sort((a, b) -> Integer.compare(b.getGrade(), a.getGrade()));
        List<Abiturient> topN = new ArrayList<>();
        for (int i = 0; i < Math.min(n, passingAbiturients.size()); i++) {
            topN.add(passingAbiturients.get(i));
        }
        logger.info("Top {} abiturients: {}", n, topN);
        return topN;
    }
}
