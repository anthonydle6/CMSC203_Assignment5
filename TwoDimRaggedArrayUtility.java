package application;
/*
 * Class: CMSC203 
 * Instructor: Huseyin Aygun
 * Description: Assignment 5 HolidayBonus
 * Due: 11/18/2024
 * Platform/compiler:
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: Anthony Le
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TwoDimRaggedArrayUtility 
{

    // pass file 
	//return two dim ragged array double
    public static double[][] readFile(File file) throws FileNotFoundException 
    {
        Scanner scanner = new Scanner(file);
        StringBuilder fileContent = new StringBuilder();

        while (scanner.hasNextLine()) 
        {
            fileContent.append(scanner.nextLine()).append("\n");
        }
        scanner.close();

        String[] lines = fileContent.toString().split("\n");
        double[][] array = new double[lines.length][];

        for (int i = 0; i < lines.length; i++) 
        {
            String[] values = lines[i].split(" ");
            array[i] = new double[values.length];
            for (int j = 0; j < values.length; j++) 
            {
                array[i][j] = Double.parseDouble(values[j]);
            }
        }

        return array;
    }

    // pass in a two dim ragged array of double 
    // write ragged array into file 
    //separate line and double is separated by space
    public static void writeToFile(double[][] data, File file) throws FileNotFoundException 
    {
        PrintWriter writer = new PrintWriter(file);

        for (double[] row : data) 
        {
            for (int j = 0; j < row.length; j++) 
            {
                writer.print(row[j]);
                if (j < row.length - 1) writer.print(" ");
            }
            writer.println();
        }

        writer.close();
    }

    // pass two dim ragged array 
    //return total of elements
    public static double getTotal(double[][] data) 
    {
        double total = 0.0;

        for (double[] row : data) 
        {
            for (double value : row) 
            {
                total += value;
            }
        }

        return total;
    }

    // pass two dim ragged array 
    //return avg of elements 
    public static double getAverage(double[][] data) 
    {
        int count = 0;
        double total = getTotal(data);

        for (double[] row : data) 
        {
            count += row.length;
        }

        return total / count;
    }

    // pass two dim ragged array 
    //return total of row 
    public static double getRowTotal(double[][] data, int row) 
    {
        double total = 0.0;

        if (row >= 0 && row < data.length) 
        {
            for (double value : data[row]) 
            {
                total += value;
            }
        }

        return total;
    }

    // pass two dim ragged array 
    //return total of col
    public static double getColumnTotal(double[][] data, int col) 
    {
        double total = 0.0;

        for (double[] row : data) 
        {
            if (col < row.length) 
            {
                total += row[col];
            }
        }

        return total;
    }

    // pass two dim ragged array 
    //returns largest element of row 
    public static double getHighestInRow(double[][] data, int row) 
    {
        double highest = Double.NEGATIVE_INFINITY;

        if (row >= 0 && row < data.length) 
        {
            for (double value : data[row]) 
            {
                if (value > highest) 
                {
                    highest = value;
                }
            }
        }

        return highest;
    }

    // pass two dim ragged array 
    //returns index of largest element in row
    public static int getHighestInRowIndex(double[][] data, int row) 
    {
        int index = -1;
        double highest = Double.NEGATIVE_INFINITY;

        if (row >= 0 && row < data.length) 
        {
            for (int i = 0; i < data[row].length; i++) 
            {
                if (data[row][i] > highest) 
                {
                    highest = data[row][i];
                    index = i;
                }
            }
        }

        return index;
    }

     // pass two dim ragged array 
     //returns smallest element of row 
    public static double getLowestInRow(double[][] data, int row) 
    {
        double lowest = Double.POSITIVE_INFINITY;

        if (row >= 0 && row < data.length) 
        {
            for (double value : data[row]) 
            {
                if (value < lowest) {
                    lowest = value;
                }
            }
        }

        return lowest;
    }

    // pass two dim ragged array 
    //returns index of smallest element in row
    public static int getLowestInRowIndex(double[][] data, int row) 
    {
        int index = -1;
        double lowest = Double.POSITIVE_INFINITY;

        if (row >= 0 && row < data.length) 
        {
            for (int i = 0; i < data[row].length; i++) 
            {
                if (data[row][i] < lowest) 
                {
                    lowest = data[row][i];
                    index = i;
                }
            }
        }

        return index;
    }

    //pass two dim array
    //returns highest element in col 
    public static double getHighestInColumn(double[][] data, int col) 
    {
        double highest = Double.NEGATIVE_INFINITY;

        for (double[] row : data) 
        {
            if (col < row.length && row[col] > highest) 
            {
                highest = row[col];
            }
        }

        return highest;
    }

    //pass two dim array
    //returns index of highest element in col
    public static int getHighestInColumnIndex(double[][] data, int col) 
    {
        int index = -1;
        double highest = Double.NEGATIVE_INFINITY;

        for (int i = 0; i < data.length; i++) 
        {
            if (col < data[i].length && data[i][col] > highest) 
            {
                highest = data[i][col];
                index = i;
            }
        }

        return index;
    }

    //pass two dim array
    //returns smallest element in col
    public static double getLowestInColumn(double[][] data, int col) 
    {
        double lowest = Double.POSITIVE_INFINITY;

        for (double[] row : data) 
        {
            if (col < row.length && row[col] < lowest) 
            {
                lowest = row[col];
            }
        }

        return lowest;
    }

    //pass two dim array
    //returns index of smallest element in col
    public static int getLowestInColumnIndex(double[][] data, int col) 
    {
        int index = -1;
        double lowest = Double.POSITIVE_INFINITY;

        for (int i = 0; i < data.length; i++) 
        {
            if (col < data[i].length && data[i][col] < lowest) 
            {
                lowest = data[i][col];
                index = i;
            }
        }

        return index;
    }

    //pass two dim array
    //returns largest element in array
    public static double getHighestInArray(double[][] data)
    {
        double highest = Double.NEGATIVE_INFINITY;

        for (double[] row : data) 
        {
            for (double value : row) 
            {
                if (value > highest) 
                {
                    highest = value;
                }
            }
        }

        return highest;
    }

    //pass two dim array
    //returns smallest element in array
    public static double getLowestInArray(double[][] data) 
    {
        double lowest = Double.POSITIVE_INFINITY;

        for (double[] row : data) 
        {
            for (double value : row) 
            {
                if (value < lowest) 
                {
                    lowest = value;
                }
            }
        }

        return lowest;
    }
}
