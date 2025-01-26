package com.vinzlac.kata.kata1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProbabilisticRandomGenImpl implements ProbabilisticRandomGen {
	final private Random random = new Random();
	final private List<NumAndValueInterval> numAndValueIntervals;
	public ProbabilisticRandomGenImpl(List<NumAndProbability> numAndProbabilities) {


		if (numAndProbabilities == null || numAndProbabilities.isEmpty()) {
			throw new IllegalArgumentException("Sample list cannot be null or empty!");
		}

		final float totalProbability = numAndProbabilities.stream()
				.map(ProbabilisticRandomGen.NumAndProbability::getProbabilityOfSample)
				.reduce(0.0f, Float::sum);


		if (totalProbability != 1) {
			throw new IllegalArgumentException("Probability total sum must be equal to 1");
		}

		numAndValueIntervals = NumAndValueInterval.of(numAndProbabilities);
	}

	@Override
	public int nextFromSample() {
		float randomFloat = random.nextFloat();

		return numAndValueIntervals
				.stream()
				.filter(x -> x.valueInterval().contains(randomFloat))
				.findFirst()
				.map(NumAndValueInterval::number)
				.get();
	}
}
