import com.ii.gis.mstalgorithms.AlgorithmFactory.MSTAlgorithm;
import com.ii.gis.mstalgorithms.AlgorithmFactory.MSTAlgorithmFactory;
import com.ii.gis.mstalgorithms.AlgorithmTypes.AlgType;
import com.ii.gis.mstalgorithms.Graph.Graph;
import com.ii.gis.mstalgorithms.Graph.GraphLoader;
import com.ii.gis.mstalgorithms.Graph.GraphSaver;


public class MSTAlgorithms {
	private static String filename = "Graph/Input.txt";
	private MSTAlgorithm mstAlgorithm;
	private Graph graph;
	
	public static void main(String [] args){
		MSTAlgorithms mstAlgorithms = new MSTAlgorithms();
		mstAlgorithms.start();
	}
	
	private void start() {
		try {
			graph = GraphLoader.getGraph(filename);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//Dla kruskala
		mstAlgorithm = MSTAlgorithmFactory.getInstance().getAlgorithm(graph, AlgType.Kruskal);
		long time = System.currentTimeMillis();
		mstAlgorithm.solve();
		System.out.println("Kruskal:");
		time = System.currentTimeMillis() - time;
		System.out.println(time);
		try {
			GraphSaver.saveGraph("Result/Kruskal.txt", mstAlgorithm.getLog());
		} catch (Exception e) {
			System.err.println(e.toString());
		}		
		//Dla Prima
		mstAlgorithm = MSTAlgorithmFactory.getInstance().getAlgorithm(graph, AlgType.Prim);
		time = System.currentTimeMillis();
		mstAlgorithm.solve();
		System.out.println("Prim:");
		time = System.currentTimeMillis() - time;
		System.out.println(time);
		try {
			GraphSaver.saveGraph("Result/Prim.txt", mstAlgorithm.getLog());
		} catch (Exception e) {
			System.err.println(e.toString());
		}
		//Dla Borówki
		mstAlgorithm = MSTAlgorithmFactory.getInstance().getAlgorithm(graph, AlgType.Boruvka);
		time = System.currentTimeMillis();
		mstAlgorithm.solve();
		System.out.println("Boruvka:");
		time = System.currentTimeMillis() - time;
		System.out.println(time);
		try {
			GraphSaver.saveGraph("Result/Boruvka.txt", mstAlgorithm.getLog());
		} catch (Exception e) {
			System.err.println(e.toString());
		}
	}

	public MSTAlgorithms(){	
	}
}
