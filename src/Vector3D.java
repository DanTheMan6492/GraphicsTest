
public class Vector3D{
	public float x, y, z;
	
	public Vector3D(                         ) {} //variables are initialized to 0 implicitly
	public Vector3D(float x                  ) {this(x, x, x);}
	public Vector3D(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
		
	}
	
	public Vector3D add     (Vector3D other) {return new Vector3D(this.x + other.x,  this.y + other.y,  this.z + other.z);}	
	public Vector3D subtract(Vector3D other) {return new Vector3D(this.x - other.x,  this.y - other.y,  this.z - other.z);}
	public Vector3D mult    (float mult    ) {return new Vector3D(this.x * mult   ,  this.y * mult   ,  this.z*mult);     }
	public float    dot     (Vector3D other) {return             (this.x * other.x + this.y * other.y + this.z * other.z);}
	public Vector3D cross   (Vector3D other) {return new Vector3D(y * other.z - z * other.y, z * other.x - x * other.z, x * other.y - y * other.x);}
}
