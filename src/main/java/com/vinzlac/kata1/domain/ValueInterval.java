package com.vinzlac.kata1.domain;

public class ValueInterval {
	private final float inclusiveMin;
	private final float exclusiveMax;

	// Constructeur
	public ValueInterval(float inclusiveMin, float exclusiveMax) {
		if (inclusiveMin > exclusiveMax) {
			throw new IllegalArgumentException("min cannot be greater than max.");
		}
		this.inclusiveMin = inclusiveMin;
		this.exclusiveMax = exclusiveMax;
	}

	// Getters
	public float getMin() {
		return inclusiveMin;
	}

	public float getMax() {
		return exclusiveMax;
	}

	// Méthode pour vérifier si une valeur est dans l'intervalle
	public boolean contains(float value) {
		return value >= inclusiveMin && value < exclusiveMax;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) return false;

		ValueInterval that = (ValueInterval) o;
		return Float.compare(getMin(), that.getMin()) == 0 && Float.compare(getMax(), that.getMax()) == 0;
	}

	@Override
	public int hashCode() {
		int result = Float.hashCode(getMin());
		result = 31 * result + Float.hashCode(getMax());
		return result;
	}
}
