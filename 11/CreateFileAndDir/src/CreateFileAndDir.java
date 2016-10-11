import java.io.File;
import java.io.IOException;//引入类
public class CreateFileAndDir {//创建新文件和目录
	public static boolean createFile(String filePath) {//创建单个文件
		File file = new File(filePath);
		if (file.exists()) {//判断文件是否存在
			System.out.println("目标文件已存在"+filePath);
			return false;
		}
		if (filePath.endsWith(File.separator)) {//判断文件是否为目录
			System.out.println("目标文件不能为目录！");
			return false;
		}
		if (!file.getParentFile().exists()) {// 判断目标文件所在的目录是否存在
			// 如果目标文件所在的文件夹不存在，则创建父文件夹
			System.out.println("目标文件所在目录不存在，准备创建它！");
			if (!file.getParentFile().mkdirs()) {//判断创建目录是否成功
				System.out.println("创建目标文件所在的目录失败！");
				return false;
			}
		}
		try {
			if (file.createNewFile()) {//创建目标文件
				System.out.println("创建文件成功:"+filePath);
				return true;
			} else {
				System.out.println("创建文件失败！");
				return false;
			}
		} catch (IOException e) {//捕获异常
			e.printStackTrace();
			System.out
					.println("创建文件失败！" + e.getMessage());
			return false;
		}
	}
	public static boolean createDir(String destDirName) {//创建目录
		File dir = new File(destDirName);
		if (dir.exists()) {//判断目录是否存在
			System.out.println("创建目录失败，目标目录已存在！");
			return false;
		}
		if (!destDirName.endsWith(File.separator)) {//结尾是否以"/"结束
			destDirName = destDirName + File.separator;
		}
		if (dir.mkdirs()) {// 创建目标目录
			System.out.println("创建目录成功！"+destDirName);
			return true;
		} else {
			System.out.println("创建目录失败！");
			return false;
		}
	}
	public static String createTempFile(String prefix, String suffix,
			String dirName) {//创建临时文件
		File tempFile = null;
		if (dirName == null) {//目录如果为空
			try {
				tempFile = File.createTempFile(prefix, suffix);//在默认文件夹下创建临时文件
				return tempFile.getCanonicalPath();// 返回临时文件的路径
			} catch (IOException e) {//捕获异常
				e.printStackTrace();
				System.out.println("创建临时文件失败：" + e.getMessage());
				return null;
			}
		} else {//指定目录存在
			File dir = new File(dirName);//创建目录
			if (!dir.exists()) {//如果目录不存在则创建目录
				if (CreateFileAndDir.createDir(dirName)) {
					System.out.println("创建临时文件失败，不能创建临时文件所在的目录！");
					return null;
				}
			}
			try {
				tempFile = File.createTempFile(prefix, suffix, dir);// 在指定目录下创建临时文件
				return tempFile.getCanonicalPath();//返回临时文件的路径
			} catch (IOException e) {//捕获异常
				e.printStackTrace();
				System.out.println("创建临时文件失败!" + e.getMessage());
				return null;
			}
		}
	}

	public static void main(String[] args) {//java程序的主入口处
		String dirName = "D:/createFile/";// 创建目录
	    CreateFileAndDir.createDir(dirName);//调用方法创建目录
		String fileName = dirName + "/file1.txt";// 创建文件
		CreateFileAndDir.createFile(fileName);//调用方法创建文件
		String prefix = "temp";// 创建临时文件
		String surfix = ".txt";//后缀
		for (int i = 0; i < 10; i++) {//循环创建多个文件
			System.out.println("创建临时文件: "//调用方法创建临时文件
					+ CreateFileAndDir.createTempFile(prefix, surfix, dirName));
		}
	}
}

