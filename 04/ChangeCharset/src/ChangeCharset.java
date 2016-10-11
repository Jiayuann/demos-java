import java.io.UnsupportedEncodingException;
public class ChangeCharset {  
    /** *//** ISO拉丁字母表 No.1，也叫做ISO-LATIN-1     */
    public static final String ISO_8859_1 = "ISO-8859-1";
    /** *//** 8 位 UCS 转换格式     */
    public static final String UTF_8 = "UTF-8";
    /** *//** 中文超大字符集     **/
    public static final String GBK = "GBK";
    public static final String GB2312 = "GB2312"; 
    /** *//** 将字符编码转换成ISO-8859-1     */
    public String toISO_8859_1(String str) throws UnsupportedEncodingException {
        return this.changeCharset(str, ISO_8859_1);
    }  
    /** *//** 将字符编码转换成UTF-8     */
    public String toUTF_8(String str) throws UnsupportedEncodingException {
        return this.changeCharset(str, UTF_8);
    }   
    /** *//** 将字符编码转换成GBK     */
    public String toGBK(String str) throws UnsupportedEncodingException {
        return this.changeCharset(str, GBK);
    }  
    /** *//** 将字符编码转换成GB2312     */
    public String toGB2312(String str) throws UnsupportedEncodingException{
        return this.changeCharset(str,GB2312);
    }
    public String changeCharset(String str, String newCharset) throws UnsupportedEncodingException {
        if(str != null) {
            //用默认字符编码解码字符串。与系统相关，中文windows默认为GB2312
            byte[] bs = str.getBytes();
            return new String(bs, newCharset);    //用新的字符编码生成字符串
        }
        return null;
    }
    public String changeCharset(String str, String oldCharset, String newCharset) throws UnsupportedEncodingException{
        if(str != null) {
            //用源字符编码解码字符串
            byte[] bs = str.getBytes(oldCharset);
            return new String(bs, newCharset);
        }
        return null;
    }  
    public static void main(String[] args) throws UnsupportedEncodingException {
        ChangeCharset test = new ChangeCharset();
        String str = "This is a 中文的 String!";
        System.out.println("str：" + str);
        
        String gbk = test.toGBK(str);
        System.out.println("转换成GBK码：" + gbk);
     
        String iso88591 = test.toISO_8859_1(str);
        System.out.println("转换成ISO-8859-1码：" + iso88591);
        
        gbk = test.changeCharset(iso88591, ISO_8859_1, GBK);
        System.out.println("再把ISO-8859-1码的字符串转换成GBK码：" + gbk);
        
        String utf8 = test.toUTF_8(str);
        System.out.println("转换成UTF-8码：" + utf8);

        String gb2312 = test.toGB2312(str);
        System.out.println("转换成GB2312码：" + gb2312);
    }
}

