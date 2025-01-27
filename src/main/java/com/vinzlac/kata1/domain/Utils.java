package com.vinzlac.kata1.domain;

public class Utils {
  public static float roundDecimal(float value, int decimalPlaces) {
    float scale = (float) Math.pow(10, decimalPlaces);
    return Math.round(value * scale) / scale;
  }
}
