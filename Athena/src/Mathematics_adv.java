import javax.swing.JTextPane;


public class Mathematics_adv {
	
	public Mode curr_mode = Mode.Degree;
	public boolean use_sigfigs = false;
	

	private JTextPane txt;
	
	public Mathematics_adv(JTextPane work)
	{
		txt = work;
	}
	
	public enum Operation
	{
		Multiplication,
		Addition,
		Subtraction,
		Division;
	}
	
	public int Count_Decimals(String a)
	{
		return a.length() - a.indexOf('.') - 1;
	}
	
	public int Count_SigFig(String a)
	{
		//Find the Decimal in the equation
		int decimal = a.indexOf('.');
		
		//How many digits after the decimal Count them all
		int sigfig =  a.length() - (decimal + 1);
		
		//Digits to the left of the decimal
		for(int i = decimal -1; i > - 1; i++){
			if (a.charAt(i) != '0'){
				//The number is a sig fig add to count
				sigfig += i;
				break;
			}
		}
		
		return sigfig;
	}
	
	//DONE: Currently does not work for non-decimal values
	/*
	 * ===================== Working Function =====================
	 * 
	 * =============== DO NOT MODIFY THIS FUNCTION ===============
	 */
	public int Cal_SigFig(String a, String b, Operation operation)
	{
		//Check what kind of operation is being performed
		switch(operation)
		{
			//If it's a Multiplication or Division
			case Multiplication:
			case Division:
			{
				/*Find the index of the decimal place
				 * Example
				 * 		123.04 The index of the decimal is 3
				 * All indexs are
				 * Index = I Value = V
				 * 
				 * I   V
				 * 0 = 1
				 * 1 = 2
				 * 2 = 3
				 * 3 = .
				 * 4 = 0
				 * 5 = 4
				 */
				int decimal_a = a.indexOf('.');
				int decimal_b = b.indexOf('.');
				
				//Find out how many places there are after the decimal
				int places_a =  a.length() - (decimal_a + 1);
				int places_b =  b.length() - (decimal_b + 1);
				
				//The amount of Sig figs to be calculated
				int sigfig_a = places_a;
				int sigfig_b = places_b;
				
				/*
				 * =============== Calculations for Value 'a' ===============
				 */
				
				//Count how many Significant Figures there are to the left of the decimal point
				for(int i = decimal_a - 1; i > -1; i--)
				{
					if (a.charAt(i) != '0')
					{
						sigfig_a += i + 1;
						break;
					}
				}
				
				/*
				 * =============== Calculations for Value 'b' ===============
				 */				
				
				//Count how many Significant Figures there are to the left of the decimal point
				for(int i = decimal_b - 1; i > -1; i--)
				{
					if (b.charAt(i) != '0')
					{
						sigfig_b += i + 1;
						break;
					}
				}	
				
				return sigfig_a < sigfig_b ? sigfig_a : sigfig_b;
			}
			
			//If you're doing Addition or Subtraction

			case Addition:
			case Subtraction:
			{

				//Calculate how many significant figures their are in both values
				int places_a =  a.length() - a.indexOf('.') - 1;
				int places_b =  b.length() - b.indexOf('.') - 1;
				
				//return the significant figures of the value with the least amount of significant figures
				return places_a < places_b ? places_a : places_b; 
			}
		
		}
		return 0;		
	}
	
	public void ClearWork()
	{
		txt.setText("");
	}
	
