package com.vinzlac.kata.kata1;

import com.vinzlac.kata.kata1.ProbabilisticRandomGen.NumAndProbability;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {

		List<NumAndProbability> numAndProbabilities = new ArrayList<>();
		numAndProbabilities.add(new NumAndProbability(1, 0.5f));
		numAndProbabilities.add(new NumAndProbability(2, 0.3f));
		numAndProbabilities.add(new NumAndProbability(3, 0.2f));

		ProbabilisticRandomGen gen = new ProbabilisticRandomGenImpl(numAndProbabilities);

		int[] counts = new int[4]; // To count occurrences of numbers 1, 2, and 3
		int iterationCount = 100000;
		for (int i = 0; i < iterationCount; i++) {
			int num = gen.nextFromSample();
			counts[num]++;
		}

		System.out.println("Number 1: " + counts[1]);
		System.out.println("Number 2: " + counts[2]);
		System.out.println("Number 3: " + counts[3]);
	}
}