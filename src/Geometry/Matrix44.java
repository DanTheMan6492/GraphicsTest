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
	
	public Matrix44 multiply(Matrix44 other) {
		Matrix44 result = new Matrix44();
		multiply(this, other, result);
		return result;
	}
	
	public static void multiply(Matrix44 a, Matrix44 b, Matrix44 c) {
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				c.x[i][j] = a.x[i][0] * b.x[0][j] + a.x[i][1] * b.x[1][j] + a.x[i][2] * b.x[2][j] + a.x[i][3] * b.x[3][j];
			}
		}
	}
	
	public Matrix44 transposed() {
		Matrix44 result = new Matrix44();
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				result.x[i][j] = x[j][i];
			}
		}
		return result;
	}
	
	public Vector3D multVecMatrix(Vector3D src) {
		
		float a, b, c, w;
		
		a = src.x * x[0][0] + src.y * x[1][0] + src.z * x[2][0] + x[3][0];
		b = src.x * x[0][1] + src.y * x[1][1] + src.z * x[2][1] + x[3][1];
		c = src.x * x[0][2] + src.y * x[1][2] + src.z * x[2][2] + x[3][2];
		w = src.x * x[0][3] + src.y * x[1][3] + src.z * x[2][3] + x[3][3];
		
		return new Vector3D(a/w, b/w, c/w);
	}
	
	public Vector3D multDirMatrix(Vector3D src) {
		
		float a, b, c;
		
		a = src.x * x[0][0] + src.y * x[1][0] + src.z * x[2][0];
		b = src.x * x[0][1] + src.y * x[1][1] + src.z * x[2][1];
		c = src.x * x[0][2] + src.y * x[1][2] + src.z * x[2][2];
		
		return new Vector3D(a, b, c);
	}
	
	public Matrix44 inverse() {
		Matrix44 s = new Matrix44();
		Matrix44 t = this.copy();
		
		for(int i = 0; i < 3; i++) {
			int pivot = i;
			float pSize = t.x[i][i];
			
			if(pSize < 0) pSize *= -1;
			
			for(int j = i + 1; j < 4; j++) {
				float tmp = t.x[j][i];
				
				if(tmp < 0) tmp *= -1;
				
				if(tmp > pSize) {
					pivot = j;
					pSize = tmp;
				}
			}
			
			if(pSize == 0) return null;
			
			if(pivot != i) {
				for(int j = 0; j < 4; j++) {
					float tmp;
					
					tmp = t.x[i][j];
					t.x[i][j] = t.x[pivot][j];
					t.x[pivot][j] = tmp;
					
					tmp = s.x[i][j];
					s.x[i][j] = s.x[pivot][j];
					s.x[pivot][j] = tmp;
				}
			}
			
			for (int j = i + 1; j < 4; j++) { 
                float f = t.x[j][i] / t.x[i][i]; 
 
                for (int k = 0; k < 4; k++) { 
                    t.x[j][k] -= f * t.x[i][k]; 
                    s.x[j][k] -= f * s.x[i][k]; 
                } 
            } 
		}
		
		for(int i = 3; i >= 0; i--) {
			float f = t.x[i][i];
			
			if(f == 0) return null;
			
			for(int j = 0; j < 4; j++) {
				t.x[i][j] /= f;
				s.x[i][j] /= f;
			}
			
			for(int j = 0; j < i; j++) {
				f = t.x[j][i];
				
				for(int k = 0; k < 4; k++) {
					t.x[j][k] -= f * t.x[i][k];
					s.x[j][k] -= f * s.x[i][k];
				}
			}
		}
		
		return s;
	}
	
	public String toString() {
		String s = "";
		s +=  String.format("%.2f", x[0][0]) + " " + String.format("%.2f", x[0][1]) + " " + String.format("%.2f", x[0][2]) + " " + String.format("%.2f", x[0][3]) + "\n";
		s +=  String.format("%.2f", x[1][0]) + " " + String.format("%.2f", x[1][1]) + " " + String.format("%.2f", x[1][2]) + " " + String.format("%.2f", x[1][3]) + "\n";
		s +=  String.format("%.2f", x[2][0]) + " " + String.format("%.2f", x[2][1]) + " " + String.format("%.2f", x[2][2]) + " " + String.format("%.2f", x[2][3]) + "\n";
		s +=  String.format("%.2f", x[3][0]) + " " + String.format("%.2f", x[3][1]) + " " + String.format("%.2f", x[3][2]) + " " + String.format("%.2f", x[3][3]) + "\n";
		return s;
	}
	public Matrix44 copy() {
		return new Matrix44(x[0][0], x[0][1], x[0][2], x[0][3],
							x[1][0], x[1][1], x[1][2], x[1][3],
							x[2][0], x[2][1], x[2][2], x[2][3],
							x[3][0], x[3][1], x[3][2], x[3][3]);
	}

}
