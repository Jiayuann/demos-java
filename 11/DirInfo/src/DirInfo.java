import java.io.File;
import java.io.FilenameFilter;
public class DirInfo {
	static class MyFilenameFilter implements FilenameFilter {
		private String sf = ""; 					// 定义文件的后缀名
		public MyFilenameFilter(String surfix) {		// 用构造方法为sf变量赋值
			this.sf = surfix;
		}
		public boolean accept(File dir, String name) {	// 重写FilenameFilter接口中的accept方法，判断指定的文件是否在指定的目录中
			if (new File(dir, name).isFile()) {			// 如果当前的File对象是一个文件，则返回它是否以指定的后缀结束，是返回true
				return name.endsWith(sf);
			} else {
				// 如果是文件夹，则直接返回true
				return true;
			}
		}
	}
	public static void getAllFiles(String dirName) {		// 列出指定目录下所有文件和子目录的路径
		// 如果dir不以文件分隔符结尾，自动添加文件分隔符。
		if (!dirName.endsWith(File.separator)) {
			dirName = dirName + File.separator;
		}
		File dirFile = new File(dirName);
		// 如果dir对应的文件不存在，或者不是一个文件夹，则退出
		if (!dirFile.exists() || (!dirFile.isDirectory())) {
			System.out.println("失败！找不到指定的目录：" + dirName);
			return;
		}
		// 列出源文件夹下所有文件（包括子目录）
		File[] fileArray = dirFile.listFiles();
		for (int i = 0; i < fileArray.length; i++) {
			if (fileArray[i].isFile()) {
				System.out.print(fileArray[i].getAbsolutePath() + "      ");
			} else if (fileArray[i].isDirectory()) {
				System.out.println(fileArray[i].getAbsolutePath() + "      ");
				DirInfo.getAllFiles(fileArray[i].getAbsolutePath());
			}
			if ((i + 1) % 2 == 0)
				System.out.println();
		}
	}
	public static void getFilesByFilter(FilenameFilter filter,// 获取在指定目录下符合指定后缀文件名的所有文件
			String dir_Path) {
		if (!dir_Path.endsWith(File.separator)) {// 如果目录路径不是以文件分隔符结尾则自动添加文件分隔符。
			dir_Path = dir_Path + File.separator;
		}
		File dir_File = new File(dir_Path);
		if (!dir_File.exists() || (!dir_File.isDirectory())) {// 如果指定的目录不存在或不是一个目录则返回
			System.out.println("失败！找不到指定目录：" + dir_Path);
			return;
		}
		// 列出指定目录下的所有符合过滤器条件的文件（包括子目录）
		File[] fileArray = dir_File.listFiles(filter);
		for (int i = 0; i < fileArray.length; i++) {
			if (fileArray[i].isFile()) {
				System.out.println(fileArray[i].getAbsolutePath() + " 是文件!");
			} else if (fileArray[i].isDirectory()) {
				System.out.println(fileArray[i].getAbsolutePath() + " 是目录!");
				DirInfo.getFilesByFilter(filter, fileArray[i]
						.getAbsolutePath());
			}
		}
	}
	public static void main(String[] args) {
		String dir = "D:\\createFile";
		System.out.println((dir + "目录下的内容: "));
		DirInfo.getAllFiles(dir);
		System.out.println();
		System.out.println("符合过滤器条件的文件如下：");
		// 新建一个文件名过滤器。参数为".txt"
		FilenameFilter myFilenameFilter = new DirInfo.MyFilenameFilter(
				".txt");
		DirInfo.getFilesByFilter(myFilenameFilter, dir);
	}
}
