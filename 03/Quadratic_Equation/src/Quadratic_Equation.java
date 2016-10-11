import javax.swing.JOptionPane;

public class Quadratic_Equation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  double a, b, c, D, x1, x2 ;
		  String string_a, string_b, string_c;
		  String answer=" ";
		  string_a = JOptionPane. showInputDialog("输入方程中的二次项系数");
		  a = Double.parseDouble(string_a);
		  string_b = JOptionPane. showInputDialog("输入方程中的一次项系数");
		  b = Double.parseDouble(string_b);
		  string_c = JOptionPane. showInputDialog("输入方程的常数项");
		  c = Double.parseDouble(string_c);
		  D = b*b-4*a*c; // 计算根的判别式
		  if( D > 0 ){ // 有二个不相等的实数解
		  x1=(- b+Math.sqrt(D))/( 2*a );
		  x2=(- b-Math.sqrt(D))/( 2*a );
		 

		JOptionPane.showMessageDialog(null, "方程"+a+" x*x+"+b+"x +" +c+" =0的解为:x1="+x1+", x2="+x2,"解方程", JOptionPane.INFORMATION_MESSAGE);
		  }
		  if( D == 0 ){ // 有二个相等的实数解
		  x1 = x2 = -b / ( 2*a );
		  JOptionPane.showMessageDialog(null, "方程"+a+" x*x+"+b+"x +"+c+" =0的解为:x1=x2="+x1, "解方程", JOptionPane.INFORMATION_MESSAGE);
		  }
		  if( D < 0 ){ // 无实数解
		  double r = -b / (2 * a);
		  double i = Math.sqrt(4 * a * c - b * b) / (2 * a);
		  answer = "X1= " + r + "+ " + i + "i X2= " + r + "- " + i + "i ";   
		  JOptionPane.showMessageDialog(null, "方程"+a+" x*x+"+b+"x +" +c+" =0的复数解为:"+answer ,"解方程", JOptionPane.INFORMATION_MESSAGE);
		  }
		  }
		  

	}


