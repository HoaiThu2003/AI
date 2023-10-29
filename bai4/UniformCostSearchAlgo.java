package bai4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;



public class UniformCostSearchAlgo implements IInformedSearchAlgo {

	@Override
	public List<Node> execute(Node root, String goal) {
		// TODO Auto-generated method stub
//		Map<Node, Double> map = new HashMap<Node, Double>();
		List<Node> res = new ArrayList<Node>();
		PriorityQueue<Node> choDuyet = new PriorityQueue<Node>(new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				return (int) (o1.getG() - o2.getG());
			}
		});
		choDuyet.add(root);
		List<Node> extend = new ArrayList<Node>();
		Node current = null;
		while (!choDuyet.isEmpty()) {
			current = choDuyet.poll();
			res.add(current);
//			map.put(current, current.getPathCost());
			if (current.getLabel().equals(goal)) {

				return res;
			}else {
				extend.add(current);
				List<Edge> childr = current.getChildren();
				for (Edge ch : childr) {
					Node node = ch.getEnd();
					if (!choDuyet.contains(node) && !extend.contains(node)) {
						choDuyet.add(node);
						node.setParent(current);
						node.setG(current.getG()+ch.getWeight());
					}else if(choDuyet.contains(node) && node.getG()>current.getG()){
						node.setG(current.getG());
						choDuyet.remove(node);
						node.setParent(current);
						choDuyet.add(node);
					}
				}
			}
		}
		if (!current.getLabel().equals(goal)) {

			return null;
		}
		return res;
	}

	@Override
	public List<Node> execute(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		if (root.getLabel().equals(start)) {
			return execute(root, goal);
		} else {
			List<Node> res = duyetDT(root);
			for (int i = 0; i < res.size(); i++) {
				if (res.get(i).getLabel().equals(start)) {
					res.get(i).setG(0);
					return execute(res.get(i), goal);
				}
			}
		}
		return null;
	}
	
	public List<Node> duyetDT(Node root) {
		List<Node> res = new ArrayList<Node>();
		Queue<Node> choDuyet = new LinkedList<Node>();
		choDuyet.add(root);

		List<Node> extend = new ArrayList<Node>();
		while (!choDuyet.isEmpty()) {

			Node current = choDuyet.poll();
			res.add(current);
			extend.add(current);
			List<Node> childr = current.getChildrenNodes();
			for (Node node : childr) {
				if (!choDuyet.contains(node) && !extend.contains(node)) {
					choDuyet.add(node);
					node.setParent(current);

				}

			}

		}

		return res;

	}

}
