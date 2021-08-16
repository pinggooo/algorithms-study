import java.io.*;
import java.util.*;

public class Baekjoon_1260 {
    static Node[] nodes;
    static int nodeNum = 0;
    static int vertexNum = 0;
    static int start_node = 0;
    static String answer = "";

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        nodeNum = Integer.parseInt(st.nextToken());
        vertexNum = Integer.parseInt(st.nextToken());
        start_node = Integer.parseInt(st.nextToken());
        nodes = new Node[nodeNum];

        for (int i = 0; i < nodeNum; i++) {
            nodes[i] = new Node(i + 1, nodeNum, false);

            for (int j = 0; j < nodeNum; j++) {
                nodes[i].adjacency[j] = false;
            }
        }

        for (int i = 0; i < vertexNum; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            nodes[start - 1].adjacency[end - 1] = true;
            nodes[end - 1].adjacency[start - 1] = true;
        }

        DFS(nodes[start_node - 1]);
        bw.write(answer.trim() + "\n");

        answer = "";
        Node[] queue = new Node[nodeNum];
        int push = 0;
        int pop = 0;
        for (int i = 0; i < nodeNum; i++) {
            nodes[i].visited = false;
        }

        BFS(nodes[start_node - 1], queue, push, pop);
        bw.write(answer.trim() + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void DFS(Node node) {
        node.visited = true;
        answer = answer + node.id + " ";

        for (int i = 0; i < nodeNum; i++) {
            if (i == node.id - 1) {
                continue;
            }

            if (node.adjacency[i] && !nodes[i].visited) {
                DFS(nodes[i]);
            }
        }
    }

    private static void BFS(Node node, Node[] queue, int push, int pop) {
        node.visited = true;
        answer = answer + node.id + " ";

        for (int i = 0; i < nodeNum; i++) {
            if (node.adjacency[i] && !nodes[i].visited) {
                queue[push++] = nodes[i];
                nodes[i].visited = true;
            }
        }

        if (empty(queue)) {
            return;
        }

        Node next = queue[pop];
        queue[pop] = null;
        pop++;
        BFS(next, queue, push, pop);
    }

    private static boolean empty(Object[] queue) {
        for (int i = 0; i < queue.length; i++) {
            if (queue[i] != null) {
                return false;
            }
        }

        return true;
    }
}

class Node {
    public int id;
    public boolean[] adjacency;
    public boolean visited;

    Node(int id, int nodeNum, boolean visited) {
        this.id = id;
        this.adjacency = new boolean[nodeNum];
        this.visited = visited;
    }
}
