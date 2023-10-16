package bai23;

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
		// TODO Auto-generated method stub
		//TEST FOR TASK 1,2,3
//		Node nodeS = new Node("S");
//		Node nodeA = new Node("A");
//		Node nodeB = new Node("B");
//		Node nodeC = new Node("C");
//		Node nodeD = new Node("D");
//		Node nodeE = new Node("E");
//		Node nodeF = new Node("F");
//		Node nodeG = new Node("G");
//		Node nodeH = new Node("H");
//		nodeS.addEdge(nodeA, 5);
//		nodeS.addEdge(nodeB, 2);
//		nodeS.addEdge(nodeC, 4);
//		nodeA.addEdge(nodeD, 9);
//		nodeA.addEdge(nodeE, 4);
//		nodeB.addEdge(nodeG, 6);
//		nodeC.addEdge(nodeF, 2);
//		nodeD.addEdge(nodeH, 7);
//		nodeE.addEdge(nodeG, 6);
//		nodeF.addEdge(nodeG, 1);
		
		//TEST FOR TASK 6
		
		Node nodeS = new Node("S");
		Node nodeA = new Node("A");
		Node nodeB = new Node("B");
		Node nodeC = new Node("C");
		Node nodeD = new Node("D");
		Node nodeE = new Node("E");
		Node nodeF = new Node("F");
		Node nodeG = new Node("G");
		Node nodeH = new Node("H");
		Node nodeI = new Node("I");
		Node nodeJ = new Node("J");
		Node nodeK = new Node("K");
		Node nodeL = new Node("L");
		Node nodeM = new Node("M");
		Node nodeN = new Node("N");
		Node nodeO = new Node("O");
		Node nodeP = new Node("P");
		Node nodeR = new Node("R");

		nodeA.addEdge(nodeB);
		nodeA.addEdge(nodeC);
		nodeA.addEdge(nodeD);
		nodeB.addEdge(nodeE);
		nodeB.addEdge(nodeF);
		nodeC.addEdge(nodeG);
		nodeD.addEdge(nodeH);
		nodeE.addEdge(nodeI);
		nodeF.addEdge(nodeJ);
		nodeF.addEdge(nodeK);
		nodeG.addEdge(nodeL);
		nodeH.addEdge(nodeM);
		nodeH.addEdge(nodeN);
		nodeK.addEdge(nodeO);
		nodeK.addEdge(nodeP);
		nodeL.addEdge(nodeR);
		nodeN.addEdge(nodeS);
		System.out.println("====== test duyet graph search BFS: =======");
//		ISearchAlgo algo1 = new BreadthFirstSearchAlgo();
//		Node result = algo1.execute(nodeS, "G");
		////////////////////////////////
		
//		Graph search
//		duyet BFS
		System.out.println("== graph search");
//		tu goc toi dich
		System.out.println("duyet tu dinh goc toi dich");
		ISearchAlgo is = new BreadthFirstSearchAlgo();
		List<Node> re = is.execute(nodeS, "G");
		List<Node> res = printPath(re);
		if(re != null) {
			System.out.println("---duong di:");
			for (int i = 0; i < res.size(); i++) {
				System.out.print(res.get(i).getLabel() + "\t");
			}
			System.out.println();
			System.out.println("---thu tu mo rong:");
			for (int i = 0; i < re.size(); i++) {
				System.out.print(re.get(i).getLabel() + "\t");
			}
		}else {
			System.out.println("---khong co duong di");
		}
		System.out.println();
		//////////////////////////////////
		
//		tu 1 dinh den dich
		
		System.out.println("---duyet tu 1 dinh bat ki den dich");
		
		List<Node> re2 = is.execute(nodeS,"A","G");
		List<Node> res2 = printPath(re2);
		if(re2 != null) {
			System.out.println("---duong di:");
			for (int i = 0; i < re2.size(); i++) {
				System.out.print(re2.get(i).getLabel() + "\t");
			}
			System.out.println();
			System.out.println("---thu tu mo rong:");
			for (int i = 0; i < res2.size(); i++) {
				System.out.print(res2.get(i).getLabel() + "\t");
			}
		}else {
			System.out.println("---khong co duong di");
		}
		System.out.println();
		///////////////////////////////////
		
//		duyet DFS
		System.out.println("======= test duyet DFS: =======");
		System.out.println("== graph search");
		System.out.println("duyet tu dinh goc toi dich");
		ISearchAlgo is2 = new DepthFirstSearchAlgo();
		List<Node> re3 = is2.execute(nodeS, "G");
		List<Node> res3 = printPath(re3);
		if(re3 != null) {
			System.out.println("---thu tu mo rong:");
			for (int i = 0; i < re3.size(); i++) {
				System.out.print(re3.get(i).getLabel() + "\t");
			}
			System.out.println();
			System.out.println("---duong di:");
			for (int i = 0; i < res3.size(); i++) {
				System.out.print(res3.get(i).getLabel() + "\t");
			}
			System.out.println();
		}else {
			System.out.println("---khong co duong di");
		}
		
		/////////////////////////////////////////
		
//		tu 1 dinh den dich
		
		System.out.println("duyet tu 1 dinh bat ki den dich");
		List<Node> re4 = is2.execute(nodeS, "B", "G");
		List<Node> res4 = printPath(re4);
		if(re4 != null) {
			System.out.println("---thu tu mo rong:");
			for (int i = 0; i < re4.size(); i++) {
				System.out.print(re4.get(i).getLabel() + "\t");
			}
			System.out.println();
			System.out.println("---duong di:");
			for (int i = 0; i < res4.size(); i++) {
				System.out.print(res4.get(i).getLabel() + "\t");
			}
		}else {
			System.out.println("---khong co duong di");
		}
		System.out.println();
		
		
		/////////////////////////////////////////
		
