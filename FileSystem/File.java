package FileSystem;

class File implements FileSystem {
    String name;
    String content;

    public File(String name) {
        this.name = name;
        this.content = "";
    }
}