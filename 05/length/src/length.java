
public class length {
	double num;			// ��ֵ
	String units;			// ��λ
	String targetUnits;		// Ŀ�굥λ
	double result = 0;		// �����Ľ��
	String str = "";
	// Ӣ��:inch Ӣ��:feet �ף�meter ���ף�cm
	public static void main(String[] args) {
		System.out.println("���ȵ�λ֮��Ļ������£�");
		// ���������
		length cd = new length(3, "��", "����");
		length cd1 = new length(8, "��", "Ӣ��");
		length cd2 = new length(8945.56, "����", "��");
		length cd3 = new length(12.5, "Ӣ��", "��");
		length cd4 = new length(12.2, "Ӣ��", "����");
		length cd5 = new length(45.96, "����", "Ӣ��");
		length cd6 = new length(14.5, "Ӣ��", "Ӣ��");
		length cd7 = new length(30.2, "Ӣ��", "Ӣ��");
		// ���÷�������ӡ����Ӧ�Ľ��
		System.out.println(cd.unitConversion());
		System.out.println(cd1.unitConversion());
		System.out.println(cd2.unitConversion());
		System.out.println(cd3.unitConversion());
		System.out.println(cd4.unitConversion());
		System.out.println(cd5.unitConversion());
		System.out.println(cd6.unitConversion());
		System.out.println(cd7.unitConversion());
	}
	// ���ù��췽��Ϊ��Ա������ֵ
	public length (double num, String units, String targetUnits) {
		this.num = num;
		this.targetUnits = targetUnits;
		this.units = units;
	}
	// ���и����ȵ�λ֮��Ļ���
	public String unitConversion() {
		if (targetUnits.equals("Ӣ��") && units.equals("����")) {		// ����->Ӣ��
			result = num * (1 / 2.54);
			str = num + "���� = " + result + "Ӣ��";
		} else if (targetUnits.equals("����") && units.equals("Ӣ��")) {	// Ӣ��->����
			result = num * 2.54;
			str = num + "Ӣ�� = " + result + "����";
		} else if (targetUnits.equals("����") && units.equals("��")) {	// ��-> ����
			result = num * 100;
			str = num + "�� = " + result + "����";
		} else if (targetUnits.equals("��") && units.equals("����")) {	// ����-> ��
			result = num * (1 / 100.0);
			str = num + "���� = " + result + "��";
		} else if (targetUnits.equals("Ӣ��") && units.equals("Ӣ��")) {	// Ӣ��-> Ӣ��
			result = num * (1 / 12.0);
			str = num + "Ӣ�� = " + result + "Ӣ��";
		} else if (targetUnits.equals("Ӣ��") && units.equals("Ӣ��")) {	// Ӣ��-> Ӣ��
			result = num * 12;
			str = num + "Ӣ�� = " + result + "Ӣ��";
		} else if (targetUnits.equals("Ӣ��") && units.equals("��")) {	// ��-> Ӣ��
			result = num * 3.2809;
			str = num + "�� = " + result + "Ӣ��";
		} else if (targetUnits.equals("��") && units.equals("Ӣ��")) {	// Ӣ��-> ��
			result = num * (1 / 3.2809);
			str = num + "Ӣ�� = " + result + "��";
		}
		return str;
	}
}