//		trees search
//		dung BFS
//		tu goc toi dich
		
		System.out.println("== trees search");
		List<Node> re1 = is.treeExecute(nodeS, "G");
		List<Node> res1 = printPath(re1);
		if(re1 != null) {
			System.out.println("---duong di:");
			for (int i = 0; i < res1.size(); i++) {
				System.out.print(res1.get(i).getLabel() + "\t");
			}
			System.out.println();
			System.out.println("---thu tu mo rong:");
			for (int i = 0; i < re1.size(); i++) {
				System.out.print(re1.get(i).getLabel() + "\t");
			}
		}else {
			System.out.println("---khong co duong di");
		}
		System.out.println();
		//////////////////////////////////
		
//		tu 1 dinh den dich
		
		System.out.println("---duyet tu 1 dinh bat ki den dich");
		
		List<Node> re12 = is.treeExecute(nodeS,"A","G");
		List<Node> res12 = printPath(re12);
		if(re12 != null) {
			System.out.println("---duong di:");
			for (int i = 0; i < re12.size(); i++) {
				System.out.print(re12.get(i).getLabel() + "\t");
			}
			System.out.println();
			System.out.println("---thu tu mo rong:");
			for (int i = 0; i < res12.size(); i++) {
				System.out.print(res12.get(i).getLabel() + "\t");
			}
		}else {
			System.out.println("---khong co duong di");
		}
		System.out.println();
		System.out.println("-------------------------------");
		////////////////////////////////////

//		trees search
//		duyet DFS
//		tu goc toi dich
		
		
		////////////////////////////////////////
		
//		trees search
//		tu goc toi dich
		
		System.out.println("======= test duyet trees search: =======");
		List<Node> re13 = is2.treeExecute(nodeS, "G");
		List<Node> res13 = printPath(re13);
		if(re13 != null) {
			System.out.println("---thu tu mo rong:");
			for (int i = 0; i < re13.size(); i++) {
				System.out.print(re13.get(i).getLabel() + "\t");
			}
			System.out.println();
			System.out.println("---duong di:");
			for (int i = 0; i < res13.size(); i++) {
				System.out.print(res13.get(i).getLabel() + "\t");
			}
			System.out.println();
		}else {
			System.out.println("---khong co duong di");
		}
		
		/////////////////////////////////////////
		
//		tu 1 dinh den dich
		
		System.out.println("duyet tu 1 dinh bat ki den dich");
		List<Node> re14 = is2.treeExecute(nodeS, "B", "G");
		List<Node> res14 = printPath(re14);
		if(re14 != null) {
			System.out.println("---thu tu mo rong:");
			for (int i = 0; i < re14.size(); i++) {
				System.out.print(re14.get(i).getLabel() + "\t");
			}
			System.out.println();
			System.out.println("---duong di:");
			for (int i = 0; i < res14.size(); i++) {
				System.out.print(res14.get(i).getLabel() + "\t");
			}
		}else {
			System.out.println("---khong co duong di");
		}
		System.out.println();
		
		///////////////////////////////////////////////////
//		uniformCostSearch
//		từ gốc tới đích 
		System.out.println("--------------------------------");
		System.out.println("========= test duyet UCS: =======");
		System.out.println("== uniform cost search");
		System.out.println("duyet tu dinh goc toi dich");
		ISearchAlgo is3 = new UniformCostSearchAlgo();
		List<Node> re5 = is3.execute(nodeS, "G");
		List<Node> res5 = printPath(re5);
		if(re5 != null) {
//			System.out.println("---thu tu mo rong:");
//			for (int i = 0; i < re5.size(); i++) {
//				System.out.print(re5.get(i).getLabel() + "\t");
//			}
//			System.out.println();
			System.out.println("---duong di:");
			
			for (int i = 0; i < res5.size(); i++) {
				System.out.print(res5.get(i).getLabel() + "\t");
			}
			System.out.println();
			System.out.println("tong path cost la: "+res5.get(res5.size()-1).getPathCost());
		}else {
			System.out.println("---khong co duong di");
		}
		System.out.println();
		
		////////////////////////////////////////////////////////////////
		
//		uniformCostSearch
//		từ đinh bất kì tới đích 
		
		System.out.println("duyet tu dinh bat ki toi dich");
		List<Node> re6 = is3.execute(nodeS, "A" ,"G");
		List<Node> res6 = printPath(re6);
		if(re6 != null) {
//			System.out.println("---thu tu mo rong:");
//			for (int i = 0; i < re5.size(); i++) {
//				System.out.print(re5.get(i).getLabel() + "\t");
//			}
//			System.out.println();
			System.out.println("---duong di:");
			
			for (int i = 0; i < res6.size(); i++) {
				System.out.print(res6.get(i).getLabel() + "\t");
			}
			System.out.println();
			System.out.println("tong path cost la: "+res6.get(res6.size()-1).getPathCost());
		}else {
			System.out.println("---khong co duong di");
		}
		System.out.println();
		
		/////////////////////////////////////////////////////
		
		System.out.println("--------------------------------");
		System.out.println("========= test duyet Depth Limit: =======");
		List<Node> re7 = is2.execute(nodeA, "R" ,5);
		List<Node> res7 = printPath(re7);
		if(re7 != null) {
			System.out.println("---thu tu mo rong:");
			for (int i = 0; i < re7.size(); i++) {
				System.out.print(re7.get(i).getLabel() + "\t");
			}
			System.out.println();
			System.out.println("---duong di:");
			for (int i = 0; i < res7.size(); i++) {
				System.out.print(res7.get(i).getLabel() + "\t");
			}
			System.out.println();
		}else {
			System.out.println("---khong co duong di");
		}
		
		
		
		
		
	}
}
