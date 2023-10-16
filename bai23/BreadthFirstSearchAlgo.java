package bai23;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearchAlgo implements ISearchAlgo {

	public List<Node> execute(Node root, String goal) {
		List<Node> res = new ArrayList<Node>();
		Queue<Node> choDuyet = new LinkedList<Node>();
		choDuyet.add(root);

		List<Node> extend = new ArrayList<Node>();
		Node current = null;
		while (!choDuyet.isEmpty()) {

			current = choDuyet.poll();
			res.add(current);
			if (current.getLabel().equals(goal)) {

				return res;
			}
			extend.add(current);
			List<Node> childr = current.getChildrenNodes();
			for (Node node : childr) {
				if (!choDuyet.contains(node) && !extend.contains(node)) {
					choDuyet.add(node);
					node.setParent(current);

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

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Node> treeExecute(Node root, String goal) {
		List<Node> res = new ArrayList<Node>();
		Queue<Node> choDuyet = new LinkedList<Node>();
		choDuyet.add(root);
		Node current = null;
		while (!choDuyet.isEmpty()) {

			current = choDuyet.poll();
			res.add(current);
			if (current.getLabel().equals(goal)) {

				return res;
			}
			List<Node> childr = current.getChildrenNodes();
			for (Node node : childr) {
				choDuyet.add(node);
				node.setParent(current);
			}

		}
		if (!current.getLabel().equals(goal)) {

			return null;
		}

		return res;
	}

	@Override
	public List<Node> treeExecute(Node root, String start, String goal) {
		if (root.getLabel().equals(start)) {
			return treeExecute(root, goal);
		} else {
			List<Node> res = duyetDT(root);
			for (int i = 0; i < res.size(); i++) {
				if (res.get(i).getLabel().equals(start)) {
					return treeExecute(res.get(i), goal);
				}
			}
		}
		return null;
	}

	@Override
	public List<Node> execute(Node root, String goal, int limitedDepth) {
		// TODO Auto-generated method stub
		return null;
	}

}
