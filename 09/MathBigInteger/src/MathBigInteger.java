import java.math.BigInteger;
public class MathBigInteger {
    public static void main(String[] args) {
        BigInteger number1 = new BigInteger("123456"); // �����߾�������number1
        BigInteger number2 = new BigInteger("654321"); // �����߾�������number2
        BigInteger addition = number1.add(number2); // ����number1��number2
        BigInteger subtraction = number1.subtract(number2); // ����number1��number2
        BigInteger multiplication = number1.multiply(number2); // ����number1��number2
        BigInteger division = number1.divide(number2); // ����number1��number2
        System.out.println("�߾�������number1��" + number1);
        System.out.println("�߾�������number2��" + number2);
        System.out.println("�߾��������ӷ���" + addition);
        System.out.println("�߾�������������" + subtraction);
        System.out.println("�߾��������˷���" + multiplication);
        System.out.println("�߾�������������" + division);
    }
}