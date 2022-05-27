package CHC5223.PartA;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class MemberBST implements IMemberDB {

    private static String logfile = "database.default.log.txt";

    private static void appendLog(String content) {
        FileOutputStream fileOutputStream = null;
        BufferedWriter bufferedWriter =null;
        try {
            fileOutputStream = new FileOutputStream(logfile, true);
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
            bufferedWriter.newLine();
            bufferedWriter.newLine();
            bufferedWriter.write(content);
            bufferedWriter.newLine();
            bufferedWriter.flush();
            bufferedWriter.close();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static class Node {
        public Member data;
        private Node left;
        private Node right;

        public Node(Member member) {
            this.data = member;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int size;

    public MemberBST() {
        System.out.println("Binary Search Tree");
        logfile = "database" + "log.txt";
        root = null;
        size = 0;
    }

    @Override
    public void clearDB() {
        new MemberBST();
    }

    @Override
    public boolean containsName(String name) {
        return get(name) != null;
    }

    @Override
    public Member get(String name) {
        assert name != null;
        Node current = root;
        while (current != null) {
            if (name.compareTo(current.data.getName()) < 0) {
                current = current.left;
            }
            else if (name.compareTo(current.data.getName()) > 0) {
                current = current.right;
            }
            else {
                return current.data;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Member put(Member member) {
        assert member != null;
        Node newNode = new Node(member);
        if (root == null) {
            root = newNode;
            this.size++;
            return null;
        }
        else {
            Node current = root;
            Node parent = null;
            while (current != null) {
                parent = current;
                if (member.getName().compareTo(current.data.getName()) < 0) {
                    current = current.left;
                } else {
                    current = current.right;

                }
            }
            if (member.getName().compareTo(parent.data.getName()) < 0) {
                parent.left = newNode;

            } else {
                parent.right = newNode;
            }
            this.size++;
        }

        String log = String.format("""
                        \t + \r
                        \t size: %d\r
                        \t member name: %s\r
                        """,
                this.size, member.getName());
        MemberBST.appendLog(log);
        return null;
    }

    @Override
    public Member remove(String name) {
        assert !(name.isBlank()):"THE NAME IS EMPTY";
        Node parent = null, del, p, q = null;
        Member result;
        del = root;
        while (del != null && !del.data.getName().equals(name)) {//
            parent = del;
            if (name.compareTo(del.data.getName()) < 0)
                del = del.left;
            else
                del = del.right;
        }
        if(del != null) {
            if (del.right == null) p = del.left;
            else if (del.right.left == null) {
                p = del.right; p.left = del.left;
            } else {
                p = del.right;
                while (p.left != null) {q = p; p = p.left;}
                q.left = p.right; p.left = del.left; p.right = del.right;
            }
            if(del == root) root = p;
            else {
                assert parent != null;
                if (del.data.getName().compareTo(parent.data.getName()) < 0)
                    parent.left = p;
                else parent.right = p;
            }
            result = del.data;
        }
        else result = null;

        String log = String.format("""
                        \t - \r
                        \t size: %d\r
                        \t member name: %s\r
                        """,
                this.size, name);
        MemberBST.appendLog(log);

        return result;
    }

    @Override
    public void displayDB() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.println(node.data);
            inOrder(node.right);
        }
    }
}