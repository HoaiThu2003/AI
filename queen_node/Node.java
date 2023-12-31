package queen_node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Node {
	public static final int N = 8;
	private Queen[] state;

	public Node() {
		// generateBoard();
		state = new Queen[N];
	}

	public Node(Queen[] state) {
		this.state = new Queen[N];
		for (int i = 0; i < state.length; i++) {
			this.state[i] = new Queen(state[i].getRow(), state[i].getColumn());
		}
	}

	public Node(Node n) {
		this.state = new Queen[N];
		for (int i = 0; i < N; i++) {
			Queen qi = n.state[i];
			this.state[i] = new Queen(qi.getRow(), qi.getColumn());
		}
	}

	public void generateBoard() {
		Random random = new Random();
		for (int i = 0; i < N; i++) {
			state[i] = new Queen(random.nextInt(N), i);
		}
	}

	public int getH() {// so luong cac cap quan hau tan cong
		int heuristic = 0;
		// Enter your code here
		for (int i = 0; i < state.length; i++) {
			for (int j = i+1; j < state.length; j++) {
				if(state[i].isConflict(state[j])) {
					heuristic++;
				}
			}
		}
		return heuristic;
	}

	public List<Node> generateAllCandidates() {
		List<Node> result = new ArrayList<Node>();
		// Enter your code here
		for (int i = 0; i < state.length; i++) {
			Node stateChild = new Node(this.state);
			stateChild.state[i].move();
			result.add(stateChild);
		}
		
		return result;
	}

	public Node selectNextRandomCandidate() {
		// Enter your code here
		Node res = new Node(this.state);
		Random r = new Random();
		int i = r.nextInt(N);
		int row = r.nextInt(N);
		res.state[i].setRow(row);
		return res;
	}

	public void displayBoard() {
		int[][] board = new int[N][N];
		// set queen position on the board
		for (int i = 0; i < N; i++) {
			board[state[i].getRow()][state[i].getColumn()] = 1;
		}
		// print board
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] == 1) {
					System.out.print("Q" + " ");
				} else {
					System.out.print("-" + " ");
				}
			}
			System.out.println();
		}
	}
	public Node getBestCondidate() {
		List<Node> list = generateAllCandidates();
		Node res = list.get(0);
		for (Node node : list) {
			if(node.getH()<res.getH()) {
				res = node;
			}
		}
		return res;
	}
}
