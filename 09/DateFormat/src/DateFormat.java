import java.util.Date;

import java.text.SimpleDateFormat;

import java.util.Calendar;

import java.io.*;

public class DateFormat{

        public static String getDateFomate(String yyyyMMdd, String timeType, int calendarType, int num) {

                 String CALENDAR_TYPE = " yyyyMMdd ";                           //��ʾ���ڸ�ʽ�ĳ���

                  /*�жϴ�������ڲ����Ƿ���ֵ�����û��ֵ�򷵻�һ����ֵ*/

                  if ("".equals(yyyyMMdd.trim())) {

                           return "";

                  }

                  Calendar cal = Calendar.getInstance();                                //����һ����ʾ��������

                  /*����ָ�����ڸ�ʽ��ʽ��ʱ��*/

                  SimpleDateFormat date = new SimpleDateFormat(CALENDAR_TYPE);

                  /*����ָ�����ڸ�ʽ��ʽ��ʱ��*/

                  SimpleDateFormat df = new SimpleDateFormat(timeType);

                  try {

                           /*���������ַ����ı�������һ���������͵�ֵ*/

                           Date dt = date.parse(yyyyMMdd);                                 

                           cal.setTime(dt);                                                                          //���ݸ������ڶ�������ʱ��

                  }catch(Exception e) {

                           System.out.println("���ڱ任ʧ��" + e.getMessage());//��ӡ����쳣��Ϣ

                           e.printStackTrace();                                                         //׷���쳣�¼�����ִ�ж�ջ����

                  }

                  if(calendarType == Calendar.DATE) {

                           //��������������ӻ��ȥָ�������ֶ����ӵ�ʱ����

                           cal.add(Calendar.DATE, num);

                  } else if(calendarType == Calendar.MONTH) {

                           /*��������������ӻ��ȥָ�������ֶ��·ݵ�ʱ����*/

                           cal.add(Calendar.MONTH, num); 

                  } else if(calendarType == Calendar.YEAR) {

                           /*��������������ӻ��ȥָ�������ֶ����ʱ����*/

                           cal.add(Calendar.YEAR, num); 

                  } else {

                           System.out.println("��ָ������������");                       //��ӡ���������Ϣ

                  }

                  return df.format(cal.getTime());                                                        //��ʽ�����ú��ʱ��

        }

        public static void main(String [] args) throws IOException {

                 DateFormat df = new DateFormat();                                      //�����������ڶ���

                  /*����4����������ȡ���������������*/

                  InputStreamReader reader = new InputStreamReader(System.in);

                  BufferedReader bf = new BufferedReader(reader);           //�����ַ�����������

                  System.out.print("���������ڸ�ʽ��yyyymmdd��:" );        //�ڼ�����������ַ�

                  String date = bf.readLine();                                                     //��ȡ�Ӽ�����������ַ�

                  /*���ü������ڷ���*/

                  String dateStr = df.getDateFomate(date ," yyyyMMdd",Calendar. MONTH,2);

                  System.out.println("ȡ�ñ仯�������ֵ "+ dateStr);                  //��ӡ�������������ֵ

        }

}

