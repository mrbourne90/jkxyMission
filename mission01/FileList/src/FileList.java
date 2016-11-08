import java.io.File;
import java.io.FileFilter;

/**
 * Created by Administrator on 2016/5/7 0007.
 * 读取目录下所有Mp3文件的名称
 */
public class FileList {

    public static void main(String[] args){

        File directory = new File("F:/音乐");
        listFiles(directory,".mp3");
    }

    /**@
     *
     * @param 搜索文件的目录
     * @param 指定的后缀名
     */
    public static void listFiles(File directory, String suffix){

        if(!directory.isDirectory()){
            System.out.println("非法目录，请重新指定目录。");
            return;
        }

        System.out.println("目录：" + directory.getAbsolutePath());
        System.out.println("文件列表：");

        FileFilter fileFilter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if(pathname.getName().endsWith(suffix) || pathname.isDirectory()){
                    return true;
                }
                return false;
            }
        };

        File[] files = directory.listFiles(fileFilter);
        for(File f : files){
            if(f.isDirectory()){
                listFiles(f, suffix);
            }
            if(f.getName().endsWith(suffix)){
                System.out.println(f.getName());
            }
        }



    }
}
