package com.ii.gis.mstalgorithms.Graph;

import java.io.File;
import java.io.FileOutputStream;

public class GraphSaver {
	public static void saveGraph(String filename, String data) throws Exception{
		if (filename!=null){
			File file = createFile(filename);
			writeDataToFile(file, data);
		}
	}
	private static File createFile(String filename) throws Exception{
		File file = new File(filename);
		if (!file.exists())
			file.createNewFile();
		return file;
	}

	private static void writeDataToFile(File file, String data) throws Exception {
		FileOutputStream fos;
		fos = new FileOutputStream(file);
		if(data!=null)
			fos.write(data.getBytes());
		fos.close();
	}
}
