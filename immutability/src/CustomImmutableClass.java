public final class CustomImmutableClass {

    private final int id;
    private final String name;

    public CustomImmutableClass(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }

}
