public class UserDefineExcep {
	public static void main(String[] args) {// 捕获userException
		try {
			throw new userException(
					"This is the definition of my own exception classes");
		} catch (userException e) {// 打印userException异常信息
			System.out.println("异常信息是：\n" + e.toString());
		}
	}
}
// 创建一个异常类
class userException extends Exception {
	public userException(String message) {// 根据指定的异常信息自定义userException
		super(message);
	}
}
