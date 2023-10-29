package bai4;

import java.util.List;

public interface IInformedSearchAlgo {
	public List<Node> execute(Node s, String goal);

	public List<Node> execute(Node root, String start, String goal);

}
