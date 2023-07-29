package com.bridgelabz.addressBook2;
//UC8 - Refactor the code to Ability to search Person in a City or State across the multiple Address Book
// - Search Result can show multiple person in the city or state

//- Use Java Streams

/*

To implement the ability to search for a person in a city or state across multiple Address Books using
 Java Streams, we can add new methods in the AddressBook2 class. These methods will perform the search
 and return a list of contacts matching the given city or state.
*/

import java.util.*;
import java.util.stream.Collectors;

class Contact{
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private long phone;
    private String email;

    public Contact(String firstName, String lastName, String address, String city, String state, String zip, long phone, String email){
        this.firstName=firstName;
        this.lastName=lastName;
        this.address=address;
        this.city=city;
        this.state=state;
        this.zip=zip;
        this.phone=phone;
        this.email=email;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    public String getZip(){
        return zip;
    }
    public void setZip(String zip){
        this.zip=zip;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString(){
    return "Contact:"+
            " First name: "+ firstName+
            " Last name: "+ lastName +
            " Address: " + address +
            " City: " + city +
            " State: "+ state +
            " Zip Code: "+zip +
            " Phone: " + phone +
            " Email: " + email;
    }
    @Override
    public boolean equals(Object obj){
        if(this == obj)
            return true;
        if(obj == null || getClass() != obj.getClass())
            return false;
        Contact other = (Contact) obj;
        return firstName.equals(other.firstName) && lastName.equals(other.lastName);
    }
    @Override
    public  int hashCode(){
        return  Objects.hash(firstName,lastName);
    }
}
 class AddressBook {
    private Set<Contact> contacts;
    public AddressBook(){
    this.contacts=new HashSet<>();
    }
    public void addContact(Contact contact){
        if(contacts.contains(contact)){
            System.out.println("Duplicate entry! Contact with same name exists.");
        }else {
            contacts.add(contact);
            System.out.println("Contact added successfully.");
        }
    }
    public void displayContacts(){
        for(Contact contact: contacts){

            System.out.println(contact.toString());
        }

    }
    public Set<Contact> getContacts(){
        return contacts;
    }
     public void editContact(String firstName){
        for(Contact contact: contacts){
            if(contact.getFirstName().equals(firstName)){
                Scanner sc = new Scanner(System.in);
                System.out.print("Enter new details for: " +firstName);
                System.out.println("Last name: ");
                String lastName =sc.nextLine();
                System.out.println("Address: ");
                String address =sc.nextLine();

                System.out.println("City : ");
                String city =sc.nextLine();
                System.out.println("State: ");
                String state =sc.nextLine();
                System.out.println("Zip: ");
                String zip =sc.nextLine();
                System.out.println("Phone: ");
                long phone =sc.nextLong();
                sc.nextLine(); // Consume newline character
                System.out.println("Email: ");
                String email =sc.nextLine();

                contact.setLastName(lastName);
                contact.setAddress(address);
                contact.setCity(city);
                contact.setState(state);
                contact.setZip(zip);
                contact.setPhone(phone);
                contact.setEmail(email);
                System.out.println("Contact details has been updated successfully.");
                return;
            }
        }
         System.out.println("Contact with "+firstName+ " not found.");
     }
     public void deleteContact(String firstNameToDelete){
       Contact contactToDelete = null;
       for (Contact contact: contacts){
           if(contact.getFirstName().equals(firstNameToDelete)){
               contactToDelete=contact;
               break;
           }
       }
       if(contactToDelete !=null){
           contacts.remove(contactToDelete);// Removing the object contact from the list using list_name.remove method
           System.out.println("Contact with first-name "+ firstNameToDelete + " has been successfully deleted. ");
       }
       else{
           System.out.println("Contact with first-name "+ firstNameToDelete + " not found. ");
       }
     }}
     public class AddressBook2{
        //Creating a map of Address book
         private Map<String, AddressBook> addressBooks;

         public AddressBook2(){
             this.addressBooks= new HashMap<>();
         }
         public void addAddressBook(String name){
             addressBooks.put(name, new AddressBook());
         }
         public void addContactToAddressBook(String bookName, Contact contact){
             AddressBook addressBook = addressBooks.get(bookName);
             if(addressBook != null){
                 addressBook.addContact(contact);
             }else{
                 System.out.println("Address book with name "+ bookName + " not found.");
             }
         }
         public void displayContactsInAddressBook(String bookName){
             AddressBook addressBook = addressBooks.get(bookName);
             if(addressBook != null){
                 addressBook.displayContacts();
             }else{
                 System.out.println("Address book with name "+ bookName + " not found.");
             }
         }
         public void editContactsInAddressBook(String bookName, String firstName){
             AddressBook addressBook = addressBooks.get(bookName);
             if(addressBook != null){
                 addressBook.editContact(firstName);
             }else{
                 System.out.println("Address book with name "+ bookName + " not found.");
             }
         }
         public void deleteContactsInAddressBook(String bookName, String firstNameToDelete){
             AddressBook addressBook = addressBooks.get(bookName);
             if(addressBook != null){
                 addressBook.deleteContact(firstNameToDelete);
             }else{
                 System.out.println("Address book with name "+ bookName + " not found.");
             }
         }
public List<Contact> searchByCity(String city){
             return addressBooks.values().stream()
                     .flatMap(addressBook -> addressBook.getContacts().stream())
                     .filter(contact -> contact.getCity().equalsIgnoreCase(city))
                     .collect(Collectors.toList());
}
         public List<Contact> searchByState(String state) {
             return addressBooks.values().stream()
                     .flatMap(addressBook -> addressBook.getContacts().stream())
                     .filter(contact -> contact.getState().equalsIgnoreCase(state))
                     .collect(Collectors.toList());
         }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        AddressBook2 addressBookSystem = new AddressBook2();
        System.out.println("Welcome to Address Book program.");

        while(true){
            System.out.println("\n Menu");
            System.out.println("1. Add a new address book.");
            System.out.println("2. Add a contact to address book.");
            System.out.println("3. Display contacts from address book.");
            System.out.println("4. Edit a contact in address book.");
            System.out.println("5. Delete a contact from address book.");
            System.out.println("6. Search a contact by city.");
            System.out.println("7. Search a contact by state.");

            System.out.println("8. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1:
                    System.out.println("Enter the name of new address book.");
                    String bookName = sc.nextLine();
                    addressBookSystem.addAddressBook(bookName);
                    break;
                case 2:
                    System.out.println("Enter the name of address book to add contact.");
                    String addBookName = sc.nextLine();

                    System.out.println("Enter first name");
                    String firstName = sc.nextLine();
                    System.out.println("Enter last name");
                    String lastName = sc.nextLine();
                    System.out.println("Enter address");
                    String address = sc.nextLine();
                    System.out.println("Enter city");
                    String city = sc.nextLine();
                    System.out.println("Enter state");
                    String state = sc.nextLine();
                    System.out.println("Enter zip");
                    String zip = sc.nextLine();
                    System.out.println("Enter phone");
                    long phone = sc.nextLong();
                    sc.nextLine(); // Consume newline character
                    System.out.println("Enter email");
                    String email = sc.nextLine();

                    // Create a new contact object with the collected details
                    Contact newContact = new Contact(firstName, lastName, address, city, state, zip, phone, email);
                    addressBookSystem.addContactToAddressBook(addBookName, newContact);
                    break;

                case 3:
                    System.out.println("Enter the name of address book to display contacts.");
                    String displayBookName = sc.nextLine();
                    addressBookSystem.displayContactsInAddressBook(displayBookName);
                    break;

                case 4:
                    System.out.println("Enter the name of contact book in which you want to update a contact");
                    String editBookName = sc.nextLine();
                    System.out.println("Enter the first name of the contact to edit");
                    String editFirstName = sc.nextLine();
                    addressBookSystem.editContactsInAddressBook(editBookName, editFirstName);
                    break;

                case 5:
                    System.out.println("Enter the name of address book containing the contact that you want to delete.");
                    String deleteBookName = sc.nextLine();
                    System.out.println("Enter the first name of the contact to delete: ");
                    String deleteFirstName = sc.nextLine();
                    addressBookSystem.deleteContactsInAddressBook(deleteBookName, deleteFirstName);
                    break;
                case 6: // New case for searching by city
                    System.out.println("Enter the city to search for contacts: ");
                    String cityToSearch = sc.nextLine();
                    List<Contact> citySearchResult = addressBookSystem.searchByCity(cityToSearch);
                    if (!citySearchResult.isEmpty()) {
                        System.out.println("Contacts in " + cityToSearch + ": ");
                        citySearchResult.forEach(System.out::println);
                    } else {
                        System.out.println("No contacts found in " + cityToSearch + ".");
                    }
                    break;
                case 7: // New case for searching by state
                    System.out.println("Enter the state to search for contacts: ");
                    String stateToSearch = sc.nextLine();
                    List<Contact> stateSearchResult = addressBookSystem.searchByState(stateToSearch);
                    if (!stateSearchResult.isEmpty()) {
                        System.out.println("Contacts in " + stateToSearch + ": ");
                        stateSearchResult.forEach(System.out::println);
                    } else {
                        System.out.println("No contacts found in " + stateToSearch + ".");
                    }
                    break;
                case 8:
                    System.out.println("Exiting the address book system.");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please try again.");

            }
        }

    }
    }

