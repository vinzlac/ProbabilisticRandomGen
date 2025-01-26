package com.vinzlac.kata.kata1;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class NumAndValueIntervalTest {


	@Test
	void testOfWithValidProbabilities() {
		List<ProbabilisticRandomGen.NumAndProbability> input = List.of(
				new ProbabilisticRandomGen.NumAndProbability(1, 0.5f),
				new ProbabilisticRandomGen.NumAndProbability(2, 0.3f),
				new ProbabilisticRandomGen.NumAndProbability(3, 0.2f)
		);

		List<NumAndValueInterval> result = NumAndValueInterval.of(input);

		assertEquals(3, result.size(), "La taille du résultat doit être de 3.");
		assertEquals(0.0f, result.get(0).valueInterval().getMin());
		assertEquals(0.5f, result.get(0).valueInterval().getMax());

		assertEquals(0.5f, result.get(1).valueInterval().getMin());
		assertEquals(0.8f, result.get(1).valueInterval().getMax());

		assertEquals(0.8f, result.get(2).valueInterval().getMin());
		assertEquals(1.0f, result.get(2).valueInterval().getMax());
	}
}