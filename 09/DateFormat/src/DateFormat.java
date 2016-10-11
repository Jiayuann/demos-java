import java.util.Date;

import java.text.SimpleDateFormat;

import java.util.Calendar;

import java.io.*;

public class DateFormat{

        public static String getDateFomate(String yyyyMMdd, String timeType, int calendarType, int num) {

                 String CALENDAR_TYPE = " yyyyMMdd ";                           //表示日期格式的常量

                  /*判断传入的日期参数是否有值，如果没有值则返回一个空值*/

                  if ("".equals(yyyyMMdd.trim())) {

                           return "";

                  }

                  Calendar cal = Calendar.getInstance();                                //返回一个表示日历对象

                  /*根据指定日期格式格式化时间*/

                  SimpleDateFormat date = new SimpleDateFormat(CALENDAR_TYPE);

                  /*根据指定日期格式格式化时间*/

                  SimpleDateFormat df = new SimpleDateFormat(timeType);

                  try {

                           /*分析给定字符串文本并生成一个日期类型的值*/

                           Date dt = date.parse(yyyyMMdd);                                 

                           cal.setTime(dt);                                                                          //根据给定日期对象设置时间

                  }catch(Exception e) {

                           System.out.println("日期变换失败" + e.getMessage());//打印输出异常信息

                           e.printStackTrace();                                                         //追踪异常事件发生执行堆栈内容

                  }

                  if(calendarType == Calendar.DATE) {

                           //根据日历规则，添加或减去指定日历字段日子的时间量

                           cal.add(Calendar.DATE, num);

                  } else if(calendarType == Calendar.MONTH) {

                           /*根据日历规则，添加或减去指定日历字段月份的时间量*/

                           cal.add(Calendar.MONTH, num); 

                  } else if(calendarType == Calendar.YEAR) {

                           /*根据日历规则，添加或减去指定日历字段年的时间量*/

                           cal.add(Calendar.YEAR, num); 

                  } else {

                           System.out.println("你指定的日期有误");                       //打印输出错误信息

                  }

                  return df.format(cal.getTime());                                                        //格式化设置后的时间

        }

        public static void main(String [] args) throws IOException {

                 DateFormat df = new DateFormat();                                      //创建计算日期对象

                  /*以下4句是用来读取键盘上输入的数据*/

                  InputStreamReader reader = new InputStreamReader(System.in);

                  BufferedReader bf = new BufferedReader(reader);           //创建字符输入流对象

                  System.out.print("请输入日期格式（yyyymmdd）:" );        //在键盘上输入的字符

                  String date = bf.readLine();                                                     //读取从键盘上输入的字符

                  /*调用计算日期方法*/

                  String dateStr = df.getDateFomate(date ," yyyyMMdd",Calendar. MONTH,2);

                  System.out.println("取得变化后的日期值 "+ dateStr);                  //打印输出计算后的日期值

        }

}

