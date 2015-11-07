public class EquationSolver {

	public static String Quadratic(String[] args) {
		return "";
	}

	public static String Linear(String[] args, Mathematics_adv math) {
		math.ClearWork();
		switch (args[0].toLowerCase()) {
		// y=1, x=2, a=3, b=4
		case "y": {
			// y = (a*x) + b
			return math.Add(
					math.Multiply(args[3], args[2], "Multiplying a and x"),
					args[4], "Adding b ");
		}
		case "x": {
			// x = (y-b) / a
			return math.Divide(
					math.Subtract(args[1], args[4], "Subtracting b from y"),
					args[3], "Dividing by a");
		}
		case "a": {
			// a = (y-b) / x
			return math.Divide(
					math.Subtract(args[1], args[4], "Subtracting b from y"),
					args[2], "Dividing by x");
		}
		case "b": {
			// b = y - (a*x)
			return math.Subtract(args[1],
					math.Multiply(args[3], args[2], "Multiplying a and x"),
					"Subtracting from y");
		}
		default: {
			return "Error please make sure to pick a unknown variable";
		}
		}
	}

	public static String Absolute_Value(String[] args, Mathematics_adv math) {
		math.ClearWork();
		switch (args[0].toLowerCase()) {
		// y=1, x=2, a=3, h=4, k=5
		case "y": {
			// y=a|x-h|+k

			String abs = math.Absoulte(Double.parseDouble(math.Subtract(
					args[2], args[4], "Subtracting h from x")));
			return Double
					.toString(Double.parseDouble(math.Add(args[5],
							math.Multiply(args[3], abs, "Multiplying by a"),
							"Adding k")));
			// return Double.toString((Double.parseDouble(args[3]) * abs) +
			// Double.parseDouble(args[5]));
		}
		case "x": {
			// ((y-k)/a)+h=x and -((y-k)/a)+h=x
			// mid = ((y-k)/a)
			String mid = math.Divide(
					math.Subtract(args[1], args[5], "Subtracting k from y"),
					args[3], "Dividing by a");

			String pos = math.Add(mid, args[4], "(x-1) Adding h");
			String neg = math.Add(
					math.Multiply(mid, "-1", "(x-2) Multiplying by -1"),
					args[4], "(x-2) Adding h");

			return "x-1= " + pos + ", x-2= " + neg;
		}
		case "a": {
			// y-k = a|x-h|
			// a = (y-k)/|x-h|
			double mid = Double.parseDouble(math.Subtract(args[1], args[5],
					"Subtracting k from y"));
			double abs = Double.parseDouble(math.Absoulte(Double
					.parseDouble(math.Subtract(args[2], args[4],
							"Subtracting h from x"))));
			return Double.toString(mid / abs);
		}

		case "h": {
			// h = ((y-k)/a)+x h = -((y-k)/a)+x

			String mid = (math.Divide(
					math.Subtract(args[1], args[5], "Subtracting k from y"),
					args[3], "Dividing by a"));
			String pos = math.Add(mid, args[2], "(h-1) Adding x");
			String neg = math.Add(
					math.Multiply(mid, "-1", "(h-2) Multiplying by -1"),
					args[2], "(h-2) Adding x");

			return "h-1= " + pos + ", h-2= " + neg;
		}
		case "k": {
			// k = -a|x-h| + y

			String abs = math.Absoulte(Double.parseDouble(math.Subtract(
					args[2], args[4], "Subtracting h from x")));

			return math.Add(math.Multiply(
					math.Multiply("-1", args[3], "Multiplying a by -1"), abs,
					"Multipling |x-h| by -a"), args[1], "Adding y");
		}
		}
		return "";
	}

	public static String SquareRoot(String[] args, Mathematics_adv math) {
		math.ClearWork();

		switch (args[0].toLowerCase()) {
		// y=1, x=2, a=3, h=4, k=5
		case "y": {
			// y=a(sqrt((x-h)))+k
			return math.Add(math.Multiply(args[3], math.Sqrt(Double
					.parseDouble(math.Subtract(args[2], args[4],
							"Subtracting h from x")), false),
					"Multiplying by a"), args[5], "Adding k");
		}
		case "x": {
			// ((y-k)/a)^2+h
			return math.Add(math.Power(2, Double.parseDouble(math.Divide(
					math.Subtract(args[1], args[5], "Subtracting k from y"),
					args[3], "Dividing by a"))), args[4], "Adding h");
		}
		case "a": {
			// a = ((y-k)/sqrt(x-h)
			return math.Divide(math.Subtract(args[1], args[5],
					"Subtracting k from y"),
					math.Sqrt(Double.parseDouble(math.Subtract(args[2],
							args[4], "Subtracting h from x")), false),
					"Dividing");
		}
		case "h": {
			// (-(y-k)/a)^2+x
			return math.Add(math.Multiply(
					math.Power(2, Double.parseDouble(math.Divide(math.Subtract(
							args[1], args[5], "Subtracting k from y"), args[3],
							"Divding by a"))), "-1", "Multiplyng by -1"),
					args[2], "Adding x");
		}
		case "k": {
			// y-a(sqrt((x-h)))
			return math.Subtract(args[1], math.Multiply(args[3], math.Sqrt(
					Double.parseDouble(math.Subtract(args[2], args[4],
							"Subtracting h from x")), false),
					"Multiplying by a"), "Subtracting from y");

			// return
			// Double.toString(Double.parseDouble(args[1])-(Double.parseDouble(args[3])*Math.sqrt(Double.parseDouble(args[2])-Double.parseDouble(args[4]))));
		}
		}
		return "";
	}
}
