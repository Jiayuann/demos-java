import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
public class CompressFiles {
	// 压缩文件或者目录，其中：dirPath：压缩的根目录，srcName：
	// dirPath目录下的所有文件包名子目录，targetName：压缩后的zip文件
	public static void compressAllZip(String dirPath, String srcName,
			String targetName) {
		if (dirPath == null) {// 判断根目录是否存在
			System.out.println("压缩失败" + dirPath + "目录不存在");
			return;
		}
		File baseDir = new File(dirPath);// 判断dirPath是不是目录
		if (!baseDir.exists() || (!baseDir.isDirectory())) {
			System.out.println("压缩失败" + dirPath + "目录不存在");
			return;
		}
		String basicRootDir = baseDir.getAbsolutePath();
		File targetFile = new File(targetName);// 创建zip文件
		try {
			// 创建一个zip输出流来压缩数据并写入到zip文件
			ZipOutputStream out = new ZipOutputStream(new FileOutputStream(
					targetFile));
			if (srcName.equals("*")) {
				CompressFiles.compressDirToZip(basicRootDir, baseDir, out);// 将baseDir目录下的所有文件压缩到ZIP
			} else {
				File file = new File(baseDir, srcName);
				if (file.isFile()) {
					CompressFiles.compressFileToZip(basicRootDir, file, out);
				} else {
					CompressFiles.compressDirToZip(basicRootDir, file, out);
				}
			}
			out.close();
			System.out.println("文件压缩成功，压缩包的文件名为：" + targetName);
		} catch (IOException e) {
			System.out.println("压缩失败：" + e);
			e.printStackTrace();
		}
	}
	// 利用ZipOutputStream对目录的压缩
	private static void compressDirToZip(String basicRootDir, File dir,ZipOutputStream out) {
		if (dir.isDirectory()) {
			File[] files = dir.listFiles();// 列出dir目录下所有文件
			if (files.length == 0) {// 如果是空文件夹
				ZipEntry entry = new ZipEntry(getFileName(basicRootDir, dir));// 存储目录信息	
				try {
					out.putNextEntry(entry);
					out.closeEntry();
				} catch (IOException e) {
					e.printStackTrace();
				}
				return;
			}
			for (int i = 0; i < files.length; i++) {
				if (files[i].isFile()) {
					// 如果是文件，调用compressFileToZip方法
					CompressFiles.compressFileToZip(basicRootDir, files[i], out);
				} else {
					// 如果是目录，递归调用
					CompressFiles.compressDirToZip(basicRootDir, files[i], out);
				}
			}
		}
	}
	// 利用ZipOutputStream对文件的压缩
	private static void compressFileToZip(String basicRootDir, File file, ZipOutputStream out) {
		FileInputStream in = null;
		ZipEntry entry = null;
		byte[] buffer = new byte[4096];// 创建复制缓冲区
		int bytes_read;
		if (file.isFile()) {
			try {
				in = new FileInputStream(file); // 创建一个文件输入流
				// 根据压缩文件的名字构造一个ZipEntry对象，此类表示zip包中的文件条目
				entry = new ZipEntry(getFileName(basicRootDir, file));
				out.putNextEntry(entry); // 存储项信息到压缩文件
				// 将文件的内容通过字节数组复制到压缩文件中
				while ((bytes_read = in.read(buffer)) != -1) {
					out.write(buffer, 0, bytes_read);
				}
				out.closeEntry();
				in.close();
				System.out
						.println("添加文件" + file.getAbsolutePath() + "到ZIP文件中！");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private static String getFileName(String basicRootDir, File file) {// 获取等待压缩的文件的文件名
		if (!basicRootDir.endsWith(File.separator)) {
			basicRootDir += File.separator;
		}
		String filePath = file.getAbsolutePath();
		
		if (file.isDirectory()) {// 对于目录，必须在entry名字后面加上"/"，表示它将以目录项存储
			filePath += "/";
		}
		int index = filePath.indexOf(basicRootDir);
		return filePath.substring(index + basicRootDir.length());
	}
	public static void main(String[] args) {
		// 压缩D盘下的图片目录，压缩后的文件是D:/图片/图片.zip
		String dirPath = "D:/";
		String srcName = "图片/";
		String zipFileName = "D:/图片/图片.zip";
		CompressFiles.compressAllZip(dirPath, srcName, zipFileName);
	}
}
