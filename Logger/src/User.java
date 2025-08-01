public class User {

    private static int globalID = 1;

    private final String name;
    private final int ID;

    public User(final String name) {
        this.name = name; ID = globalID++;
    }

    public final String getUserName() {
        return name;
    }

    public final int getUserID() {
        return ID;
    }

    @Override
    public String toString() {
        return "User: " + name + ", ID: " + ID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o instanceof User user) {
            return name.equals(user.name) && ID == user.ID;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        return result * 31 * result * Integer.hashCode(ID);
    }

}