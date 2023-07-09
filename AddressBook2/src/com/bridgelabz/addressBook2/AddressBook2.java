package com.bridgelabz.addressBook2;
//UC2
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
    private List<Contact> conctacts;
    public AddressBook2(){
    this.conctacts=new ArrayList<>();
    }
    public void addContact(Contact contact){
        conctacts.add(contact);
    }
    public void displayContacts(){
        for(Contact contact: conctacts){
            System.out.println(contact.toString());
        }
    }
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book program.");
        AddressBook2 addressBook = new AddressBook2();

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first name: ");
        String firstName =sc.nextLine();
        System.out.print("Enter last name: ");
        String lastName =sc.nextLine();
        System.out.print("Address: ");
        String address = sc.nextLine();
        System.out.print("City: ");
        String city = sc.nextLine();
        System.out.print("State: ");
        String state = sc.nextLine();
        System.out.print("Enter zip code: ");
        String zip = sc.nextLine();
        System.out.print("Enter email: ");
        String email =sc.nextLine();
        System.out.print("Enter phone: ");
        long phone=sc.nextLong();




       Contact contact = new Contact(firstName,lastName,address,city,state,zip,phone,email);
       addressBook.addContact(contact);
        System.out.println("\nAdded contact details: ");
        addressBook.displayContacts();
//        Contact contact2 = new Contact("Tom", "Hanks", "Beverly Hills","San Francisco","California","367890",907943456,"johnwick@gmail.com");
//        System.out.println(contact.toString());
//        System.out.println(contact2.toString());
    }
}
