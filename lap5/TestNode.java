package lap5;

import java.util.Arrays;
import java.util.List;

public class TestNode {

	public static void main(String[] args) {
		Puzzle p = new Puzzle();
		p.readInput("D:\\HOCTAP\\THUCHANH\\AI\\ThucHanhAI\\src\\lap5\\PuzzleMap.txt", "D:\\HOCTAP\\THUCHANH\\AI\\ThucHanhAI\\src\\lap5\\PuzzleGoalState.txt");
		IPuzzleAlgo g = new GreedySearchAlgo();
		IPuzzleAlgo a=new AstarSearchAlgo();

		System.out.println("H1 la: "+p.computeH1(p.getInitialState()));
		System.out.println("H2 la: "+p.computeH2(p.getInitialState()));
		
		Node greedy = g.execute(p);
		Node aStart = a.execute(p);
		
		System.out.println("test for greedy");
		for(Node n:PuzzleUtils.print(greedy)) {
			System.out.println(n);
		}
		System.out.println("==========-==========");
		System.out.println("test for A*");
		for(Node n:PuzzleUtils.print(aStart)) {
			System.out.println(n);
		}
		
	}
}
