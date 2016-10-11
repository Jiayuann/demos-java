import java.util.Locale;

import java.util.MissingResourceException;

import java.util.ResourceBundle;


public class PropertiesResourcesTest {

   

   // ����һ����̬�� ResourceBundle ����������Դ�󶨡�

   public static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle("messages");


   // ȡ��Ӧ�� properties ֵ

   public static String getString(String key) {

       return RESOURCE_BUNDLE.getString(key);

   }


   public static void main(String[] args) {


       // �����ǰ�����Ի���

       System.out.println("---- ��ǰ�����Ի����ǣ�" + Locale.getDefault() + " ----");


       // Ѱ����Դinformation������Ӧ����Դ�ļ��л�ȡ property ���ԣ�Ȼ�����

       String information = getString("information");

       System.out.println(information);

       

       /* Ѱ����Դinformation.global����Ĭ�ϵ���Դ�ļ��л�ȡ property ���ԣ�Ȼ�����(��Ϊ��������Ӧ���Ի�������Ӹ����ԣ�����ResourceBundle�ᵽĬ�ϵ���Դ������Ѱ��) */

       String informationGlobal = getString("information.global");

       System.out.println(informationGlobal);


       /* Ѱ����Դinformation.notfound����Ϊ�������κ���Դ�ļ������keyΪinformation.notfound�����ԣ���˻��׳�һ��MissingResourceException */

       try {

           String informationNotFound = getString("information.notfound");

           System.out.println(informationNotFound);

       } catch (MissingResourceException e) {

           System.out.println("�쳣����Դ���� information.notfound û���ҵ���");

       }

       

   }


}

