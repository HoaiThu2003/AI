package lap9;

import java.util.Arrays;
import java.util.List;


public class MinimaxAlgo {
	public void execute(Node node) {
		int v = minValue(node);
		System.out.println(v);
	}

	// function MAX-VALUE(state) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MIN_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MAX(v, MIN-VALUE(s))
	// return v
	public int maxValue(Node node) {
//		Collections.sort(node.data, Node.DESCOMPARATOR);
		int v = Integer.MIN_VALUE;
		if(node.isTerminal()) {
//			System.out.println("[" + node + "] " +0);
			return 0;
		}else {
			List<Node> child = node.getSuccessors();
			for (Node n : child) {
				v = Math.max(v, minValue(n));
			}
		}
//		System.out.println("[" + node + "] " +v);
		return v;
	}

	// function MIN-VALUE(state) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MAX_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MIN(v, MAX-VALUE(s))
	// return v
	public int minValue(Node node) {
		int v = Integer.MAX_VALUE;
		if(node.isTerminal()) {
//			System.out.println("[" + node + "] " +1);
			return 1;
		}else {
			List<Node> child = node.getSuccessors();
			for (Node n : child) {
				v = Math.min(v, maxValue(n));
			}
		}
//		System.out.println("[" + node + "] " +v);
		return v;
	}
	
}
