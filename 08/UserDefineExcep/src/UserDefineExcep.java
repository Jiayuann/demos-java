public class UserDefineExcep {
	public static void main(String[] args) {// ����userException
		try {
			throw new userException(
					"This is the definition of my own exception classes");
		} catch (userException e) {// ��ӡuserException�쳣��Ϣ
			System.out.println("�쳣��Ϣ�ǣ�\n" + e.toString());
		}
	}
}
// ����һ���쳣��
class userException extends Exception {
	public userException(String message) {// ����ָ�����쳣��Ϣ�Զ���userException
		super(message);
	}
}
