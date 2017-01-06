package ua.edu.ucu.tempseries;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Arrays;
import java.util.InputMismatchException;

public class TemperatureSeriesAnalysisTest {

    @Test
    public void testAverageWithOneElementArray() {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;

        // call tested method
        double actualResult = seriesAnalysis.average();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAverageWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.average();
    }

    @Test
    public void testAverage() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 1.0;

        double actualResult = seriesAnalysis.average();
        
        assertEquals(expResult, actualResult, 0.00001);        
    }

    @Test
    public void testDeviationWithOneElementArray() {
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 0.0;

        double actualResult = seriesAnalysis.deviation();
        assertEquals(expResult, actualResult, 0.0001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeviationWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        seriesAnalysis.deviation();
    }

    @Test
    public void testFindTempsGreaterThan1() {
        double[] temperatureSeries = {-3.0, -1.0, 2.0, 137.5, 228, 388, 843};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {};
        double[] actualResult = seriesAnalysis.findTempsGreaterThen(10000);
        assertEquals(Arrays.toString(expResult), Arrays.toString(actualResult));
    }

    @Test
    public void testFindTempsGreaterThan2() {
        double[] temperatureSeries = {-3.0, -1.0, 2.0, 137.5, 228, 388, 843};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {-3.0, -1.0, 2.0, 137.5, 228, 388, 843};
        double[] actualResult = seriesAnalysis.findTempsGreaterThen(-4);
        assertEquals(Arrays.toString(expResult), Arrays.toString(actualResult));
    }

    @Test
    public void testFindTempClosestToZero() {
        double[] temperatureSeries = {5.0, 11.0, 16.0, 23.0, 25.0, -0.2, 0.2};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 0.2;

        double actualResult = seriesAnalysis.findTempClosestToZero();

        assertEquals(expResult, actualResult, 0.1);
    }
    @Test
    public void testFindTempClosestToZeroWithOneElementArray() {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;

        // call tested method
        double actualResult = seriesAnalysis.findTempClosestToZero();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindTempClosestToZeroWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.findTempClosestToZero();
    }

    @Test
    public void testFindTempClosestToValue() {
        double[] temperatureSeries = {5.0, 11.0, 16.0, 23.0, 25.0, -0.2, 0.2, 2.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 2.0;

        double actualResult = seriesAnalysis.findTempClosestToValue(3.0);

        assertEquals(expResult, actualResult, 0.1);
    }

    @Test
    public void testGetAvgTemp() {
        TempSummaryStatistics seriesAnalysis = new TempSummaryStatistics(1.0, 2.0, 3.0, 4.0);
        double expResult = 1.0;
        double actualResult = seriesAnalysis.getAvgTemp();
        assertEquals(expResult, actualResult, 0.1);
    }

    @Test
    public void testGetDevTemp() {
        TempSummaryStatistics seriesAnalysis = new TempSummaryStatistics(1.0, 2.0, 3.0, 4.0);
        double expResult = 2.0;
        double actualResult = seriesAnalysis.getDevTemp();
        assertEquals(expResult, actualResult, 0.1);
    }

    @Test
    public void testGetMinTemp() {
        TempSummaryStatistics seriesAnalysis = new TempSummaryStatistics(1.0, 2.0, 3.0, 4.0);
        double expResult = 3.0;
        double actualResult = seriesAnalysis.getMinTemp();
        assertEquals(expResult, actualResult, 0.1);
    }

    @Test
    public void testGetMaxTemp() {
        TempSummaryStatistics seriesAnalysis = new TempSummaryStatistics(1.0, 2.0, 3.0, 4.0);
        double expResult = 4.0;
        double actualResult = seriesAnalysis.getMaxTemp();
        assertEquals(expResult, actualResult, 0.1);
    }

}
