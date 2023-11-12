package queen_node;

public class HillClimbingSearchNQueen implements ILocalSearchAlgo {
	int stepClimbed = 0;
	int stepClimbedAfterRandomRestart = 0;

	@Override
	public Node execute(Node initialState) {
		// TODO Auto-generated method stub
		Node current = new Node(initialState);
		Node neighbor = null;
		while (true) {
			neighbor = current.getBestCondidate();
			if (neighbor.getH() < current.getH()) {
				current = neighbor;
				stepClimbed++;
				stepClimbedAfterRandomRestart++;

			} else {
				return current;
			}
		}

	}

}
