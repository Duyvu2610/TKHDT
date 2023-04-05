package model;

import java.awt.Point;

public class Vertex {
	private String name;
	private Point location;

	public Vertex(String name, Point location) {
		this.name = name;
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public Point getLocation() {
		return location;
	}

	@Override
	public String toString() {
		return "Vertex [name=" + name + ", location=" + location + "]";
	}
	
}
