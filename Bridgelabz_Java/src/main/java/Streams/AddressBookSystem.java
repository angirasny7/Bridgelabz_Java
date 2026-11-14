
package Streams;

import java.util.*;
import java.util.stream.Collectors;

/*
 * Problem: Address Book System
 * Implement UC 1 to UC 12 to manage contacts and multiple address books.
 * Use Collections and Java Streams for searching, grouping, counting, and sorting.
 */

public class AddressBookSystem {

    // UC 1: Contact class
    static class Contact {
        String firstName;
        String lastName;
        String address;
        String city;
        String state;
        String zip;
        String phoneNumber;
        String email;

        Contact(String firstName, String lastName, String address,
                String city, String state, String zip,
                String phoneNumber, String email) {

            this.firstName = firstName;
            this.lastName = lastName;
            this.address = address;
            this.city = city;
            this.state = state;
            this.zip = zip;
            this.phoneNumber = phoneNumber;
            this.email = email;
        }

        String getFullName() {
            return firstName + " " + lastName;
        }

        // UC 7: Compare contacts using first and last name
        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }

            if (!(obj instanceof Contact)) {
                return false;
            }

            Contact other = (Contact) obj;

            return firstName.equalsIgnoreCase(other.firstName)
                    && lastName.equalsIgnoreCase(other.lastName);
        }

        @Override
        public int hashCode() {
            return Objects.hash(
                    firstName.toLowerCase(),
                    lastName.toLowerCase()
            );
        }

        @Override
        public String toString() {
            return "\nName: " + getFullName()
                    + "\nAddress: " + address
                    + "\nCity: " + city
                    + "\nState: " + state
                    + "\nZIP: " + zip
                    + "\nPhone: " + phoneNumber
                    + "\nEmail: " + email;
        }
    }

    // UC 5: AddressBook maintains multiple contacts
    static class AddressBook {
        String bookName;
        List<Contact> contacts = new ArrayList<>();

        AddressBook(String bookName) {
            this.bookName = bookName;
        }

        // UC 2 and UC 7: Add contact after checking duplicates
        boolean addContact(Contact contact) {

            boolean duplicate = contacts.stream()
                    .anyMatch(existing -> existing.equals(contact));

            if (duplicate) {
                return false;
            }

            contacts.add(contact);
            return true;
        }

        // UC 3: Edit an existing contact by name
        boolean editContact(String name, Contact updatedContact) {

            Optional<Contact> existingContact = contacts.stream()
                    .filter(contact ->
                            contact.getFullName().equalsIgnoreCase(name))
                    .findFirst();

            if (existingContact.isPresent()) {
                Contact contact = existingContact.get();

                contact.firstName = updatedContact.firstName;
                contact.lastName = updatedContact.lastName;
                contact.address = updatedContact.address;
                contact.city = updatedContact.city;
                contact.state = updatedContact.state;
                contact.zip = updatedContact.zip;
                contact.phoneNumber = updatedContact.phoneNumber;
                contact.email = updatedContact.email;

                return true;
            }

            return false;
        }

        // UC 4: Delete a contact by name
        boolean deleteContact(String name) {
            return contacts.removeIf(contact ->
                    contact.getFullName().equalsIgnoreCase(name));
        }

        void displayContacts() {
            if (contacts.isEmpty()) {
                System.out.println("No contacts available.");
                return;
            }

            contacts.forEach(System.out::println);
        }
    }

    // UC 6: Maintain multiple address books
    static Map<String, AddressBook> addressBooks = new HashMap<>();

    static Scanner scanner = new Scanner(System.in);

    // Read contact details from console
    static Contact readContact() {

        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter Address: ");
        String address = scanner.nextLine();

        System.out.print("Enter City: ");
        String city = scanner.nextLine();

        System.out.print("Enter State: ");
        String state = scanner.nextLine();

        System.out.print("Enter ZIP: ");
        String zip = scanner.nextLine();

        System.out.print("Enter Phone Number: ");
        String phone = scanner.nextLine();

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        return new Contact(firstName, lastName, address,
                city, state, zip, phone, email);
    }

    // Get an address book by name
    static AddressBook getAddressBook() {

        System.out.print("Enter Address Book Name: ");
        String name = scanner.nextLine();

        AddressBook book = addressBooks.get(name);

        if (book == null) {
            System.out.println("Address Book not found.");
        }

        return book;
    }

    // UC 8: Search contacts across all address books by city or state
    static void searchByCityOrState() {

        System.out.println("1. Search by City");
        System.out.println("2. Search by State");
        System.out.print("Choose option: ");

        int choice = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter search value: ");
        String value = scanner.nextLine();

        List<Contact> result = addressBooks.values().stream()
                .flatMap(book -> book.contacts.stream())
                .filter(contact -> choice == 1
                        ? contact.city.equalsIgnoreCase(value)
                        : contact.state.equalsIgnoreCase(value))
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            System.out.println("No matching contacts found.");
        } else {
            result.forEach(System.out::println);
        }
    }

    // UC 9: Group contacts by city or state
    static void groupByCityOrState() {

        System.out.println("1. Group by City");
        System.out.println("2. Group by State");
        System.out.print("Choose option: ");

        int choice = Integer.parseInt(scanner.nextLine());

        Map<String, List<Contact>> groupedContacts =
                addressBooks.values().stream()
                        .flatMap(book -> book.contacts.stream())
                        .collect(Collectors.groupingBy(contact ->
                                choice == 1 ? contact.city : contact.state));

        groupedContacts.forEach((location, contacts) -> {
            System.out.println("\n" + location + ":");

            contacts.forEach(contact ->
                    System.out.println(contact.getFullName()));
        });
    }

    // UC 10: Count contacts by city or state
    static void countByCityOrState() {

        System.out.println("1. Count by City");
        System.out.println("2. Count by State");
        System.out.print("Choose option: ");

        int choice = Integer.parseInt(scanner.nextLine());

        Map<String, Long> countMap =
                addressBooks.values().stream()
                        .flatMap(book -> book.contacts.stream())
                        .collect(Collectors.groupingBy(
                                contact -> choice == 1
                                        ? contact.city : contact.state,
                                Collectors.counting()
                        ));

        countMap.forEach((location, count) ->
                System.out.println(location + " : " + count));
    }

    // UC 11: Sort contacts alphabetically by person's name
    static void sortByName() {

        List<Contact> sortedContacts =
                addressBooks.values().stream()
                        .flatMap(book -> book.contacts.stream())
                        .sorted(Comparator.comparing(
                                Contact::getFullName,
                                String.CASE_INSENSITIVE_ORDER))
                        .collect(Collectors.toList());

        System.out.println("\nContacts sorted by name:");

        sortedContacts.forEach(System.out::println);
    }

    // UC 12: Sort contacts by city, state, or ZIP
    static void sortByCityStateOrZip() {

        System.out.println("1. Sort by City");
        System.out.println("2. Sort by State");
        System.out.println("3. Sort by ZIP");
        System.out.print("Choose option: ");

        int choice = Integer.parseInt(scanner.nextLine());

        Comparator<Contact> comparator;

        switch (choice) {
            case 1:
                comparator = Comparator.comparing(
                        contact -> contact.city,
                        String.CASE_INSENSITIVE_ORDER);
                break;

            case 2:
                comparator = Comparator.comparing(
                        contact -> contact.state,
                        String.CASE_INSENSITIVE_ORDER);
                break;

            case 3:
                comparator = Comparator.comparing(contact -> contact.zip);
                break;

            default:
                System.out.println("Invalid choice.");
                return;
        }

        List<Contact> sortedContacts =
                addressBooks.values().stream()
                        .flatMap(book -> book.contacts.stream())
                        .sorted(comparator)
                        .collect(Collectors.toList());

        sortedContacts.forEach(System.out::println);
    }

    // Main menu
    public static void main(String[] args) {

        while (true) {

            System.out.println("\n========== ADDRESS BOOK SYSTEM ==========");
            System.out.println("1. Create Address Book");
            System.out.println("2. Add Contact");
            System.out.println("3. Edit Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Display Contacts");
            System.out.println("6. Display Address Books");
            System.out.println("7. Search by City or State");
            System.out.println("8. Group Contacts by City or State");
            System.out.println("9. Count Contacts by City or State");
            System.out.println("10. Sort Contacts by Name");
            System.out.println("11. Sort Contacts by City, State or ZIP");
            System.out.println("12. Exit");
            System.out.print("Enter your choice: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {

                // UC 6: Create a uniquely named address book
                case 1:
                    System.out.print("Enter new Address Book Name: ");
                    String bookName = scanner.nextLine();

                    if (addressBooks.containsKey(bookName)) {
                        System.out.println("Address Book already exists.");
                    } else {
                        addressBooks.put(bookName,
                                new AddressBook(bookName));
                        System.out.println("Address Book created successfully.");
                    }
                    break;

                // UC 2 and UC 5: Add contacts
                case 2:
                    AddressBook addBook = getAddressBook();

                    if (addBook != null) {
                        Contact newContact = readContact();

                        if (addBook.addContact(newContact)) {
                            System.out.println("Contact added successfully.");
                        } else {
                            System.out.println("Duplicate contact! Not added.");
                        }
                    }
                    break;

                // UC 3: Edit contact
                case 3:
                    AddressBook editBook = getAddressBook();

                    if (editBook != null) {
                        System.out.print("Enter contact name to edit: ");
                        String editName = scanner.nextLine();

                        System.out.println("Enter updated details:");
                        Contact updatedContact = readContact();

                        if (editBook.editContact(editName, updatedContact)) {
                            System.out.println("Contact updated successfully.");
                        } else {
                            System.out.println("Contact not found.");
                        }
                    }
                    break;

                // UC 4: Delete contact
                case 4:
                    AddressBook deleteBook = getAddressBook();

                    if (deleteBook != null) {
                        System.out.print("Enter contact name to delete: ");
                        String deleteName = scanner.nextLine();

                        if (deleteBook.deleteContact(deleteName)) {
                            System.out.println("Contact deleted successfully.");
                        } else {
                            System.out.println("Contact not found.");
                        }
                    }
                    break;

                // Display contacts in a selected address book
                case 5:
                    AddressBook displayBook = getAddressBook();

                    if (displayBook != null) {
                        displayBook.displayContacts();
                    }
                    break;

                // UC 6: Display all address book names
                case 6:
                    if (addressBooks.isEmpty()) {
                        System.out.println("No Address Books available.");
                    } else {
                        addressBooks.keySet().forEach(System.out::println);
                    }
                    break;

                // UC 8
                case 7:
                    searchByCityOrState();
                    break;

                // UC 9
                case 8:
                    groupByCityOrState();
                    break;

                // UC 10
                case 9:
                    countByCityOrState();
                    break;

                // UC 11
                case 10:
                    sortByName();
                    break;

                // UC 12
                case 11:
                    sortByCityStateOrZip();
                    break;

                case 12:
                    System.out.println("Exiting Address Book System.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
