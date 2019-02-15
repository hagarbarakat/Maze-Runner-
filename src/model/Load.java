package model;

import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class Load {
	
	  private static int[][] matrix;
	    private int size = -1;
	    private int log10 = 0;
	    private String numberFormat;
	    private int health;
	    private int score;
	    private int bullets;
	    
    public Load() {
        try {
            readFile("/mazesave.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFile(String path) throws IOException {
        // If included in an Eclipse project.
        InputStream stream = ClassLoader.getSystemResourceAsStream("mazesave.txt");
        BufferedReader buffer = new BufferedReader(new InputStreamReader(stream));

        // If in the same directory - Probably in your case...
        // Just comment out the 2 lines above this and uncomment the line
        // that follows.
        //BufferedReader buffer = new BufferedReader(new FileReader(filename));

        String line;
        int row = 0;

        while ((line = buffer.readLine()) != null) {
            String[] vals = line.trim().split(",");

            // Lazy instantiation.
            if (matrix == null) {
                size = vals.length;
                matrix = new int[size][size];
                log10 = (int) Math.floor(Math.log10(size * size)) + 1;
                numberFormat = String.format("%%%dd", log10);
            }

            for (int col = 0; col < 900; col++) {
            	//try {
            	System.out.println((vals[col])+"-"+col);
                matrix[row][col] = Integer.parseInt(vals[col]);
            //}catch(Exception e) {            	System.out.println((-1));}

            }
            row++;
        }
    }

    @Override
    public String toString() {
        StringBuffer buff = new StringBuffer();

        if (matrix != null) {
            for (int row = 0; row < 30; row++) {
                buff.append("{");
                for (int col = 0; col < 30; col++) {
                    buff.append(String.format(numberFormat,  matrix[row][col]));
                    if (col < size - 1) {
                        buff.append(",");
                    }
                }
                buff.append("}");
                buff.append(",");
                buff.append("\n");
                
               /* if (row < size - 1) {
                    buff.append("\n");
                    for (int col = 0; col < size; col++) {
                        for (int i = 0; i <= log10 + 1; i++) {
                            buff.append("-");
                        }
                        if (col < size - 1) {
                            buff.append("+");
                        }
                    }
                    buff.append("\n");
                } else {
                    buff.append("\n");
                }*/
            }
            buff.append(String.format(numberFormat,health));
            
            buff.append("\n");
            buff.append(String.format(numberFormat,score));
            buff.append("\n");
            buff.append(String.format(numberFormat,bullets));
            buff.append("\n");
        }
    

        return buff.toString();
    }

   public static int [][] getMaze(){
	   
	   return matrix;
   }

	public void loadfile() throws IOException {
		File file = new File("mazesave.txt");
		 
		  BufferedReader br = new BufferedReader(new FileReader(file));
		 
		  String st;
		  while ((st = br.readLine()) != null)
		    System.out.println(st);
		  }
		
	
public static void main(String []args)
{
	Load l=new Load();
	try {
		l.readFile("mazesave.txt");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	for(int i=0;i<30;i++) {
		for(int j=0;j<30;j++)
			System.out.println(" "+getMaze()[i][j]);
	
	System.out.println("");
	}
	
}


}