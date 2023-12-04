package lap9;

import java.util.Arrays;
import java.util.List;

public class TestNode {
	public static void main(String[] args) {
		Node node = new Node();
		Integer[] data = { 8 };
		node.addAll(Arrays.asList(data));
		List<Node> n = node.getSuccessors();
//		System.out.println(node.toString());
//		for (Node node2 : n) {
//		
//			System.out.print(node2.toString()+"\t");
//		}

		MinimaxAlgo algo = new MinimaxAlgo();
		algo.execute(node);
	}
}