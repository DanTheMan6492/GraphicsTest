package Geometry;

public class Vector3D{
	public float x, y, z;
	
	public Vector3D() {} //variables are initialized to 0 implicitly
	public Vector3D(float x                  ) {this(x, x, x);}
	public Vector3D(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public float ind(int i) {
		switch(i) {
		case 0:
			return x;
		case 1:
			return y;
		case 2:
			return z;
		}
		return -1;
	}
	
	public float dot(Vector3D other) {
		return (this.x * other.x + this.y * other.y + this.z * other.z);
	}
	public float normal() {
		return x * x + y * y + z * z;
	}
	public float length() {
		return (float) Math.sqrt(normal());
	}
	public Vector3D add(Vector3D other) {
		return new Vector3D(this.x + other.x, this.y + other.y, this.z + other.z);
	}	
	public Vector3D subtract(Vector3D other) {
		return new Vector3D(this.x - other.x, this.y - other.y, this.z - other.z);
	}
	public Vector3D mult(float mult) {
		return new Vector3D(this.x * mult, this.y * mult, this.z*mult);
	}
	public Vector3D cross(Vector3D other) {
		return new Vector3D(this.y * other.z - this.z * other.y, 
				            this.z * other.x - this.x * other.z, 
				            this.x * other.y - this.y * other.x);
	}
	
	public Vector3D normalize() {
		float n = normal();
		if(n > 0) {
			float factor = (float) (1 / Math.sqrt(n));
			x *= factor;
			y *= factor;
			z *= factor;
		}
		return this;
	}
	
	public String toString() {
		return "(" + x + "," + y + "," + z + ")";
	}
	
	
}
