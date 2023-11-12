package queen_node;

public class SASearchNQueen implements ILocalSearchAlgo {

	@Override
	public Node execute(Node initialState) {
		// TODO Auto-generated method stub
		Node current = new Node(initialState);
		Node next = null;
		double nhietDo = 1000.0;
		while (current.getH()!= 0) {
			next = current.selectNextRandomCandidate();
			if (next.getH() < current.getH()) {
				current = next;
			} else if (Math.exp((next.getH() - current.getH() / nhietDo)) > Math.random()) {
				current = next;
			}
			nhietDo -= 0.05;
		}
		System.out.println("nhiet do: " + nhietDo);
		return current;

	}

}
