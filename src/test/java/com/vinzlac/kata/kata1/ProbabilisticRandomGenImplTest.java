package com.vinzlac.kata.kata1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.vinzlac.kata.kata1.Utils.roundDecimal;
import static org.junit.jupiter.api.Assertions.*;

class ProbabilisticRandomGenImplTest {

  @Test
  void nextFromSample() {

    // Given
    List<ProbabilisticRandomGen.NumAndProbability> numAndProbabilities = new ArrayList<>();

    final float probability1 = 0.5f;
    final float probability2 = 0.3f;
    final float probability3 = 0.2f;
    numAndProbabilities.add(new ProbabilisticRandomGen.NumAndProbability(1, probability1));
    numAndProbabilities.add(new ProbabilisticRandomGen.NumAndProbability(2, probability2));
    numAndProbabilities.add(new ProbabilisticRandomGen.NumAndProbability(3, probability3));

    ProbabilisticRandomGen gen = new ProbabilisticRandomGenImpl(numAndProbabilities);

    // When
    int[] counts = new int[4];
    int iterationCount = 100000;
    for (int i = 0; i < iterationCount; i++) {
      int num = gen.nextFromSample();
      counts[num]++;
    }

    // Then
    assertEquals(probability1, roundDecimal((float)counts[1]/iterationCount, 1));
    assertEquals(probability2, roundDecimal((float)counts[2]/iterationCount, 1));
    assertEquals(probability3, roundDecimal((float)counts[3]/iterationCount, 1));
  }
}
