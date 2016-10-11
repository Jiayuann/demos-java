import java.io.UnsupportedEncodingException;
public class ChangeCharset {  
    /** *//** ISO������ĸ�� No.1��Ҳ����ISO-LATIN-1     */
    public static final String ISO_8859_1 = "ISO-8859-1";
    /** *//** 8 λ UCS ת����ʽ     */
    public static final String UTF_8 = "UTF-8";
    /** *//** ���ĳ����ַ���     **/
    public static final String GBK = "GBK";
    public static final String GB2312 = "GB2312"; 
    /** *//** ���ַ�����ת����ISO-8859-1     */
    public String toISO_8859_1(String str) throws UnsupportedEncodingException {
        return this.changeCharset(str, ISO_8859_1);
    }  
    /** *//** ���ַ�����ת����UTF-8     */
    public String toUTF_8(String str) throws UnsupportedEncodingException {
        return this.changeCharset(str, UTF_8);
    }   
    /** *//** ���ַ�����ת����GBK     */
    public String toGBK(String str) throws UnsupportedEncodingException {
        return this.changeCharset(str, GBK);
    }  
    /** *//** ���ַ�����ת����GB2312     */
    public String toGB2312(String str) throws UnsupportedEncodingException{
        return this.changeCharset(str,GB2312);
    }
    public String changeCharset(String str, String newCharset) throws UnsupportedEncodingException {
        if(str != null) {
            //��Ĭ���ַ���������ַ�������ϵͳ��أ�����windowsĬ��ΪGB2312
            byte[] bs = str.getBytes();
            return new String(bs, newCharset);    //���µ��ַ����������ַ���
        }
        return null;
    }
    public String changeCharset(String str, String oldCharset, String newCharset) throws UnsupportedEncodingException{
        if(str != null) {
            //��Դ�ַ���������ַ���
            byte[] bs = str.getBytes(oldCharset);
            return new String(bs, newCharset);
        }
        return null;
    }  
    public static void main(String[] args) throws UnsupportedEncodingException {
        ChangeCharset test = new ChangeCharset();
        String str = "This is a ���ĵ� String!";
        System.out.println("str��" + str);
        
        String gbk = test.toGBK(str);
        System.out.println("ת����GBK�룺" + gbk);
     
        String iso88591 = test.toISO_8859_1(str);
        System.out.println("ת����ISO-8859-1�룺" + iso88591);
        
        gbk = test.changeCharset(iso88591, ISO_8859_1, GBK);
        System.out.println("�ٰ�ISO-8859-1����ַ���ת����GBK�룺" + gbk);
        
        String utf8 = test.toUTF_8(str);
        System.out.println("ת����UTF-8�룺" + utf8);

        String gb2312 = test.toGB2312(str);
        System.out.println("ת����GB2312�룺" + gb2312);
    }
}

