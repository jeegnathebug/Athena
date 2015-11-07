import java.awt.TextField;

public class work {
	
	TextField tf;
	
	public work(TextField tf)
	{
		//Initialize work class
		tf.setEnabled(false);
		tf.setEditable(false);
	}
	
	public void show(String txt)
	{
		//Print Text
		tf.setText(txt);
	}
}
