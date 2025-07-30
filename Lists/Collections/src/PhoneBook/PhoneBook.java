package PhoneBook;

import java.util.*;
import java.util.function.Consumer;

public class PhoneBook implements Iterable<Contact> {

    private final String phoneBookName;
    private final ArrayList<Contact> contacts;

    public PhoneBook(final String phoneBookName) {
        this.phoneBookName = phoneBookName;
        contacts = new ArrayList<>();
    }

    public final void addContact(final String name, final long phoneNumber) {
        contacts.add(new Contact(name, phoneNumber));
    }

    public final void addContact(Contact contact) {
        contacts.add(contact);
    }

    public final String getPhoneBookName() {
        return phoneBookName;
    }

    public final Contact find(String name) throws ContactIsNotFoundException {
        for (Contact contact: contacts) {
            if(contact.getName().equals(name)) {
                return contact;
            }
        }
        throw new ContactIsNotFoundException("PhoneBook.Contact " + name + " hasn't been found.");
    }

    public final List<Contact> findAll(String name) {
        List<Contact> listToReturn = new ArrayList<>();
        for (Contact contact: contacts) {
            if (contact.getName().equals(name)) {
                listToReturn.add(contact);
            }
        }
        return listToReturn;
    }

    public void sortByDate() {
         Collections.sort(contacts);
    }

    @Override
    public Iterator<Contact> iterator() {
        return new Iterator<Contact>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < contacts.size();
            }

            @Override
            public Contact next() {
                return contacts.get(index++);
            }
        };
    }

    @Override
    public void forEach(Consumer<? super Contact> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<Contact> spliterator() {
        return Iterable.super.spliterator();
    }

    @Override
    public String toString() {
        System.out.println("The list of all contacts in " + phoneBookName + "\n" +
                "----------------------------------");
        for (Contact contact : contacts) {
            System.out.println("PhoneBook.Contact: " + contact);
        }
        return "----------------------------------";
    }

    @Override
    public int hashCode() {
        int result = phoneBookName.hashCode();
        for (Contact contact : contacts) {
            result = result * 31 * contact.hashCode();
        }
        return result;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        } else if (that instanceof PhoneBook thatPhoneBook) {
            if (!phoneBookName.equals(thatPhoneBook.phoneBookName)) {
                return false;
            }
            int boundary = contacts.size();
            for (int i = 0; i < boundary; i++) {
                if (!contacts.get(i).equals(thatPhoneBook.contacts.get(i))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
