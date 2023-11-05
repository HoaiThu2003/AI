package lap5;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class GreedySearchAlgo implements IPuzzleAlgo{

	@Override
	public Node execute(Puzzle model) {
		PriorityQueue<Node> choDuyet = new PriorityQueue<Node>(PuzzleUtils.HeuristicComparatorByH);
		List<Node> extend = new ArrayList<Node>();
		choDuyet.add(model.getInitialState());
		while(!choDuyet.isEmpty()) {
			Node current =choDuyet.poll();
			if(current.equals(model.getGoalState())) {
				return current;
			}else {
				extend.add(current);
				for(Node node:model.getSuccessors(current)) {
					if((!choDuyet.contains(node))&&(!extend.contains(node))) {
						node.setParent(current);
						choDuyet.add(node);
					}
				}
				
			}
		}
		
		return null;
	}

}
