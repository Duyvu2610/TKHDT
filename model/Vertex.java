package model;

import java.awt.Point;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class Vertex {
	private String name;
	private Point location;
	public final int R = 20;

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

	@Override
	public int hashCode() {
		return Objects.hash(location, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vertex other = (Vertex) obj;
		return Objects.equals(location, other.location) && Objects.equals(name, other.name);
	}

	public boolean isClickAt(Point point) {
		return ((point.x > location.x && point.x < location.x + R*2)
		&& (point.y > location.y && point.y < location.y + R*2));
	}

	
}
