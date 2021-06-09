package com.project;

public class RoundToTwo
{
    public static double roundTo2DecimalPlace(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
}