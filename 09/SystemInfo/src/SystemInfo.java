public class SystemInfo {
	public static void main(String[] args) {
		// ͨ������System���getProperty��������ȡ��Ӧ������ֵ
		System.out.println("�û����˻����ƣ�" + System.getProperty("user.name"));
		System.out.println("��ǰ�û�����Ŀ¼��" + System.getProperty("user.dir"));
		System.out.println("�û���home·����" + System.getProperty("user.home"));
		System.out.println("�����ڵ�·����" + System.getProperty("java.class.path"));
		System.out.println("����ϵͳ������:" + System.getProperty("os.name"));
		System.out.println("����ϵͳ�İ汾��" + System.getProperty("os.version"));
		System.out.println("����ϵͳ�ļܹ���" + System.getProperty("os.arch"));
		System.out.println("�����ʵ�ֵİ汾��" + System.getProperty("java.vm.version"));
		System.out.println("�����ʵ�ֵ������̣�" + System.getProperty("java.vm.vendor"));
		System.out.println("Ĭ�ϵ���ʱ�ļ�·����" + System.getProperty("java.io.tmpdir"));
		System.out.println("���л����淶������:"
				+ System.getProperty("java.specification.name"));
		System.out.println("Java���ʽ���İ汾�ţ�"
				+ System.getProperty("java.class.version"));
		System.out.println("Java���л����İ汾:" + System.getProperty("java.version"));
		System.out.println("Java���л�����������:" + System.getProperty("java.vendor"));
		System.out.println("Java�İ�װ·����" + System.getProperty("java.home"));
	}

}
