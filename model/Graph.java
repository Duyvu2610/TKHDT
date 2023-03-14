package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Graph {
	
	private int[][] matrix;

	public Graph() {
	}

	public Graph(String path) {
		loadFile(path);
	}

	public void loadFile(String path) {
		File file = new File(path);
		try {
			int index = 0;
			Scanner sc = new Scanner(file);
			matrix = new int[Integer.valueOf(sc.nextLine())][];
			while (sc.hasNextLine()) {
				String[] line = sc.nextLine().split(" ");
				int[] row = new int[line.length];
				for (int i = 0; i < row.length; i++) {
					row[i] = Integer.valueOf(line[i]);
				}
				matrix[index++] = row;
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public int[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}

	public int[] bellmanFordSearch(int root) {

		int size = matrix.length;
		int[] result = new int[size];
		int[] pathCostOfNode = new int[size];

		// initial pathcost of all node (root node is 0, another is MAX_VALUE)
		for (int i = 0; i < size; i++) {
			pathCostOfNode[i] = (i == root) ? 0 : Integer.MAX_VALUE;
		}

		// loop through all node
		for (int numNode = 1; numNode <= size; numNode++) {

			// loop through all edge the graph has
			for (int row = 0; row < size; row++) {
				for (int col = 0; col < size; col++) {
					int edge = matrix[row][col];

					// check if is edge
					if (edge != 0) {
						int beginNode = row;
						int endNode = col;
						int pathCostBeginNode = pathCostOfNode[beginNode];
						int pathCostEndNode = pathCostOfNode[endNode];
						int pathCostwillChange = pathCostBeginNode + edge;

						if (pathCostwillChange < pathCostEndNode) {
							// check negative cycle exists
							if (numNode == size) {
								return null;
							}
							pathCostOfNode[endNode] = pathCostwillChange;
							result[endNode] = beginNode;
						}
					}
				}
			}
		}
		return result;
	}

	public int[] bellmanFordSearchUtils(int root, int goal) {
		StringBuffer resReverseStr = new StringBuffer("");
		int[] listParentNode = bellmanFordSearch(root);
		int[] result = null;
		int index = 0;
		if (listParentNode != null) {

			int currentNode = goal;
			do {
				resReverseStr.append( currentNode + " " );
				currentNode = listParentNode[currentNode];
				if (currentNode == root) {
					resReverseStr.append( currentNode + " " );
				}
			} while (currentNode != root);
			
			String[] resStr = resReverseStr.reverse().substring(1).split(" ");
			result = new int[resStr.length];
			for (String character: resStr) {
				result[index++] = Integer.valueOf(character);
			}
		}
		return result; 

	}

	public static void main(String[] args) {
		String fileName = "D:\\Work space\\TKHDT\\test.txt";
		Graph graph = new Graph(fileName);
		System.out.println(Arrays.deepToString(graph.getMatrix()));
	}

}
