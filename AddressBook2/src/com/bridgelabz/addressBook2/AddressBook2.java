package com.bridgelabz.addressBook2;
//UC3
import java.util.*;

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
}
 class AddressBook2 {
    private List<Contact> contacts;
    public AddressBook2(){
    this.contacts=new ArrayList<>();
    }
    public void addContact(Contact contact){
        contacts.add(contact);
    }
    public void displayContacts(){
        for(Contact contact: contacts){
            System.out.println(contact.toString());
        }

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

            }
        }
         System.out.println("Contact with "+firstName+ " not found.");
     }
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book program.");
        AddressBook2 addressBook = new AddressBook2();
        Contact contact1 = new Contact("John", "Doe", "123 Main St", "City", "State", "12345", 1234567890, "john@example.com");
        Contact contact2 = new Contact("Jane", "Smith", "456 Park Ave", "Town", "State", "56789", 9876543210L, "jane@example.com");

        addressBook.addContact(contact1);
        addressBook.addContact(contact2);

        System.out.println("Contents of the contact book: ");
        addressBook.displayContacts();

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the first name of the contact to edit: ");
        String firstName=sc.nextLine();
        addressBook.editContact(firstName);
        System.out.println("\nUpdated contact details are: ");
        addressBook.displayContacts();

    }
}
