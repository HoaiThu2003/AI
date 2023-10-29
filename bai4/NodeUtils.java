package bai4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class NodeUtils {
	
	public static List<Node> printPath(List<Node> node) {
		if (node != null) {
			List<Node> result = new ArrayList<Node>();

//			result.add(node.getLabel());
			Node tmp = node.get(node.size()-1).getParent();
//			while (tmp != null) {
//
//				result.add(tmp);
//
//			}
			for (int i = node.size()-1; i >=0; i--) {
				if(node.get(i).compareTo(tmp)==0 && tmp != null) {
					result.add(tmp);
					tmp = node.get(i).getParent();
				}
				
				

			}
			Collections.reverse(result);
			result.add(node.get(node.size()-1));
			return result;
		} else
			
			return new ArrayList<Node>();
	}
	
	
	public static List<Node> printPathForUCS(List<Node> node) {
		if (node != null) {
			List<Node> result = new ArrayList<Node>();

//			result.add(node.getLabel());
			Node tmp = node.get(node.size()-1).getParent();
//			while (tmp != null) {
//
//				result.add(tmp);
//
//			}
			for (int i = node.size()-1; i >=0; i--) {
				if(node.get(i).compareTo(tmp)==0 && tmp != null) {
					result.add(tmp);
					tmp = node.get(i).getParent();
				}
				
				

			}
			Collections.reverse(result);
			result.add(node.get(node.size()-1));
			return result;
		} else
			
			return new ArrayList<Node>();
		
	}
	
	public static void main(String[] args) {
//		Node s = new Node("S", 15);
//		Node b = new Node("B", 10);
//		Node a = new Node("A", 16);
//		Node c = new Node("C", 5);
//		Node d = new Node("D", 2);
////		Node e = new Node("E", 1);
////		Node f = new Node("F", 1);
//		Node g = new Node("G", 0);
//		
//		s.addEdge(b, 8);
//		s.addEdge(a, 3);
//		a.addEdge(c, 11);
//		b.addEdge(d, 9);
//		a.addEdge(d, 5);
//		c.addEdge(g, 3);
//		a.addEdge(g, 2);
//		d.addEdge(g, 6);
		
		Node s = new Node("S", 6);
		Node b = new Node("B", 4);
		Node a = new Node("A", 4);
		Node c = new Node("C", 4);
		Node d = new Node("D", 3.5);
		Node e = new Node("E", 1);
		Node f = new Node("F", 1);
		Node g = new Node("G", 0);
		
		s.addEdge(b, 3);
		s.addEdge(a, 2);
		a.addEdge(c, 3);
		b.addEdge(d, 3);
		b.addEdge(c, 1);
		c.addEdge(e, 3);
		c.addEdge(d, 1);
		d.addEdge(f, 2);
		f.addEdge(g, 1);
		e.addEdge(g, 2);
		
		
		IInformedSearchAlgo aStar = new AstarSearchAlgo();
		List<Node> res = aStar.execute(s, g.getLabel());
//		System.out.println(NodeUtils.printPath(res));
		List<Node> res5 = printPathForUCS(res);
		if(res != null) {
			System.out.println("==== test for A*: =====");
//			for (int i = 0; i < re5.size(); i++) {
//				System.out.print(re5.get(i).getLabel() + "\t");
//			}
//			System.out.println();
			System.out.println("---duong di:");
			
			for (int i = 0; i < res5.size(); i++) {
				System.out.print(res5.get(i).getLabel() + "\t");
			}
			System.out.println();
			System.out.println("tong path cost la: "+(res5.get(res5.size()-1).getH() + res5.get(res5.size()-1).getG()));
		}else {
			System.out.println("---khong co duong di");
		}
		System.out.println();
		
		IInformedSearchAlgo greedy = new GreedySearchAlgo();
		List<Node> res2 = greedy.execute(s, g.getLabel());
//		System.out.println(NodeUtils.printPath(res));
		List<Node> res6 = printPathForUCS(res2);
		if(res2 != null) {
			System.out.println("==== test for Greedy: =====");
//			for (int i = 0; i < re5.size(); i++) {
//				System.out.print(re5.get(i).getLabel() + "\t");
//			}
//			System.out.println();
			System.out.println("---duong di:");
			
			for (int i = 0; i < res6.size(); i++) {
				System.out.print(res6.get(i).getLabel() + "\t");
			}
			System.out.println();
//			System.out.println("tong path cost la: "+(res6.get(res6.size()-1).getH()));
		}else {
			System.out.println("---khong co duong di");
		}
		System.out.println();
		
		IInformedSearchAlgo ucs = new UniformCostSearchAlgo();
		List<Node> res3 = ucs.execute(s, g.getLabel());
//		System.out.println(NodeUtils.printPath(res));
		List<Node> res7 = printPathForUCS(res3);
		if(res3 != null) {
			System.out.println("==== test for Uniform-cost search: =====");
//			for (int i = 0; i < re5.size(); i++) {
//				System.out.print(re5.get(i).getLabel() + "\t");
//			}
//			System.out.println();
			System.out.println("---duong di:");
			
			for (int i = 0; i < res7.size(); i++) {
				System.out.print(res7.get(i).getLabel() + "\t");
			}
			System.out.println();
			System.out.println("tong path cost la: "+(res6.get(res6.size()-1).getG()));
		}else {
			System.out.println("---khong co duong di");
		}
		System.out.println();
	}
}
