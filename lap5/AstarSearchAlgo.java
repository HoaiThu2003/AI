package lap5;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class AstarSearchAlgo implements IPuzzleAlgo{

	@Override
	public Node execute(Puzzle model) {
	PriorityQueue<Node> choDuyet = new PriorityQueue<Node>(PuzzleUtils.HeuristicComparatorByF);
	List<Node > extend = new ArrayList<Node>();
	choDuyet.add(model.getInitialState());
	while(!choDuyet.isEmpty()) {
		Node current = choDuyet.poll();
		if(current.equals(model.getGoalState())) {
			return current;
		}else {
			extend.add(current);
			for(Node node: model.getSuccessors(current)) {
				if((!choDuyet.contains(node))&&(!extend.contains(node))) {
					node.setParent(current);
					choDuyet.add(node);
				}
//				else if(choDuyet.contains(node) && node.getG()>current.getG()){
////					node.setG(current.getG()+1);
////					choDuyet.remove(node);
//					node.setParent(current);
//					choDuyet.add(node);
//				}
			}
		}
	}
	
	
		return null;
	}

}
