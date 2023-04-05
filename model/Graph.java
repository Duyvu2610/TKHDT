package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import view.MatrixView;

public class Graph{
	// 1 graph se bao gom cac dinh va cac canh tuong ung cua no
	private Map<Vertex, List<Edge>> adjacencyList;
	private int[][] adjacencyMatrix;


	// khoi tao graph
	public Graph() {
		this.adjacencyList = new HashMap<>();
		this.adjacencyMatrix = new int[0][0];
	}
	// them 1 dinh
	public void addVertex(Vertex vertex) {
		adjacencyList.put(vertex, new ArrayList<>());
		setAdjacencyMatrix();
		
	}
	// them 1 canh
	public void addEdge(Vertex source, Vertex destination, int weight) {
		Edge edge = new Edge(source, destination, weight);
		adjacencyList.get(source).add(edge);
		adjacencyList.get(destination).add(edge);
	}

	public List<Edge> getEdges(Vertex vertex) {
		return adjacencyList.get(vertex);
	}

	public Map<Vertex, List<Edge>> getAdjacencyList() {
		return adjacencyList;
	}
	public ArrayList<Vertex> getVertices() {
		return new ArrayList<>(adjacencyList.keySet());
	}
	public void setAdjacencyMatrix() {
		int size = adjacencyList.size();
		adjacencyMatrix = new int[size][size];
	}
	public int[][] getAdjacencyMatrix() {
		return adjacencyMatrix;
	}

	
	

}
