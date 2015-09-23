
import java.util.*;

//Original question: http://potw.quinnftw.com/problem/2015/2/

class pNode {
	int QDist = -1;
	ArrayList<pNode> friends = new ArrayList<pNode>();
}

public class Week2 {
	static Hashtable<String, pNode> people = new Hashtable<String, pNode>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int edges = sc.nextInt();
		
		// Data input & Graph implementation
		for (int i = 0; i < edges; i++) {
			String p1 = sc.next().trim(), p2 = sc.next().trim();
			// Searching if name entry for p1 and p2 exists
			if (!people.containsKey(p1)) 
				people.put(p1, new pNode());
			
			if (!people.containsKey(p2))
				people.put(p2, new pNode());
			
			// Getting their respected node value on the graph
			pNode pNode1 = people.get(p1);
			pNode pNode2 = people.get(p2);
			
			// Adding each other to their friends list
			if (!pNode1.friends.contains(pNode2)) {
				pNode1.friends.add(pNode2);
				pNode2.friends.add(pNode1);
			}	
		}
		
		// Calulating QDist
		pNode QuinnFTW = people.get("Quinn");
		if (QuinnFTW == null) {
			System.err.println("None of us are cool :(");
			System.exit(0);
		}
		QuinnFTW.QDist = 0;
		
		// Level-order iteration through each friend of each friend.
		// Turning the Graph into pretty much a tree with QuinnFTW being at top.
		LinkedList<pNode> queue = new LinkedList<pNode>();
		queue.add(QuinnFTW);
		while (!queue.isEmpty()) {
			pNode dequeue = queue.removeFirst(); 
			for (pNode friend : dequeue.friends) {
				if (friend.QDist == -1) {
					friend.QDist = dequeue.QDist + 1;
					queue.add(friend);
				}
			}
		}
		
		// Sorting key values
		List<String> keys = new ArrayList<String>(people.keySet());
		Collections.sort(keys);
		
		// Printing keys and their respective QDist - uncool if QDist == -1
		for (String key : keys)
			System.out.println(key + " " + ((people.get(key).QDist != -1) ? (people.get(key).QDist): "uncool"));
	}
}

    

