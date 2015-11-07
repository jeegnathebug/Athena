public class parser {
	
	static boolean DoesContain(String base, String[] phrase)
	{
		for(int i = 0; i < phrase.length;i++)
		{
			if(base.toLowerCase().contains(phrase[i]))
			{
				return true;
			}
		}
		return false;
	}
	private static String[] function = new String[]{"+","sqrt","-","x","/","^","sin","cos","tan","log","ln"};
	
	public static String Logparse (String txt,boolean sigfig, Mathematics_adv math)
	{
		int endof = txt.length();
		int bcount = 0;
		
		if(txt.toLowerCase().contains("log"))
		{
			int log = (txt.toLowerCase().indexOf("log")) + 4;
			for(int i = log; i < txt.length(); i++){
				if(txt.charAt(i) == '(')
				{
					bcount++;
				}
				if(txt.charAt(i) == ')'){
					if(bcount == 0){
						endof = i;
						break;
					}
					bcount--;
				}
			}
			
			if(DoesContain(txt.substring(log,endof), function))
			{
				String ans = Parse(txt.substring(log,endof),sigfig,math);
				return txt.substring(0,log -4) + math.Log(Double.parseDouble(ans))+ txt.substring(endof + 1,txt.length());
			}
			
			return  txt.substring(0,log -4) + math.Log(Double.parseDouble(txt.substring(log,endof)))+ txt.substring(endof + 1,txt.length());

		}
		
		if(txt.toLowerCase().contains("ln"))
		{
			int ln = (txt.toLowerCase().indexOf("ln")) + 3;
			
			for(int i = ln; i < txt.length(); i++){
				if(txt.charAt(i) == '(')
				{
					bcount++;
				}
				if(txt.charAt(i) == ')'){
					if(bcount == 0){
						endof = i;
						break;
					}
					bcount--;
				}
			}
			
			if(DoesContain(txt.substring(ln,endof), function))
			{
				String ans = Parse(txt.substring(ln,endof),sigfig,math);
				return txt.substring(0,ln -3) + math.Ln(Double.parseDouble(ans))+ txt.substring(endof + 1,txt.length());
			}
			
			return  txt.substring(0,ln -3) + math.Ln(Double.parseDouble(txt.substring(ln,endof)))+ txt.substring(endof + 1,txt.length());

		}
		
		return txt;
	}
	
	private static String Trigparse(String txt,boolean sigfig,Mathematics_adv math)
	{
		if(txt.toLowerCase().contains("sin")){
			int sin = (txt.toLowerCase().indexOf("sin")) + 4;
			int endofsin = txt.length();
			int bcount = 0;
			for(int i = sin; i < txt.length(); i++){
				if(txt.charAt(i) == '(')
				{
					bcount++;
				}
				if(txt.charAt(i) == ')'){
					if(bcount == 0){
						endofsin = i;
						break;
					}
					bcount--;
				}
			}

			if(DoesContain(txt.substring(sin,endofsin), function))
			{
				String ans = Parse(txt.substring(sin,endofsin),sigfig,math);
				return txt.substring(0,sin -4) + math.Sin(Long.parseLong(ans))+ txt.substring(endofsin + 1,txt.length());
			}
			
			return  txt.substring(0,sin -4) + math.Sin(Long.parseLong(txt.substring(sin,endofsin)))+ txt.substring(endofsin + 1,txt.length());
		}
		
		if(txt.toLowerCase().contains("cos")){
			int cos = (txt.toLowerCase().indexOf("cos")) + 4;
			int endofcos = txt.length();
			int bcount = 0;
			for(int i = cos; i < txt.length(); i++){
				if(txt.charAt(i) == '(')
				{
					bcount++;
				}
				if(txt.charAt(i) == ')'){
					if(bcount == 0){
						endofcos = i;
						break;
					}
					bcount--;
				}
			}

			if(DoesContain(txt.substring(cos,endofcos), function))
			{
				return  txt.substring(0,cos -4) +  math.Cos(Long.parseLong(Parse(txt.substring(cos,endofcos),sigfig,math)))+ txt.substring(endofcos + 1,txt.length());
			}
			
			return  txt.substring(0,cos -4) + math.Cos(Long.parseLong(txt.substring(cos,endofcos)))+ txt.substring(endofcos + 1,txt.length());
		}
		if(txt.toLowerCase().contains("tan")){
			int tan = (txt.toLowerCase().indexOf("tan")) + 4;
			int endoftan = txt.length();
			int bcount = 0;
			for(int i = tan; i < txt.length(); i++){
				if(txt.charAt(i) == '(')
				{
					bcount++;
				}
				if(txt.charAt(i) == ')'){
					if(bcount == 0){
						endoftan = i;
						break;
					}
					bcount--;
				}
			}
			
			if(DoesContain(txt.substring(tan,endoftan), function))
			{
				return  txt.substring(0,tan -4) + math.Tan(Long.parseLong(Parse(txt.substring(tan,endoftan),sigfig,math)))+ txt.substring(endoftan + 1,txt.length());
			}
			
			return txt.substring(0,tan -4) +  math.Tan(Long.parseLong(txt.substring(tan,endoftan))) + txt.substring(endoftan + 1,txt.length());

		}
		return "";
	}
	
	private static String Sqrt(String txt,boolean sigfig, Mathematics_adv math)
	{
			int sqrt = txt.toLowerCase().indexOf("sqrt");
			int endofsqrt = txt.length();
			
			for(int i = sqrt; i < txt.length(); i++){
				if(txt.charAt(i) == '(')
				{
					sqrt = i+1;
				}
				if(txt.charAt(i) == ')'){
					endofsqrt = i;
				}
			}
			
			if(DoesContain(txt.substring(sqrt,endofsqrt), function))
			{
				return math.Sqrt(Double.parseDouble(Parse(txt.substring(sqrt,endofsqrt),sigfig,math)),sigfig);
			}
			
			return math.Sqrt(Double.parseDouble(txt.substring(sqrt,endofsqrt)), sigfig);
	}
	
	static String BracketParse(String txt, boolean sigfig, Mathematics_adv math)
	{
		int startp = 0;
		int endp = 0;
			for(int x = 0; x < txt.length(); x++){
				//find the opening parentheses 
				if(txt.charAt(x) == '('){
					startp = x;
				}
				//find the closing parentheses
				if(txt.charAt(x) == ')'){
					endp = x;
					//Parse the substring within the parentheses
					String ans = Parse(txt.substring((startp + 1), endp),sigfig,math);
					//Replace the parentheses with the answer from the parse
					txt = txt.substring(0,startp) + ans + txt.substring(endp + 1,(txt.length()));
					startp = 0;
					endp = 0;
					//Parse the rest of the string and return it
					
					txt = Parse(txt,sigfig,math);
				}
			}

		return txt;
	}
	static String Parse(String txt,boolean sigfig, Mathematics_adv math){
		//Replace Sin Cos or Tan with the value of the operation

		math.use_sigfigs = sigfig;
		
		if(txt.contains("E"))
		{
			return "Could not resolve please remove the 'E' and replace it with x10^n";
		}
		
		while(DoesContain(txt,new String[]{"log","ln"}))
		{
			txt = Logparse(txt,sigfig,math);
			}

		while(DoesContain(txt, new String[]{"sin","cos","tan"}))
		{
			txt = Trigparse(txt, sigfig, math);
		}
		
		//Replace Squareroot by its value
		if(txt.toLowerCase().contains("sqrt")){
			txt = Sqrt(txt,sigfig,math);
		}
		
		//Follow BEDMAS Rule
		
		//Do Brackets First
		if(txt.contains("(")){
			txt = BracketParse(txt,sigfig,math);
		}

		//Do Exponents Second
		if(txt.contains("^")){
			int powat = txt.indexOf("^");
			int i = powat - 1;
			String base = "";
			String pow = "";
			
			do{
				boolean isint = (txt.charAt(i) >= '0' && txt.charAt(i) <= '9'|| txt.charAt(i) == '.');
				if(isint == false || i == 0){
					base = txt.substring(i, powat);
				break;
				}
				i--;
			}while(i >= 0);
			
			i = powat + 1;
			
			do{
				boolean isint = (txt.charAt(i) >= '0' && txt.charAt(i) <= '9'|| txt.charAt(i) == '.');
				if(isint == false || i == (txt.length()-1)){
						pow = txt.substring(powat + 1,i + 1);
						break;
				}
				
				i++;
			}while(i < (txt.length()));
			
			return math.Power(Double.parseDouble(pow), Double.parseDouble(base));
 
		}
		
		//Do Division Third
		if(txt.contains("/")){
			int divideat = txt.indexOf("/");
			int i = divideat - 1;
			String a = "";
			String b = "";
			do{
				boolean isint = (txt.charAt(i) >= '0' && txt.charAt(i) <= '9'|| txt.charAt(i) == '.');
				if(isint == false || i == 0){
					a = txt.substring(i, divideat);
					break;
				}
				i--;
			}while(i >= 0);
			
			i = divideat + 1;

			do{
				boolean isint = (txt.charAt(i) >= '0' && txt.charAt(i) <= '9'|| txt.charAt(i) == '.');
				if(isint == false || i == (txt.length()-1)){
						b = txt.substring(divideat + 1,i + 1);
						break;
				}
				
				i++;
			}while(i < (txt.length()));
			//Parse(Integer.toString(mathematics.Multiply(a, b)));
			
			/*
			 * TODO: Replace the Division in the 
			 * equation and try using BEDMAS again
			*/
			
			return math.Divide(a, b,"Dividing " + a + " by " + b);
			
		}
		
		//Do Multiplication Fourth
		if(txt.contains("x")){

			int productat = txt.indexOf("x");
			int i = productat - 1;
			String a = "";
			String b = "";
			do{
				boolean isint = (txt.charAt(i) >= '0' && txt.charAt(i) <= '9'|| txt.charAt(i) == '.');
				if(isint == false || i == 0){
					String suba = txt.substring(i, productat);
					a = suba;
					break;
				}
				i--;
			}while(i >= 0);
			
			i = productat + 1;

			do{
				boolean isint = (txt.charAt(i) >= '0' && txt.charAt(i) <= '9'|| txt.charAt(i) == '.');
				if(isint == false || i == (txt.length()-1)){
						String subb = txt.substring(productat + 1,i + 1);
						b = subb;
						break;
				}
				
				i++;
			}while(i < (txt.length()));
			//Parse(Integer.toString(mathematics.Multiply(a, b)));
			
			/*
			 * TODO: Replace the Multiplication in the 
			 * equation and try using BEDMAS again
			*/
			
			return math.Multiply(a, b,"Multiplying " + a + " by " + b);
		}
		
		//Do Addition Fifth
		if(txt.contains("+")){
			int addat = txt.indexOf("+");
			int i = addat - 1;
			String a = "";
			String b = "";
			do{
				boolean isint = (txt.charAt(i) >= '0' && txt.charAt(i) <= '9' || txt.charAt(i) == '.');
				
				if(isint == false || i == 0){
					String suba = txt.substring(i, addat);
					a = suba;
					break;
				}
				i--;
			}while(i >= 0);
			
			i = addat + 1;

			do{
				boolean isint = (txt.charAt(i) >= '0' && txt.charAt(i) <= '9'|| txt.charAt(i) == '.');
				if(isint == false || i == (txt.length()-1)){
						String subb = txt.substring(addat + 1,i + 1);
						b = subb;
						break;
				}
				
				i++;
			}while(i < (txt.length()));
			//Parse(Integer.toString(mathematics.Multiply(a, b)));
			
			/*
			 * TODO: Replace the Multiplication in the 
			 * equation and try using BEDMAS again
			*/
			
			return math.Add(a, b,"Adding " + a + " and "+ b);
		}
		
		//Do Subtraction Last
		if(txt.contains("-")){
			int subat = txt.indexOf("-");
			int i = subat - 1;
			String a = "";
			String b = "";
			do{
				boolean isint = (txt.charAt(i) >= '0' && txt.charAt(i) <= '9'|| txt.charAt(i) == '.');
				if(isint == false || i == 0){
					String suba = txt.substring(i, subat);
					a = suba;
					break;
				}
				i--;
			}while(i >= 0);
			
			i = subat + 1;

			do{
				boolean isint = (txt.charAt(i) >= '0' && txt.charAt(i) <= '9'|| txt.charAt(i) == '.');
				if(isint == false || i == (txt.length()-1)){
						String subb = txt.substring(subat + 1,i + 1);
						b = subb;
						break;
				}
				
				i++;
			}while(i < (txt.length()));
			//Parse(Integer.toString(mathematics.Multiply(a, b)));
			
			/*
			 * TODO: Replace the Multiplication in the 
			 * equation and try using BEDMAS again
			*/
			
			return math.Subtract(a, b,"Subtracting " + b + " from " + a);
		}
		
		return txt;
	}
}
