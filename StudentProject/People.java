package StudentProject;

import java.util.Scanner;

abstract public class People {
    private String name;
    private String birth;
    private String address;
    private int gender;
    private String mail;
    private long PhoneNumber;
    public People(String name, String birth, String address, int gender, String mail, long phoneNumber) {
        this.name = name;
        this.birth = birth;
        this.address = address;
        this.gender = gender;
        this.mail = mail;
        this.PhoneNumber = phoneNumber;
    }
    
    public People()
    {
        this.name = "";
        this.birth = "";
        this.address = "";
        this.gender = 0;
        this.PhoneNumber = 0;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getBirth() {
        return birth;
    }
    public void setBirth(String birth) {
        this.birth = birth;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public int isGender() {
        return gender;
    }
    public void setGender(int gender) {
        this.gender = gender;
    }
    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
    public long getPhoneNumber() {
        return PhoneNumber;
    }
    public void setPhoneNumber(int phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public void input()
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter name: ");
        name = sc.nextLine();
        

        System.out.println("Enter birth: (dd/mm/yy) ");
        birth = sc.nextLine(); 
        
        System.out.println("Enter address: ");
        address = sc.nextLine();

        System.out.println("Enter gender: (1 : Male/2 : Female)" );
        gender = sc.nextInt();
        
        sc.nextLine();

        System.out.println("Enter mail: ");
        mail = sc.nextLine();
        

        System.out.println("Enter phone number: ");
        PhoneNumber = sc.nextLong();
    }

    public void output() {
    System.out.printf("Name: %s | Birth: %s | Address: %s | Gender: %s | Mail: %s | Phone Number: %d%n",
            getName(), getBirth(), getAddress(), (isGender() == 1) ? "Male" : "Female", getMail(), getPhoneNumber());
}
}
