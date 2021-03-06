package hw3;

class IntersectionNode {
	
	private String vertex;
	private String street;  //name of the street
	private IntersectionNode edge;
	private String dir;     //direction
	private String dist;    //distance
	private int speed;
	
	IntersectionNode(String vertex) {
		this.vertex = vertex;
	}
	
	String getVertex() {
		return vertex;
	}
	
	String getStreet() {
		return street;
	}
	
	void setStreet(String street) {
		this.street = street;
	}
	
	IntersectionNode getEdge() {
		return edge;
	}
	
	void setEdge(IntersectionNode edge) {
		this.edge = edge;
	}
	
	String getDir() {
		return dir;
	}
	
	void setDir(String dir) {
		this.dir = dir;
	}
	
	public String getDist() {
		return dist;
	}
	
	void setDist(String dist) {
		this.dist = dist;
	}
	
	int getSpeed() {
		return speed;
	}
	
	void setSpeed(int speed) {
		this.speed = speed;
	}
	
	@Override
	public String toString() {
		return String.format("%-25s%-20s%-25s%-15s%-10s%d", vertex, street,
				edge, dir, dist, speed);
	}
}
