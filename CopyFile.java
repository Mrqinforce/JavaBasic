import java.io.*;
/**
 * @ClassName CopyFile)
 * @Description TODO
 * @Author Qin jian
 * @Date 2020/1/14
 * @Version 1.0
 **/
public class CopyFile {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        InputStream  is = null;
        BufferedInputStream bis = null;
        OutputStream os = null;
        BufferedOutputStream bos = null;
        Reader reader = null;
        BufferedReader br = null;
        Writer writer = null;
        BufferedWriter bw = null;
        try {
            //图片复制
            is = new FileInputStream("/Users/shahuhudexiaobinggan/Desktop/picture/头像1.jpg");
            bis = new BufferedInputStream(is);
            os = new FileOutputStream("/Users/shahuhudexiaobinggan/Desktop/picture/头像2.jpg",true);
            bos = new BufferedOutputStream(os);
//方法一 ：一次读写一个字符数组
            byte[] b = new byte[1024];
            int len;
            while ((len = bis.read(b)) != -1) {
                bos.write(b, 0, len);
                bos.flush();
            }
//方法二： 缓冲流一次读写一个字符
            //文本复制
            reader = new FileReader("/Users/shahuhudexiaobinggan/Desktop/file.txt");
            writer = new FileWriter("/Users/shahuhudexiaobinggan/Desktop/file1.txt");
            br = new BufferedReader(reader);
            bw = new BufferedWriter(writer);
//缓冲流一次读取一行数据(方法一和方法二也适用）
            String str;
            while ((str = br.readLine()) != null) {
                bw.write(str);
                bw.newLine();
                bw.flush();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally {
            try {
                if(bis!=null) {
                    bis.close();
                }
                if(is!=null) {
                    is.close();
                }
            }
            catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

}
