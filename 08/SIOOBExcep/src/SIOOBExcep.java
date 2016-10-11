public class SIOOBExcep {
	public static void main(String[] args) {
		String str = "This is a StringIndexOutBounds";
		char ch = str.charAt(30);
		System.out.println(ch);
	}
}
