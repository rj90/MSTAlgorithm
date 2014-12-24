import com.ii.gis.mstalgorithms.AlgorithmFactory.MSTAlgorithm;
import com.ii.gis.mstalgorithms.AlgorithmFactory.MSTAlgorithmFactory;
import com.ii.gis.mstalgorithms.AlgorithmTypes.AlgType;
import com.ii.gis.mstalgorithms.Graph.Graph;
import com.ii.gis.mstalgorithms.Graph.GraphLoader;


public class MSTAlgorithms {
	private static String filename = "Graph/Input.txt";
	private MSTAlgorithm mstAlgorithm;
	private Graph graph;
	
	public static void main(String [] args){
		MSTAlgorithms mstAlghoritms = new MSTAlgorithms();
	}
	
	public MSTAlgorithms(){
		try {
			graph = GraphLoader.getGraph(filename);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//Dla kruskala
		mstAlgorithm = MSTAlgorithmFactory.getInstance().getAlgorithm(graph, AlgType.Kruskal);
		mstAlgorithm.solve();
		System.out.print(mstAlgorithm.getLog());		
		//Dla Prima
		mstAlgorithm = MSTAlgorithmFactory.getInstance().getAlgorithm(graph, AlgType.Prim);
		mstAlgorithm.solve();
		System.out.print(mstAlgorithm.getLog());
		//Dla Borówki
		mstAlgorithm = MSTAlgorithmFactory.getInstance().getAlgorithm(graph, AlgType.Boruvka);
		mstAlgorithm.solve();
		System.out.print(mstAlgorithm.getLog());
		
	}
}
