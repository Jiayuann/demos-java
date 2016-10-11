import java.util.Locale;

import java.util.MissingResourceException;

import java.util.ResourceBundle;


public class PropertiesResourcesTest {

   

   // 创建一个静态的 ResourceBundle 对象，用于资源绑定。

   public static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle("messages");


   // 取相应的 properties 值

   public static String getString(String key) {

       return RESOURCE_BUNDLE.getString(key);

   }


   public static void main(String[] args) {


       // 输出当前的语言环境

       System.out.println("---- 当前的语言环境是：" + Locale.getDefault() + " ----");


       // 寻找资源information。从相应的资源文件中获取 property 属性，然后输出

       String information = getString("information");

       System.out.println(information);

       

       /* 寻找资源information.global。从默认的资源文件中获取 property 属性，然后输出(因为不会在相应语言环境下添加该属性，所以ResourceBundle会到默认的资源环境下寻找) */

       String informationGlobal = getString("information.global");

       System.out.println(informationGlobal);


       /* 寻找资源information.notfound。因为不会在任何资源文件下添加key为information.notfound的属性，因此会抛出一个MissingResourceException */

       try {

           String informationNotFound = getString("information.notfound");

           System.out.println(informationNotFound);

       } catch (MissingResourceException e) {

           System.out.println("异常：资源属性 information.notfound 没有找到。");

       }

       

   }


}

