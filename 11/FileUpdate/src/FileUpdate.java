import java.io.*;
public class FileUpdate {
        public static void main(String args[]) throws IOException{
                  File f=new File("D:\\createFile","tempFile.txt");  //����һ��File���͵Ķ���
                  f.createNewFile();                                                             //����һ����ΪtempFile.txt���ļ�
                  f.setReadOnly();                                                                //�����ļ�����Ϊֻ��
                  System.out.println(f.getName()+"�ļ��Ƿ�ɶ���"+f.canRead());
                  System.out.println(f.getName()+"�ļ��Ƿ��д��"+f.canWrite());
                  System.out.println("�ж�"+f.getName()+"�ļ��Ƿ���ڣ�"+f.exists());
                  String prefix = "tempFile";
                  String suffix = ".java";
                  File listFile=new File("D:\\createFile");                                     //�����ļ������趨�ļ�Ŀ¼
                  File.createTempFile(prefix, suffix,listFile );   //��fileTempĿ¼�´�����ʱ�ļ�
                  File dir =new File("D:\\createFile");   //�����ļ������趨�ļ�Ŀ¼
                  /*��ø�Ŀ¼�µ�ȫ���ļ������洢��File��������*/
                  File[] filesName=dir.listFiles();                              
                  /*�г�Ŀ¼������ƥ���ļ����洢��File������*/
                  for(int i=0; i<filesName.length; i++) {                            
                       System.out.println("files["+i+"]= " +filesName[i].getName());  
                  }
                  System.out.println("��·���¹���" + filesName.length+"���ļ�");
                  f.delete();                                                                            //ɾ��tempFile.txt�ļ�
                  System.out.println("����delete��"+f.getName()+"�ļ��Ƿ����"+f.exists());
        }
}

