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
		  string_a = JOptionPane. showInputDialog("���뷽���еĶ�����ϵ��");
		  a = Double.parseDouble(string_a);
		  string_b = JOptionPane. showInputDialog("���뷽���е�һ����ϵ��");
		  b = Double.parseDouble(string_b);
		  string_c = JOptionPane. showInputDialog("���뷽�̵ĳ�����");
		  c = Double.parseDouble(string_c);
		  D = b*b-4*a*c; // ��������б�ʽ
		  if( D > 0 ){ // �ж�������ȵ�ʵ����
		  x1=(- b+Math.sqrt(D))/( 2*a );
		  x2=(- b-Math.sqrt(D))/( 2*a );
		 

		JOptionPane.showMessageDialog(null, "����"+a+" x*x+"+b+"x +" +c+" =0�Ľ�Ϊ:x1="+x1+", x2="+x2,"�ⷽ��", JOptionPane.INFORMATION_MESSAGE);
		  }
		  if( D == 0 ){ // �ж�����ȵ�ʵ����
		  x1 = x2 = -b / ( 2*a );
		  JOptionPane.showMessageDialog(null, "����"+a+" x*x+"+b+"x +"+c+" =0�Ľ�Ϊ:x1=x2="+x1, "�ⷽ��", JOptionPane.INFORMATION_MESSAGE);
		  }
		  if( D < 0 ){ // ��ʵ����
		  double r = -b / (2 * a);
		  double i = Math.sqrt(4 * a * c - b * b) / (2 * a);
		  answer = "X1= " + r + "+ " + i + "i X2= " + r + "- " + i + "i ";   
		  JOptionPane.showMessageDialog(null, "����"+a+" x*x+"+b+"x +" +c+" =0�ĸ�����Ϊ:"+answer ,"�ⷽ��", JOptionPane.INFORMATION_MESSAGE);
		  }
		  }
		  

	}


