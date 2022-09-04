import java.io.IOException;
import java.util.*;

class problem_07_07 {
    Node root;
    
    public void BFS(Node root) {
        Queue<Node> queue = new LinkedList<>();

        queue.offer(root);
        int lev = 0;

        while(!queue.isEmpty()) {
            int len = queue.size();
            System.out.print(lev + " : " );
            for(int i = 0; i < len; i++) {
                Node curr = queue.poll();
                System.out.print(curr.data + " ");
                
                if(curr.lt != null) queue.offer(curr.lt);
                if(curr.rt != null) queue.offer(curr.rt);
            }
            lev++;
            System.out.println();
        }
    }
    
    public static void main(String[] args) throws IOException {
        problem_07_07 mc = new problem_07_07();

        mc.root = new Node(1);
        mc.root.lt = new Node(2);
        mc.root.rt = new Node(3);
        mc.root.lt.lt = new Node(4);
        mc.root.lt.rt = new Node(5);
        mc.root.rt.lt = new Node(6);
        mc.root.rt.rt = new Node(7);

        mc.BFS(mc.root);
    }
}

class Node {
    int data;
    Node lt, rt;
    public Node(int value) {
        this.data = value;
        lt = rt = null;
    }
}