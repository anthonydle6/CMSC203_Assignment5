package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class TwoDimRaggedArrayUtilityTestStudent {
    private double[][] dataSet1;
    private File inputFile, outputFile;

    @BeforeEach
    public void setUp() throws Exception {
        dataSet1 = new double[][] { { 3, 2, 1 }, { 5, 4 }, { 9, 8, 7, 6 } };
        inputFile = new File("testInput.txt");
        outputFile = new File("testOutput.txt");
        PrintWriter writer = new PrintWriter(inputFile);
        writer.println("3 2 1");
        writer.println("5 4");
        writer.println("9 8 7 6");
        writer.close();
    }

    @AfterEach
    public void tearDown() throws Exception {
        dataSet1 = null;
        inputFile.delete();
        outputFile.delete();
    }

    @Test
    public void testReadFile() throws FileNotFoundException {
        double[][] result = TwoDimRaggedArrayUtility.readFile(inputFile);
        assertArrayEquals("The file read should match the original dataset.", dataSet1, result);
    }

    private void assertArrayEquals(String string, double[][] dataSet12, double[][] result) {
		
	}

	@Test
    public void testWriteToFile() throws FileNotFoundException {
        TwoDimRaggedArrayUtility.writeToFile(dataSet1, outputFile);
        double[][] result = TwoDimRaggedArrayUtility.readFile(outputFile);
        assertArrayEquals("The file written should match the dataset.", dataSet1, result);
    }

    @Test
    public void testGetTotal() {
        double total = TwoDimRaggedArrayUtility.getTotal(dataSet1);
        assertEquals("The total of all elements should be 45.0.", 45.0, total, 0.001);
    }

    private void assertEquals(String string, double d, double total, double e) {
		
	}

	@Test
    public void testGetAverage() {
        double average = TwoDimRaggedArrayUtility.getAverage(dataSet1);
        assertEquals("The average should be 5.0.", 5.0, average, 0.001);
    }

    @Test
    public void testGetRowTotal() {
        double rowTotal = TwoDimRaggedArrayUtility.getRowTotal(dataSet1, 1);
        assertEquals("The total of row 1 should be 9.0.", 9.0, rowTotal, 0.001);
    }

    @Test
    public void testGetColumnTotal() {
        double colTotal = TwoDimRaggedArrayUtility.getColumnTotal(dataSet1, 2);
        assertEquals("The total of column 2 should be 11.0.", 11.0, colTotal, 0.001);
    }

    @Test
    public void testGetHighestInArray() {
        double highest = TwoDimRaggedArrayUtility.getHighestInArray(dataSet1);
        assertEquals("The highest value in the array should be 9.0.", 9.0, highest, 0.001);
    }

    @Test
    public void testGetLowestInArray() {
        double lowest = TwoDimRaggedArrayUtility.getLowestInArray(dataSet1);
        assertEquals("The lowest value in the array should be 1.0.", 1.0, lowest, 0.001);
    }

    @Testable
    public void testGetHighestInRow() {
        double highestInRow = TwoDimRaggedArrayUtility.getHighestInRow(dataSet1, 2);
        assertEquals("The highest value in row 2 should be 9.0.", 9.0, highestInRow, 0.001);
    }

    @Test
    public void testGetLowestInRow() {
        double lowestInRow = TwoDimRaggedArrayUtility.getLowestInRow(dataSet1, 0);
        assertEquals("The lowest value in row 0 should be 1.0.", 1.0, lowestInRow, 0.001);
    }

    @Test
    public void testGetHighestInColumn() {
        double highestInCol = TwoDimRaggedArrayUtility.getHighestInColumn(dataSet1, 1);
        assertEquals("The highest value in column 1 should be 7.0.", 7.0, highestInCol, 0.001);
    }

    @Test
    public void testGetLowestInColumn() {
        double lowestInCol = TwoDimRaggedArrayUtility.getLowestInColumn(dataSet1, 0);
        assertEquals("The lowest value in column 0 should be 1.0.", 1.0, lowestInCol, 0.001);
    }
}

