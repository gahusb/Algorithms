import java.io.IOException;

class problem_07_09_DFS {
    Node root;
    public int DFS(int lvl, Node root) {
        if(root.lt == null && root.rt == null) return lvl;
        else return Math.min(DFS(lvl + 1, root.lt), DFS(lvl + 1, root.rt));
    }
    
    public static void main(String[] args) throws IOException {
        problem_07_09_DFS mc = new problem_07_09_DFS();
        
        mc.root = new Node(1);
        mc.root.lt = new Node(2);
        mc.root.rt = new Node(3);
        mc.root.lt.lt = new Node(4);
        mc.root.lt.rt = new Node(5);
        System.out.println(mc.DFS(0, mc.root));
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