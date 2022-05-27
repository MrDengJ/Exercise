package CHC5223.PartA;

public class Test {
    static IMemberDB db = new MemberBST();

    public static void main(String[] args) {
        db.put(new Member("b", "b"));
        db.put(new Member("a", "a"));
        db.put(new Member("c", "c"));
        System.out.println("that deleting a leaf node works correctly");
        db.displayDB();
        db.remove("a");

        System.out.println("that deleting a node with one descendant works correctly");
        db.displayDB();
        db.remove("b");

        System.out.println("that deleting a node with two descendants works correctly");
        db.put(new Member("b", "b"));
        db.put(new Member("e", "e"));
        db.displayDB();
        db.remove("c");
    }
}
