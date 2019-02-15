package model;
import java.io.*;
import java.util.*;

public class LoadData {
	static int[][] matrix ;
		public static int [][] loadData()
		{
			matrix = new int[1000][1000];
			int x=0, y=0;
			try
	        {
			BufferedReader in = new BufferedReader(new FileReader("mazesave.txt"));	//reading files in specified directory
				String line;
				while ((line = in.readLine()) != null)	//file reading
				{
					String[] values = line.split(",");
		        	for (String str : values)
		        	{
		        		int str_double = Integer.parseInt(str);
		        		matrix[x][y]=str_double;
		        		System.out.println(matrix[x][y]);
		        	}
		        	y=y+1;
				}
				x=x+1;
	        	in.close();
	        }catch( IOException ioException ) {}
			return matrix;
		}
	}

