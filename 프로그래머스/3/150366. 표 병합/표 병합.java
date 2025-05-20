import java.util.*;
class Solution {

    class Node {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (!(o instanceof Node))
                return false;
            Node other = (Node) o;
            return this.x == other.x && this.y == other.y;
        }

        @Override
        public int hashCode() {
            return 100 * x + y;
        }
    }

    Map<Node, Node> parent = new HashMap<>();
    Map<Node, String> value = new HashMap<>();
    List<String> result = new ArrayList<>();

    public String[] solution(String[] commands) {
        init();

        for (String command : commands) {
            String[] cmd = command.split(" ");

            switch (cmd[0]) {
                case "UPDATE":
                    if (cmd.length == 4) {
                        Node node = new Node(Integer.parseInt(cmd[1]), Integer.parseInt(cmd[2]));
                        Node root = find(node);
                        value.put(root, cmd[3]);
                    } else {
                        String val1 = cmd[1];
                        String val2 = cmd[2];
                        for (Node key : value.keySet()) {
                            if (val1.equals(value.get(key))) {
                                value.put(key, val2);
                            }
                        }
                    }
                    break;

                case "MERGE":
                    Node n1 = new Node(Integer.parseInt(cmd[1]), Integer.parseInt(cmd[2]));
                    Node n2 = new Node(Integer.parseInt(cmd[3]), Integer.parseInt(cmd[4]));
                    union(n1, n2);
                    break;

                case "UNMERGE":
                    Node target = new Node(Integer.parseInt(cmd[1]), Integer.parseInt(cmd[2]));
                    unmerge(target);
                    break;

                case "PRINT":
                    Node p = new Node(Integer.parseInt(cmd[1]), Integer.parseInt(cmd[2]));
                    Node root = find(p);
                    result.add(value.getOrDefault(root, "EMPTY"));
                    break;
            }
        }

        return result.toArray(new String[0]);
    }

    // 초기화
    void init() {
        for (int i = 1; i <= 50; i++) {
            for (int j = 1; j <= 50; j++) {
                Node node = new Node(i, j);
                parent.put(node, node);
                value.put(node, "EMPTY");
            }
        }
    }

    // Union-Find
    Node find(Node node) {
        if (!parent.get(node).equals(node)) {
            parent.put(node, find(parent.get(node)));
        }
        return parent.get(node);
    }

    void union(Node a, Node b) {
        Node pa = find(a);
        Node pb = find(b);

        if (pa.equals(pb)) return;

        // 병합 시 값이 있다면 유지
        String v1 = value.getOrDefault(pa, "EMPTY");
        String v2 = value.getOrDefault(pb, "EMPTY");

        parent.put(pb, pa); // pb -> pa 병합

        if ("EMPTY".equals(v1) && !"EMPTY".equals(v2)) {
            value.put(pa, v2);
        }
    }

    void unmerge(Node node) {
        Node root = find(node);
        String originalValue = value.getOrDefault(root, "EMPTY");

        List<Node> toUnmerge = new ArrayList<>();

        for (Node n : parent.keySet()) {
            if (find(n).equals(root)) {
                toUnmerge.add(n);
            }
        }

        for (Node n : toUnmerge) {
            parent.put(n, n);
            value.put(n, "EMPTY");
        }

        value.put(node, originalValue);
    }
}
