/* 
 * This class contains simple mathematics operations
 * That only use and return int variables (without decimal)
 */

class mathematics {
	
	public enum Mode {
		Radians, 
		Degree;
		}
	
	public static int Add(int a,int b){
		return a + b;
	}
	
	public static int Subtract(int a, int b){
		return a - b;
	}
	
	public static int Multiply(int a, int b){
		return a * b;
	}
	
	public static double Sin(int a, Mode mod){
		if(mod == Mode.Radians){
			return Math.sin(a);
		}
		else{
			return Math.sin(a * (Math.PI / 180));
		}
	}
	public static double Cos(int a, Mode mod){
		if (mod == Mode.Radians){
			return Math.cos(a);
		}
		else{
			return Math.cos(a * (Math.PI / 180));
		}
	}
	public static double Tan(int a, Mode mod){
		if(mod == Mode.Radians){
			return Math.tan(a);
		}
		else{
			return Math.tan(a * (Math.PI / 180));
		}
	}
}
