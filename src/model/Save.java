package model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Save {
public Save() {
	// TODO Auto-generated constructor stub
}
	static StringBuilder builder = new StringBuilder();
	private static BufferedWriter bw = null;
	public void savefile(int [][] maze, int health, int score, int bullets) {
		try {
			bw = new BufferedWriter(new FileWriter("mazesave.txt"));
			
			for (int i = 0; i < 30; i++) {
				
				for(int j=0; j<30;j++) {
				bw.write(Integer.toString(maze[i][j]));
				bw.write(",");
				
				}
					
			
			}
			
			bw.write("\n");
			bw.write(Integer.toString(health));
			bw.write("\n");
			bw.write(Integer.toString(score));
			bw.write("\n");
			bw.write(Integer.toString(bullets));
			bw.write("\n");
			bw.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
