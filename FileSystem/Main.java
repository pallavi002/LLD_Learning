package FileSystem;

class Main {
    public static void main(String[] args) {
        Directory root = new Directory("root");
        root.mkdir("dir1");
        root.mkdir("dir2");

        File file1 = new File("file1.txt");
        root.children.add(file1);
        root.ls();
    }
}