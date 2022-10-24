package Geometry;

public class Matrix44 {
	float x[][] = {{1,0,0,0},{0,1,0,0},{0,0,1,0},{0,0,0,1}};
	public Matrix44() {}
	public Matrix44(float a, float b, float c, float d,
					float e, float f, float g, float h,
					float i, float j, float k, float l,
					float m, float n, float o, float p) {
		x[0][0] = a; 
        x[0][1] = b; 
        x[0][2] = c; 
        x[0][3] = d; 
        x[1][0] = e; 
        x[1][1] = f; 
        x[1][2] = g; 
        x[1][3] = h; 
        x[2][0] = i; 
        x[2][1] = j; 
        x[2][2] = k; 
        x[2][3] = l; 
        x[3][0] = m; 
        x[3][1] = n; 
        x[3][2] = o; 
        x[3][3] = p; 
	}
	
	Matrix44 multiply(Matrix44 other) {
		Matrix44 result = new Matrix44();
		multiply(this, other, result);
		return result;
	}
	
	static void multiply(Matrix44 a, Matrix44 b, Matrix44 c) {
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				c.x[i][j] = a.x[i][0] * b.x[0][j] + a.x[i][1] * b.x[1][j] + a.x[i][2] * b.x[2][j] + a.x[i][3] * b.x[3][j];
			}
		}
	}
	
	Matrix44 transposed() {
		Matrix44 result = new Matrix44();
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				result.x[i][j] = x[j][i];
			}
		}
		return result;
	}
	

}
