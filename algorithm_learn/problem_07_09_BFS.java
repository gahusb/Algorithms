import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

class problem_07_09_BFS {
    Node root;
    public int BFS(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int lvl = 0;

        while(!queue.isEmpty()) {
            int len = queue.size();
            for(int i = 0; i < len; i++) {
                Node curr = queue.poll();
                if(curr.lt == null && curr.rt == null) return lvl;
                if(curr.lt != null) queue.offer(curr.lt);
                if(curr.rt != null) queue.offer(curr.rt);
            }
            lvl++;
        }

        return 0;
    }
    
    public static void main(String[] args) throws IOException {
        problem_07_09_BFS mc = new problem_07_09_BFS();
        
        mc.root = new Node(1);
        mc.root.lt = new Node(2);
        mc.root.rt = new Node(3);
        mc.root.lt.lt = new Node(4);
        mc.root.lt.rt = new Node(5);
        System.out.println(mc.BFS(mc.root));
    }
}

class Node {
    int data;
    Node lt, rt;
    public Node(int data) {
        this.data = data;
        lt = rt = null;
    }
}