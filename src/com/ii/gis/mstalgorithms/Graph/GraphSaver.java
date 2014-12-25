package com.ii.gis.mstalgorithms.Graph;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class GraphSaver {
	public static void saveGraph(String filename, String data) throws Exception{
		String[] paths = preparePathToSave(filename);
		if(!paths[0].equals(""))
			createFolder(paths[0]);
		File file = createFile(paths[0],paths[1]);
		writeDataToFile(file, data);
	}

	private static void writeDataToFile(File file, String data) throws Exception {
		FileOutputStream fos;
		fos = new FileOutputStream(file);
		if(data!=null)
			fos.write(data.getBytes());
		fos.close();
	}

	private static File createFile(String folderName, String fileName) throws IOException {
		File file;
		if(folderName.equals(""))
			file = new File(fileName);
		else
			file = new File(folderName, fileName);
		if(!file.exists())
			file.createNewFile();
		return file;
	}

	private static void createFolder(String folderName) {
		File file = new File(folderName);
		file.mkdirs();		
	}

	private static String[] preparePathToSave(String filename) {
		if(filename!=null){
			String[] tPaths = filename.split("/");
			if(tPaths.length!=1){
				String[] paths = new String[2];
				StringBuilder folderName = new StringBuilder();
				for(int i = 0; i<tPaths.length ;i++){
					if(i == tPaths.length -1){
						paths[0] = folderName.toString();
						paths[1] = tPaths[tPaths.length-1];
					}
					else{
						if(!folderName.toString().equals(""))
							folderName.append("/");
						folderName.append(tPaths[i]);
					}
				}
				return paths;
			}
			
			return new String[]{"",filename};
		}
		return null;
	}
}
