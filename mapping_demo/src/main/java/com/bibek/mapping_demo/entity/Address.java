package com.bibek.mapping_demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @SequenceGenerator(name = "addressSequence", sequenceName = "addressSequence", initialValue = 100 ,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "addressSequence")
    private int addressId;
    @Column(name = "street_address", nullable = false, unique = true)
    private String streetAddress;
    @Column(name = "city", nullable = false)
    private String city;
    @Column(name = "state", nullable = false, unique = false)
    private String state;
    @Column(name = "zip-code", nullable = false)
    private int postalCode;
    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "student_id", foreignKey = @ForeignKey(name = "address_student_id_fk"))
    private Student student;

    public Address() {
    }

    public Address(String streetAddress, String city, String state, int postalCode, Student student) {
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.student = student;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
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

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", streetAddress='" + streetAddress + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", postalCode=" + postalCode +
                '}';
    }
}
