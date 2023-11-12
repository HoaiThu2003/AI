package queen_node;

public class HillClimbingWithRandomRestartSearchNQueen implements ILocalSearchAlgo{
	int randomRestarts = 0;
	public Node execute(Node initialState) {
		// Enter your code here.
		HillClimbingSearchNQueen hillClimb = new HillClimbingSearchNQueen();
		Node state = hillClimb.execute(initialState);
		while (state.getH()!=0) {
			state = new Node();
			state.generateBoard();
			randomRestarts++;
			hillClimb.stepClimbedAfterRandomRestart = 0;
			state = hillClimb.execute(state);
			
		}
		System.out.println("step Climbed: "+ hillClimb.stepClimbed);
		System.out.println("random Restarts: "+randomRestarts);
		System.out.println("step Climbed After Random Restart: "+hillClimb.stepClimbedAfterRandomRestart);
		return state;

	}
}
