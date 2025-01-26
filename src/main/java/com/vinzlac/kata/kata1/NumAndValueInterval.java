package com.vinzlac.kata.kata1;

import com.vinzlac.kata.kata1.ProbabilisticRandomGen.NumAndProbability;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;

public record NumAndValueInterval(int number, ValueInterval valueInterval) {
  // Constructeur
  public NumAndValueInterval {
    if (valueInterval == null) {
      throw new IllegalArgumentException("ValueInterval cannot be null.");
    }
  }

  public static List<NumAndValueInterval> of(List<NumAndProbability> numAndProbabilities) {
    return numAndProbabilities.stream()
        .collect(
            Collector.of(
                ArrayList::new,
                (result, numAndProb) -> {
                  float inclusiveMin =
                      result.isEmpty() ? 0.0f : result.getLast().valueInterval().getMax();
                  float exclusiveMax = inclusiveMin + numAndProb.getProbabilityOfSample();

                  result.add(
                      new NumAndValueInterval(
                          numAndProb.getNumber(), new ValueInterval(inclusiveMin, exclusiveMax)));
                },
                (list1, list2) -> { // Combineur pour les flux parallèles
                  throw new UnsupportedOperationException("Parallel streams are not supported.");
                }));
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;

    NumAndValueInterval that = (NumAndValueInterval) o;
    return number() == that.number() && valueInterval().equals(that.valueInterval());
  }

  @Override
  public int hashCode() {
    int result = number();
    result = 31 * result + valueInterval().hashCode();
    return result;
  }
}
