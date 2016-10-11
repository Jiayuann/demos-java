import java.io.*;
public class FileUpdate {
        public static void main(String args[]) throws IOException{
                  File f=new File("D:\\createFile","tempFile.txt");  //创建一个File类型的对象
                  f.createNewFile();                                                             //创建一个名为tempFile.txt空文件
                  f.setReadOnly();                                                                //将该文件设置为只读
                  System.out.println(f.getName()+"文件是否可读："+f.canRead());
                  System.out.println(f.getName()+"文件是否可写："+f.canWrite());
                  System.out.println("判断"+f.getName()+"文件是否存在："+f.exists());
                  String prefix = "tempFile";
                  String suffix = ".java";
                  File listFile=new File("D:\\createFile");                                     //创建文件对象并设定文件目录
                  File.createTempFile(prefix, suffix,listFile );   //在fileTemp目录下创建临时文件
                  File dir =new File("D:\\createFile");   //创建文件对象并设定文件目录
                  /*获得该目录下的全部文件名并存储在File类型数组*/
                  File[] filesName=dir.listFiles();                              
                  /*列出目录下所有匹配文件并存储到File数组中*/
                  for(int i=0; i<filesName.length; i++) {                            
                       System.out.println("files["+i+"]= " +filesName[i].getName());  
                  }
                  System.out.println("该路径下共有" + filesName.length+"个文件");
                  f.delete();                                                                            //删除tempFile.txt文件
                  System.out.println("调用delete后"+f.getName()+"文件是否存在"+f.exists());
        }
}

