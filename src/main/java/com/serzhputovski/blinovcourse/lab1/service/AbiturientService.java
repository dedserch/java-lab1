package com.serzhputovski.blinovcourse.lab1.service;

import com.serzhputovski.blinovcourse.lab1.entity.Abiturient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Arrays;
import java.util.Comparator;

public class AbiturientService {

    private static final Logger logger = LogManager.getLogger(AbiturientService.class);
    private static final int PASSING_THRESHOLD = 350;

    public Abiturient[] getUnsatisfactoryAbiturients(Abiturient[] abiturients) {
        int count = 0;
        for (Abiturient a : abiturients) {
            if (a.getGrade() < PASSING_THRESHOLD) {
                count++;
            }
        }
        Abiturient[] result = new Abiturient[count];
        int index = 0;
        for (Abiturient a : abiturients) {
            if (a.getGrade() < PASSING_THRESHOLD) {
                result[index++] = a;
            }
        }
        logger.info("Unsatisfactory abiturients count: " + count);
        return result;
    }

    public Abiturient[] getAbiturientsWithGradeAbove(Abiturient[] abiturients, int threshold) {
        int count = 0;
        for (Abiturient a : abiturients) {
            if (a.getGrade() > threshold) {
                count++;
            }
        }
        Abiturient[] result = new Abiturient[count];
        int index = 0;
        for (Abiturient a : abiturients) {
            if (a.getGrade() > threshold) {
                result[index++] = a;
            }
        }
        logger.info("Abiturients with grade above " + threshold + " count: " + count);
        return result;
    }

    public Abiturient[] getTopAbiturients(Abiturient[] abiturients, int n) {
        Abiturient[] copy = abiturients.clone();
        Arrays.sort(copy, new Comparator<Abiturient>() {
            @Override
            public int compare(Abiturient a1, Abiturient a2) {
                return Integer.compare(a2.getGrade(), a1.getGrade());
            }
        });
        int topCount = Math.min(n, copy.length);
        Abiturient[] top = new Abiturient[topCount];
        System.arraycopy(copy, 0, top, 0, topCount);
        logger.info("Top abiturients count: " + topCount);
        return top;
    }

    public Abiturient[] getPassingAbiturients(Abiturient[] abiturients) {
        int count = 0;
        for (Abiturient a : abiturients) {
            if (a.getGrade() >= PASSING_THRESHOLD) {
                count++;
            }
        }
        Abiturient[] result = new Abiturient[count];
        int index = 0;
        for (Abiturient a : abiturients) {
            if (a.getGrade() >= PASSING_THRESHOLD) {
                result[index++] = a;
            }
        }
        logger.info("Passing abiturients count: " + count);
        return result;
    }
}

