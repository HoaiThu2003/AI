package queen_node;

public class Test {
	public static void main(String[] args) {
		ILocalSearchAlgo hillclimb = new HillClimbingSearchNQueen();
		Queen[] q = { new Queen(4,0),new Queen(5, 1),new Queen(6, 2),new Queen(3, 3), new Queen(4, 4),new Queen(5, 5), new Queen(6, 6),new Queen(5, 7)};
		Node iNode = new Node(q);
		System.out.println("H: "+iNode.getH());
		iNode.displayBoard();
		System.out.println("-----------------------------");
		Node a = new Node();
		a.generateBoard();
		System.out.println("test for hill climb");
		Node HC = hillclimb.execute(iNode);
		System.out.println("H: "+HC.getH());
		HC.displayBoard();
		System.out.println("-----------------------------");
		System.out.println("test for hill climb with random restart");
		ILocalSearchAlgo HCRandom = new HillClimbingWithRandomRestartSearchNQueen();
		Node HCR = HCRandom.execute(iNode);
		System.out.println("H: "+HCR.getH());
		HCR.displayBoard();
		System.out.println("-----------------------------");
		System.out.println("test for SA");
		ILocalSearchAlgo SA = new SASearchNQueen();
		Node sa = SA.execute(iNode);
		System.out.println("H: "+sa.getH());
		sa.displayBoard();

	}

}
