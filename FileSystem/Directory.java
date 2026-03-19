package FileSystem;

class Directory implements FileSystem {
    String name;
    List<FileSystem> children;

    public Directory(String name) {
        this.name = name;
        this.children = new ArrayList<>();
    }

    public void ls() {
        for (FileSystem child : children) {
            System.out.println(child.name);
        }
    }

    public void mkdir(String dirName) {
        Directory newDir = new Directory(dirName);
        children.add(newDir);
    }
}