package com.bibek.customer_crud_demo.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "address")
public class Address {

    // define a field
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "addr_id")
    private Integer addrId;
    @ManyToOne
    @JoinColumn(name = "cust_id", referencedColumnName = "id")
    private Customer customer;
    @Column(name = "street_address", nullable = false, unique = true)
    private String streetAddress;
    @Column(name = "city", nullable = false)
    private String city;
    @Column(name = "state", nullable = false, unique = true)
    private String state;
    @Column(name = "postal_code", nullable = false)
    private Integer postalCode;

    // define a no args constructor
    public Address() {
    }

    public Address(Customer customer, String streetAddress, String city, String state, Integer postalCode) {
        this.customer = customer;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
    }

    // getter and setter methods
    public Integer getAddrId() {
        return addrId;
    }

    public void setAddrId(Integer addrId) {
        this.addrId = addrId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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

    public Integer getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }

    // define a toString() methods
    @Override
    public String toString() {
        return "Address{" +
                "addrId=" + addrId +
                ", customer=" + customer +
                ", streetAddress='" + streetAddress + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", postalCode=" + postalCode +
                '}';
    }
}
