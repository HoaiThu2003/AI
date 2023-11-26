package game_alphabeta_student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AlphaBetaSearchAlgo implements ISearchAlgo {

	// function ALPHA-BETA-SEARCH(state) returns an action
	// inputs: state, current state in game
	// v <- MAX-VALUE(state, Integer.MIN_VALUE , Integer.MAX_VALUE)
	// return the action in SUCCESSORS(state) with value v
	@Override
	public void execute(Node node) {
		// Enter your code here
		System.out.println("cat cac nut sau:");
		int v = maxValue(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
		node.setValue(v);
		System.out.println();
		System.out.println("gia tri max: " +v);
	}

	// function MAX-VALUE(state, alpha, beta) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- MIN_VALUE;
	// for each s in SUCCESSORS(state) do
	// v <- MAX(v, MIN-VALUE(s, alpha, beta))
	// if v >= beta then return v
	// alpha <- MAX(alpha, v)
	// return v

	public int maxValue(Node node, int alpha, int beta) {
		// Enter your code here
		int v = Integer.MIN_VALUE;
		if(node.isTerminal()) {
			return node.getValue();
		}else {
			List<Node> child = node.getChildren();
			Collections.sort(child, Node.LabelComparator);
			for (int i = 0; i < child.size(); i++) {
				v = Math.max(v, minValue(child.get(i),alpha,beta));
				if(v >= beta) {
					for (int j = i+1; j < child.size(); j++) {
						System.out.print(child.get(j) + "\t");
					}
					return v;
				}
				alpha = Math.max(alpha, v);
			}
		}
		return v;
	}
	// function MIN-VALUE(state, alpha , beta) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MAX_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MIN(v, MAX-VALUE(s, alpha , beta))
	// if v <= alpha then return v
	// beta <- MIN(beta ,v)
	// return v

	public int minValue(Node node, int alpha, int beta) {
		// Enter your code here
		int v = Integer.MAX_VALUE;
		if(node.isTerminal()) {
			return node.getValue();
		}else {
			List<Node> child = node.getChildren();
			Collections.sort(child, Node.LabelComparator);
			for (int i = 0; i < child.size(); i++) {
				v = Math.min(v, maxValue(child.get(i),alpha,beta));
				if(v <= alpha) {
					for (int j = i+1; j < child.size(); j++) {
						System.out.print(child.get(j) + "\t");
					}
					return v;
				}
				beta = Math.min(beta, v);
			}
		}
		return v;
	}
}
