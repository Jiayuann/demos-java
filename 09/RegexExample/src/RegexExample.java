import java.util.regex.Matcher;

import java.util.regex.Pattern;


public class RegexExample {


        public static void main(String[] args)

        {

                  //定义正则表达式与被匹配的字符串

                  String patternStr="(0?[1-9]|1[0-2]):([0-5]\\d)([a|p]m)";

                  String matcherStr="现在的时刻为10:51pm，这里的营业时间为：每天8:00am至5:30pm！！！";

                  //生成Pattern对象与Matcher对象

                  Pattern p=Pattern.compile(patternStr);

                  Matcher m=p.matcher(matcherStr);

                  //创建目标字符串缓冲区

                  StringBuffer sb=new StringBuffer();

                  //定义计数器

                  int count=0;

                  //打印初始字符串

                  System.out.print("初始字符串为：");

                  System.out.println(matcherStr);

                  //开始匹配检测

                  while(m.find())

                  {

                           //创建临时字符串缓冲区

                           StringBuffer temp=new StringBuffer();

                           if(m.group(3).equals("am")) 

                           {//时间为am的情况的替换工作

                                    //设置新的时间格式

                                    temp.append(m.group(1));

                                    temp.append(":");

                                    temp.append(m.group(2));                                    

                           }

                           else 

                           {//时间为pm的情况的替换工作

                                    //提取时间并转换

                                    int time=Integer.parseInt(m.group(1));

                                    time=time+12;

                                    //设置新的时间格式

                                    temp.append(time+":"+m.group(2));

                           }

                           //进行替换并将结果放入目标字符串缓冲区

                           m.appendReplacement(sb,temp.toString());

                           //打印每次替换的情况

                           System.out.println("["+(++count)+"] 将"+m.group(0)+"替换为"+temp.toString());

                  }

                  //将最后一次替换后剩余的字符串添加进目标字符串缓冲区

                  m.appendTail(sb);

                  //打印最后的结果

                  System.out.print("最后的结果为：");

                  System.out.println(sb.toString());

        }


}

