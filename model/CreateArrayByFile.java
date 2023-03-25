package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class CreateArrayByFile implements ICreateArray {
	private String path;
	private int size;
	private  int[][] result;
	
	public CreateArrayByFile() {
		
	}

	public CreateArrayByFile(String path) {
		this.path = path;
	}

	public CreateArrayByFile(int crSize) {
		this.size = crSize;
	}

	@Override
	public int[][] createArr() {
		int[][] resultbyFile;
		File file = new File(path);
		try {
			int index = 0;
			Scanner sc = new Scanner(file);
			resultbyFile = new int[Integer.valueOf(sc.nextLine())][];
			while (sc.hasNextLine()) {
				String[] line = sc.nextLine().split(" ");
				int[] row = new int[line.length];
				for (int i = 0; i < row.length; i++) {
					row[i] = Integer.valueOf(line[i]);
				}
				resultbyFile[index++] = row;
			}
			sc.close();
			return resultbyFile;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	
	public int[][] createArr(int crSize){
		result = new int[crSize][crSize];
		return result;
	}

	@Override
	public int[][] getResult() {
		return this.result;
	}

}
