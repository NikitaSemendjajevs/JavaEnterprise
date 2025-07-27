package PhoneBook;

import java.util.Date;

public final class Contact implements Comparable<Contact> {

    private final String name;
    private final long phoneNumber;
    private final Date dateAdded;

    public Contact(final String name, final long phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        dateAdded = new Date();
    }

    public String getName() {
        return name;
    }

    public String getDateAdded() {
        return dateAdded.toString();
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return name + " : " + phoneNumber;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        return result * 31 * Long.hashCode(phoneNumber);
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        } else if (that instanceof Contact thatContact) {
            return name.equals(thatContact.getName()) && phoneNumber == thatContact.phoneNumber;
        }
        return false;
    }

    @Override
    public int compareTo(Contact o) {
        return dateAdded.compareTo(o.dateAdded);
    }
}
