package lap9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Node {
	private List<Integer> data = new ArrayList<Integer>();
	
	public void add(Integer val) {
		this.data.add(val);
	}

	public void addAll(List<Integer> data) {
		this.data.addAll(data);
	}

	// Get children of the current nodes
	public List<Node> getSuccessors() {
		data.sort(DESCOMPARATOR);
		List<Node> children = new ArrayList<Node>();
		for (int i = 0; i < data.size(); i++) {
			int current = data.get(i);
			int count = (current %2 == 0) ? (current/2):(current/2+1);
			for (int j = 1; j < count; j++) {
				if(current>2) {
					Node n = new Node();
					n.add(j);
					n.add(current-j);
					for (int k = 0; k < data.size(); k++) {
						if(k!=i) {
							n.add(data.get(k));
						}
						
					}
					if(!children.contains(n)) {
						children.add(n);
					}
				}
				
			}
			
		}
		return children;
	}
	
//	public boolean contain(Node n, List<Node> l) {
//		for (Node node : l) {
//			for (int i = 0; i < l.size(); i++) {
//				if(node.data == n.data) {
//					return true;
//				}
//			}
//		}
//		return false;
//	}

	// Check whether a node is terminal or not
	public boolean isTerminal() {
		// Enter your code here
		List<Integer> list = data;
//		Collections.sort(list);
		if(list.get(0) <= 2) {
			return true;
		}
		return false;
	}

	public static final Comparator<Integer> DESCOMPARATOR = new Comparator<Integer>() {

		@Override
		public int compare(Integer o1, Integer o2) {
			return o2.compareTo(o1);
		}
	};

	@Override
	public String toString() {
		Collections.sort(this.data, DESCOMPARATOR);
		return this.data.toString();
	}

}
