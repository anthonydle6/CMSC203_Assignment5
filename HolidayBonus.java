package application;

public class HolidayBonus 
{

    // constants bonus amounts
	
	//highest amount sold in the category 
    private static final double HIGH_BONUS = 5000.0;
    
    //all other retail stores excluding high & low 
    private static final double MEDIUM_BONUS = 2000.0;
    
    //lowest amount sold in a category 
    private static final double LOW_BONUS = 1000.0;

    // default constructor
    public HolidayBonus() 
    {
    	
    }

    public static double[] calculateHolidayBonus(double[][] data) 
    {
        double[] bonuses = new double[data.length];

        for (int i = 0; i < data.length; i++) 
        {
            double bonus = 0.0;

            for (int j = 0; j < data[i].length; j++) 
            {
                if (data[i][j] > 0) 
                {
                    // check highest val in column
                    if (isHighestInColumn(data, j, i)) 
                    {
                        bonus += HIGH_BONUS;
                    }
                    // check lowest val in column
                    else if (isLowestInColumn(data, j, i)) 
                    {
                        bonus += LOW_BONUS;
                    } else {
                        bonus += MEDIUM_BONUS;
                    }
                }
            }

            bonuses[i] = bonus;
        }

        return bonuses;
    }

    public static double calculateTotalHolidayBonus(double[][] data) 
    {
        double totalBonus = 0.0;
        double[] bonuses = calculateHolidayBonus(data);

        for (double bonus : bonuses) 
        {
            totalBonus += bonus;
        }

        return totalBonus;
    }

    private static boolean isHighestInColumn(double[][] data, int col, int row) 
    {
        double value = data[row][col];

        for (int i = 0; i < data.length; i++) {
            if (i != row && col < data[i].length && data[i][col] > value) 
            {
                return false;
            }
        }

        return true;
    }

    private static boolean isLowestInColumn(double[][] data, int col, int row) 
    {
        double value = data[row][col];

        for (int i = 0; i < data.length; i++) 
        {
            if (i != row && col < data[i].length && data[i][col] < value && data[i][col] > 0) 
            {
                return false;
            }
        }

        return true;
    }

	public static double[] calculateHolidayBonus(double[][] sales, int i, int j, int k) 
	{
		return null;
	}

	public static double calculateTotalHolidayBonus(double[][] sales, int i, int j, int k) 
	{
		return 0;
	}
}
