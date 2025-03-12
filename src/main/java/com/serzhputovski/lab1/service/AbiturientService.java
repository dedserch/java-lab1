package com.serzhputovski.lab1.service;

import com.serzhputovski.lab1.entity.Abiturient;

import java.util.List;

public interface AbiturientService {

    List<Abiturient> findUnsatisfactoryAbiturients(List<Abiturient> abiturients, int unsatisfactoryThreshold);

    List<Abiturient> findAbiturientsWithGradeAbove(List<Abiturient> abiturients, int threshold);

    List<Abiturient> findTopNAbiturients(List<Abiturient> abiturients, int n, int passingThreshold);
}
