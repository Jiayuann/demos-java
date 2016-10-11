import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class DemoTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		test1();
	}
	
	private static void test1(){
		Object[] arr = {5,'a',8,12,'c','b','d','c','a','b','e','f','f',8,22,'a','f','e',15};
		List<Object> dist = new ArrayList<Object>();
		Map<Object, Integer> map= new HashMap<Object, Integer>();	// 放置重复字符及其重复次数
		for (Object item : arr) {
			if (dist.contains(item)) {	// 如果包含此字符则放入map
				map.put(item, map.get(item)+1);
			} else {
				dist.add(item);
				map.put(item, 0);
			}
		}
		// 输出重复信息
		for (Iterator iterator = map.entrySet().iterator(); iterator.hasNext();) {
			Entry<Object, Integer> item=  (Entry<Object, Integer>) iterator.next();
			if (item.getValue()>0) {
				System.out.println(item.getKey()+"重复"+item.getValue()+"次");
			}
		}
		
		// 去除字符
		List<Integer> iArry = new ArrayList<Integer>();
		for (Object item : dist) {
			if (item instanceof Integer) {
				iArry.add((Integer)item);
			}
		}
		
		// 排序加输出
		Collections.sort(iArry);
		System.out.println("排序后的数列为"+iArry);
	}
}