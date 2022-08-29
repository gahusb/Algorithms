import java.io.IOException;

class problem_07_05 {
    Node root;
    public void recursive(Node root) {
        if(root == null) return;
        else {
            // 전위순회
            System.out.print(root.value + " ");
            recursive(root.lt);
            // 중위순회
            recursive(root.rt);
            // 후위순회
        }
    }
    
    public static void main(String[] args) throws IOException {
        problem_07_05 mc = new problem_07_05();
        
        mc.root = new Node(1);
        mc.root.lt = new Node(2);
        mc.root.rt = new Node(3);
        mc.root.lt.lt = new Node(4);
        mc.root.lt.rt = new Node(5);
        mc.root.rt.lt = new Node(6);
        mc.root.rt.rt = new Node(7);

        mc.recursive(mc.root);
    }
}

class Node {
    int value;
    Node lt, rt;
    public Node(int value) {
        this.value = value;
        lt = rt = null;
    }
}