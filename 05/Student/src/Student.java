public class Student {
    private String name; // ��������
    private String sex; // �����Ա�
    private int age; // ��������

    public Student(String name, String sex, int age) {// ���ù��췽����ʼ����
        this.name = name;
        this.sex= sex;
        this.age = age;
    }

    public String getName() { // �������
        return name;
    }

    public String getSex() { // ����Ա�
        return sex;
    }

    public int getAge() { // �������
        return age;
    }
}