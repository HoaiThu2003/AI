package bai23;

import java.util.List;

public interface ISearchAlgo {
	public List<Node> execute(Node root, String goal);// find the path from root node to the goal node

	public List<Node> execute(Node root, String start, String goal); // find the path from start node to the goal node
	
	public List<Node> treeExecute(Node root, String goal);
	
	public List<Node> treeExecute(Node root, String start, String goal);
	
	public List<Node> execute(Node root, String goal, int limitedDepth);
}