	public String Add(String a,String b, String message)
	{
		String ans = "";
		
		if(use_sigfigs == true)
		{
			int figs = Cal_SigFig(a,b,Operation.Addition);
			String c = Double.toString(Double.parseDouble(a) + Double.parseDouble(b));

			if(Count_Decimals(c) > figs)
			{
				//strip down variable c to the proper decimal places
				ans = c.substring(0, (c.indexOf(".") + 1 + figs));
				
				//Round the last digit
				if(c.length() - figs > 0)
				{
					int round = Integer.parseInt(c.substring((c.indexOf('.') + 1 + figs),(c.indexOf('.') + 2 + figs)));

					if(round > 4)
					{
						int toround = Integer.parseInt(Character.toString(ans.charAt(ans.length() - 1)));
						toround++;
						ans = ans.substring(0,ans.length() - 1) + toround;
					}
					
				}

				txt.setText(txt.getText() + message + " = " + ans + "\n");
				return ans;
			}
		}
		
		if(a.contains(".") || b.contains(".")){
			ans =   Double.toString(Double.parseDouble(a) + Double.parseDouble(b));
		}
		else
		{
			 ans = Integer.toString(Integer.parseInt(a) + Integer.parseInt(b));
		}
		
		txt.setText(txt.getText() + message + " = " + ans + "\n");
		return ans;
	}
	
	public String Subtract(String a, String b, String message)
	{
		String ans = "";
		
		if(use_sigfigs == true)
		{
			int figs = Cal_SigFig(a,b,Operation.Subtraction);
			String c = Double.toString(Double.parseDouble(a) - Double.parseDouble(b));

			if(Count_Decimals(c) > figs)
			{
				//strip down variable c to the proper decimal places
				ans = c.substring(0, (c.indexOf(".") + 1 + figs));
				
				//Round the last digit
				if(c.length() - figs > 0)
				{
					int round = Integer.parseInt(c.substring((c.indexOf('.') + 1 + figs),(c.indexOf('.') + 2 + figs)));

					if(round > 4)
					{
						int toround = Integer.parseInt(Character.toString(ans.charAt(ans.length() - 1)));
						toround++;
						ans = ans.substring(0,ans.length() - 1) + toround;
					}
					
				}
				
				txt.setText(txt.getText() + message + " = " + ans + "\n");
				return ans;
			}
		}
		
		if(a.contains(".") || b.contains(".")){
			ans =   Double.toString(Double.parseDouble(a) - Double.parseDouble(b));
		}
		else
		{
			 ans = Integer.toString(Integer.parseInt(a) - Integer.parseInt(b));
		}
		
		txt.setText(txt.getText() + message + " = " + ans + "\n");
		return ans;
	}
	
	public String Multiply(String a, String b, String message)
	{
		String ans = "";
		
		if(use_sigfigs == true)
		{
			int figs = Cal_SigFig(a,b,Operation.Multiplication);
			String c = Double.toString(Double.parseDouble(a) * Double.parseDouble(b));

			if(Count_SigFig(c) > figs)
			{
				//TODO: strip down variable c to the proper significant figure
				//ans = c.substring(0, (c.indexOf(".") + 1 + figs));
				if(c.length() >= figs)
				{
					//Show the Answer in Scientific Notation
				}
				else
				{
					//Get rid of extra digits
				}
				
				//Round the last digit
				if(c.length() - figs > 0)
				{
					int round = Integer.parseInt(c.substring((c.indexOf('.') + 1 + figs),(c.indexOf('.') + 2 + figs)));

					if(round > 4)
					{
						int toround = Integer.parseInt(Character.toString(ans.charAt(ans.length() - 1)));
						toround++;
						ans = ans.substring(0,ans.length() - 1) + toround;
					}
					
				}
				
				txt.setText(txt.getText() + message + " = " + ans + "\n");
				return ans;
			}
		}
		
		
		if(a.contains(".") || b.contains(".")){
			ans =   Double.toString(Double.parseDouble(a) * Double.parseDouble(b));
		}
		else
		{
			 ans = Integer.toString(Integer.parseInt(a) * Integer.parseInt(b));
		}
		
		txt.setText(txt.getText() + message + " = " + ans + "\n");
		return  ans;
	}
	
