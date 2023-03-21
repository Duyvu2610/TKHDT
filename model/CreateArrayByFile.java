package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class CreateArrayByFile implements ICreateArray{
    private String path;
    
    public CreateArrayByFile(String path) {
        this.path = path;
    }

    @Override
    public int[][] createArr() {
        int[][] result;
        File file = new File(path);
		try {
			int index = 0;
			Scanner sc = new Scanner(file);
			result = new int[Integer.valueOf(sc.nextLine())][];
			while (sc.hasNextLine()) {
				String[] line = sc.nextLine().split(" ");
				int[] row = new int[line.length];
				for (int i = 0; i < row.length; i++) {
					row[i] = Integer.valueOf(line[i]);
				}
				result[index++] = row;
			}
			sc.close();
            return result;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
        return null;
    }
    
}
