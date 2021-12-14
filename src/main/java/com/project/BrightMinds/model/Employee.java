package com.project.BrightMinds.model;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public
class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "mobile_number")
    private int mobileNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "extension_number")
    private int extensionNumber;

    @Column(name = "employment_type")

    @Enumerated(EnumType.STRING)
    private EmploymentType employmentType;


    public
    Employee() {
    }

    public
    Employee(String firstName, String middleName, String lastName, int mobileNumber, String email, int extensionNumber, EmploymentType employmentType) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.extensionNumber = extensionNumber;
        this.employmentType = employmentType;
    }

    public
    long getId() {
        return id;
    }



    public
    String getFirstName() {
        return firstName;
    }

    public
    void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public
    String getMiddleName() {
        return middleName;
    }

    public
    void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public
    String getLastName() {
        return lastName;
    }

    public
    void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public
    int getMobileNumber() {
        return mobileNumber;
    }

    public
    void setMobileNumber(int mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public
    String getEmail() {
        return email;
    }

    public
    void setEmail(String email) {
        this.email = email;
    }

    public
    int getExtensionNumber() {
        return extensionNumber;
    }

    public
    void setExtensionNumber(short extensionNumber) {
        this.extensionNumber = extensionNumber;
    }

    public
    EmploymentType getEmploymentType() {
        return employmentType;
    }

    public
    void setEmploymentType(EmploymentType employmentType) {
        employmentType = employmentType;
    }
}
