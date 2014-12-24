package com.ii.gis.mstalgorithms.Graph;

import java.io.FileInputStream;
import java.util.Scanner;

public class GraphLoader {
	public static Graph getGraph(String filename) throws Exception{
		return loadGraph(readDataFromFile(filename));
	}
	
	private static Graph loadGraph(String graphString) {
		Graph graph = new Graph();
		String[] line = graphString.split("\\r?\\n");
		for(String l : line){
			String[] gParameter = l.split("\\s+");
			if (gParameter.length==3){
				graph.addEdge(gParameter[0], gParameter[1], Double.parseDouble(gParameter[2].replace(",",".")));
			}
		}
		return graph;
		
	}

	private static String readDataFromFile(String filename) throws Exception{
		StringBuilder data = new StringBuilder();
		Scanner in = new Scanner(new FileInputStream(filename));
		while(in.hasNextLine()){
			data.append(in.nextLine()+"\n");
		}
		in.close();
		
		return data.toString();
	}
}