	public String Divide(String a, String b, String message)
	{
		String ans = "";
		
		if(use_sigfigs == true)
		{
			int figs = Cal_SigFig(a,b,Operation.Division);
			String c = Double.toString(Double.parseDouble(a) / Double.parseDouble(b));

			if(Count_SigFig(c) > figs)
			{
				//TODO: strip down variable c to the proper significant figure
				//ans = c.substring(0, (c.indexOf(".") + 1 + figs));
				if(c.length() >= figs)
				{
					//Show the Answer in Scientific Notation
				}
				else
				{
					//Get rid of extra digits
				}
				
				//Round the last digit
				if(c.length() - figs > 0)
				{
					int round = Integer.parseInt(c.substring((c.indexOf('.') + 1 + figs),(c.indexOf('.') + 2 + figs)));

					if(round > 4)
					{
						int toround = Integer.parseInt(Character.toString(ans.charAt(ans.length() - 1)));
						toround++;
						ans = ans.substring(0,ans.length() - 1) + toround;
					}
					
				}
				
				txt.setText(txt.getText() + message + " = " + ans + "\n");
				return ans;
			}
		}
		
		
		ans =   Float.toString(Float.parseFloat(a) / Float.parseFloat(b));
		
		
		txt.setText(txt.getText() + message + " = " + ans + "\n");
		return  ans;
	}
	
	public String Sqrt(double a,boolean Sigfig)
	{	
		txt.setText(txt.getText() + "Taking the Squareroot of " + a + " = " + Math.sqrt(a) + "\n");
		return  Double.toString(Math.sqrt(a));
	}
	
	public String Absoulte(double a){
		
		if(a < 0){
			a = a * -1;
			txt.setText(txt.getText() + "Multiplying " + a *-1 + "by -1 = " + a + "\n");
		}
		else{
			txt.setText(txt.getText() + a + " Doesn't need to be multiplied by -1, the value is positive \n");
		}
		return Double.toString(a);
	}
	
	public String Power(double exp, double base){
		
		String ans =  Double.toString(Math.pow(base, exp));
		switch(Double.toString(exp)){
			case "2.0":{
				txt.setText(txt.getText() + "Squaring " + base+ " = " + ans + "\n");
				break;
			}
			case "3.0":{
				txt.setText(txt.getText() + "Cubing " + base+ " = " + ans + "\n");
				break;
			}
			
			default:
			{
				txt.setText(txt.getText() + "Calculating "+ base + " to the power of " + exp + " = " + ans + "\n");
				break;
			}
		}
		return ans;
	}
	
	public String Sin(long a){

		if(curr_mode == Mode.Radians){
			String ans = Double.toString(Math.sin(a));
			txt.setText(txt.getText() + "Taking the Sin of " + a +" in Rad = " + ans + "\n");
			return ans;
		}
		else{
			String ans = Double.toString(Math.sin(a* (Math.PI / 180)));
			txt.setText(txt.getText() + "Taking the Sin of " + a +" = " + ans + "\n");
			return ans;
		}
	}
	public String Cos(long a){
		if(curr_mode == Mode.Radians){
			String ans = Double.toString(Math.cos(a));
			txt.setText(txt.getText() + "Taking the Cos of " + a +" in Rad = " + ans + "\n");
			return ans;
		}
		else{

			String ans = Double.toString(Math.cos(a* (Math.PI / 180)));
			
			if(a == 90 || a == 270)
			{
				ans = "0";
			}
			
			txt.setText(txt.getText() + "Taking the Cos of " + a +" = " + ans + "\n");
			
			return ans;
		}
	}
	public String Tan(long a){
		if(curr_mode == Mode.Radians){
			String ans = Double.toString(Math.tan(a));
			txt.setText(txt.getText() + "Taking the Tan of " + a +" in Rad = " + ans + "\n");
			return ans;
		}
		else{
			String ans = Double.toString(Math.tan(a* (Math.PI / 180)));
			txt.setText(txt.getText() + "Taking the Tan of " + a +" = " + ans + "\n");
			return ans;
		}
	}
	
	public String Log(double a){
		double ans = Math.log10(a);
		txt.setText("Taking Log of " + a + " = "  + ans);
		return Double.toString(ans);
	}
	
	public String Ln(double a){
		double ans = Math.log(a);
		txt.setText("Taking Ln of " + a + " = "  + ans);
		return Double.toString(ans);
	}

}
