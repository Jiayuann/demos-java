public class SameNameMethod {
    public void info() {// ����û�в�����info()����
        System.out.println("��ͨ������С������1���ˣ�");
    }

    public void info(int age) {// ����������Ͳ�����info()����
        System.out.println("���ط�����С������" + age + "���ˣ�");
    }

    public static void main(String[] args) {
    	SameNameMethod ot = new SameNameMethod();// ����OverloadingTest�����
        ot.info();// �����޲���info()����
        for (int i = 1; i < 5; i++) {// �����в���info()����
            ot.info(i);
        }
    }
}
