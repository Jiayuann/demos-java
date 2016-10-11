import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
public class CopyFile {
	// 复制文件,并检察是否复制成功，如果复制成功，则返回true，否则返回false
	public static boolean copy_File(String sourceFileName,
			String targetFileName, boolean overlay) {
		// 判断原文件是否存在
		File srcFile = new File(sourceFileName);
		if (!srcFile.exists()) {
			System.out.println("复制文件失败：原文件" + sourceFileName + "不存在！");
			return false;
		} else if (!srcFile.isFile()) {
			System.out.println("复制文件失败：" + sourceFileName + "不是一个文件！");
			return false;
		}
		// 判断目标文件是否存在
		File targetFile = new File(targetFileName);
		if (targetFile.exists()) {
			// 如果目标文件已存在且允许覆盖， 删除已存在的目标文件，无论目标文件是目录还是单个文件
			if (overlay) {
				System.out.println("文件已存在，正删除！");
				if (!deleteAnyone(targetFileName)) {
					System.out.println("删除文件" + targetFileName + "失败！");
					return false;
				}
			} else {
				System.out.println("复制文件失败：文件" + targetFileName + "已存在！");
				return false;
			}
		} else {
			if (!targetFile.getParentFile().exists()) {
				// 如果目标文件所在的目录不存在，则创建目录
				System.out.println("目标文件所在的目录不存在，准备创建它！");
				if (!targetFile.getParentFile().mkdirs()) {
					System.out.println("复制文件失败：创建目标文件所在的目录失败！");
					return false;
				}
			}
		}
		int byteread = 0; // 读取文件的字节数
		InputStream in = null;
		OutputStream out = null;
		try {
			in = new FileInputStream(srcFile); // 创建原文件的输入流
			out = new FileOutputStream(targetFile);// 创建原文件的输出流
			byte[] buffer = new byte[1024];
			// 一次读取1024个字节，当byteread为-1时表示文件已经读完
			while ((byteread = in.read(buffer)) != -1) {
				out.write(buffer, 0, byteread); // 将读取的字节写入输出流
			}
			System.out.println("复制文件" + sourceFileName + "至" + targetFileName
					+ "成功！");
			return true;
		} catch (Exception e) {
			System.out.println("复制文件失败：" + e.getMessage());
			return false;
		} finally {
			// 关闭输入输出流，注意先关闭输出流，再关闭输入流
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	 public static boolean deleteAnyone(String fileName) {  
		         File file = new File(fileName);  
		         if (!file.exists()) {  
		             System.out.println("文件删除失败：" + fileName + "文件不存在！");  
		            return false;  
		        } else {  
		            if (file.isFile()) {  
		                 return deleteFiles(fileName);  
		            } else {  
		                return deleteDir(fileName);  
		             }  
		         }  
		     }  
	 public static boolean deleteFiles(String fileName) {  
	       File file = new File(fileName);  
		      // 如果文件路径对应的文件存在，并且是一个文件，则直接删除。  
		         if (file.exists() && file.isFile()) {  
		            if (file.delete()) {  
		                System.out.println("文件：" + fileName + "删除成功！");  
		                return true;  
		           } else {  
		                System.out.println("文件" + fileName + "删除失败！");  
		               return false;  
		            }  
		       } else {  
		            System.out.println("文件删除失败：" + fileName + "文件不存在！");  
		           return false;  
		        }  
		    }  
		    // 判断删除指定的目录（文件夹）以及目录下的文件是否成功，成功则返回true否则返回false  
		    public static boolean deleteDir(String dir) {  
		         // 如果dir不以文件分隔符结尾，自动添加文件分隔符。  
		        if (!dir.endsWith(File.separator)) {  
		            dir = dir + File.separator;  
		        }  
		        File dirFile = new File(dir);  
		       // 如果dir表示的文件不存在，或者不是一个文件夹，则退出  
		        if (!dirFile.exists() || (!dirFile.isDirectory())) {  
		            System.out.println("目录删除失败：" + dir + "目录不存在！");  
		            return false;  
		        }
				return false;  
		    }


	// 复制整个目录的内容，并判断是否复制成功，如果复制成功返回true，否则返回false
	public static boolean copy_Dir(String sourceDirName, String targetDirName,
			boolean overlay) {
		// 判断原目录是否存在
		File sourceDir = new File(sourceDirName);
		if (!sourceDir.exists()) {
			System.out.println("复制目录失败：原目录" + sourceDirName + "不存在！");
			return false;
		} else if (!sourceDir.isDirectory()) {
			System.out.println("复制目录失败：" + sourceDirName + "不是一个目录！");
			return false;
		}
		// 如果目标文件夹名不以文件分隔符结尾，自动添加文件分隔符
		if (!targetDirName.endsWith(File.separator)) {
			targetDirName = targetDirName + File.separator;
		}
		File targetDir = new File(targetDirName);
		// 如果目标文件夹存在且允许覆盖时，则删除已存在的目标目录
		if (targetDir.exists()) {
			if (overlay) {
				System.out.println("目录已存在，准备删除它！");
				if (!deleteAnyone(targetDirName)) {
					System.out.println("复制失败：目录" + targetDirName + "已存在！");
				}
			} else {
				System.out.println("复制失败：目录" + targetDirName + "已存在！");
				return false;
			}
		} else {
			// 如果目录不存在则创建目标目录
			System.out.println("目录不存在，正在创建！");
			if (!targetDir.mkdirs()) {
				System.out.println("创建目录失败！");
				return false;
			}
		}
		boolean flag = true;
		// 列出源文件夹下所有文件（包括子目录）的文件名
		File[] files = sourceDir.listFiles();
		for (int i = 0; i < files.length; i++) {
			// 如果是一个文件，则进行复制
			if (files[i].isFile()) {
				flag = CopyFile.copy_File(files[i].getAbsolutePath(),
						targetDirName + files[i].getName(), false);
				if (!flag) {
					break;
				}
			}
			// 如果是子目录，继续复制目录
			if (files[i].isDirectory()) {
				flag = CopyFile.copy_Dir(files[i].getAbsolutePath(),
						targetDirName + files[i].getName(), false);
				if (!flag) {
					break;
				}
			}
		}
		if (!flag) {
			System.out.println("复制目录" + sourceDirName + "到" + targetDirName
					+ "失败！");
			return false;
		}
		System.out
				.println("复制目录" + sourceDirName + "到" + targetDirName + "成功！");
		return true;
	}
	public static void main(String[] args) {
		String sourcePath = "D:/text/text.txt";
		String targetPath = "D:/temp/temp1.txt";
		// 复制文件，如果目标存在，则覆盖
		CopyFile.copy_File(sourcePath, targetPath, true);
		// 如果目标存在，则不覆盖
		CopyFile.copy_File(sourcePath, targetPath, false);
		System.out.println();
		String sourceDir = "D:/text";
		String targetDir = "D:/temp";
		// 复制文件夹，如果目标存在，则覆盖
		CopyFile.copy_Dir(sourceDir, targetDir, true);
	}
}
