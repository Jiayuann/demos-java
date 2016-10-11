import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Runtime_09 {
	public static void main(String[] args) {
		String[] listArray = new String[2];
		List list = Arrays.asList(listArray);
		List list1 = new ArrayList(list);
		list1.add("hello");
		listArray[0] = "china";
		list.add("world");		// Å×³ö²Ù×÷´íÎóÒì³£
		System.out.println(list.get(0) + "," + list.get(1));
	}
}
