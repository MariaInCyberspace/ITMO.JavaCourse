package maria.incyberspace.Lesson06;

// Ex. 3
// Create a Tree class with three types of constructor methods

// Enum to be used to assign status to a Tree object using a constructor that takes 3 parameters
enum Status {
    ALIVE, DEAD
}

public class Tree {
    private String name;
    private int age;
    private Status status;

    // Constructor with 2 parameters
    public Tree(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Constructor with 3 parameters
    public Tree(String name, int age, Status status) {
        this.name = name;
        this.age = age;
        this.status = status;
    }

    // Constructor with no parameters
    public Tree() {
        System.out.println("This is an empty constructor.");
    }


    @Override
    public String toString() {
        return "Tree: " + this.name +
                " , age=" + age +
                ", status=" + status;
    }
}

class TestTree {
    public static void main(String[] args) {
        // Instantiate and initialize Tree objects using different constructors
        Tree majorOak = new Tree("Major Oak", 1000, Status.ALIVE);
        Tree bodhiOriginal = new Tree("Bodhi Tree", 500);
        Tree japaneseCherry = new Tree(); // "This is an empty constructor"

        System.out.println(majorOak);
        System.out.println(bodhiOriginal);
    }
}
