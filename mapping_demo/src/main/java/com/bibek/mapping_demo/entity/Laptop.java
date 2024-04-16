package com.bibek.mapping_demo.entity;

import jakarta.persistence.*;
import org.hibernate.engine.internal.Cascade;

@Entity
@Table(name = "laptop")
public class Laptop {

    @Id
    @SequenceGenerator(name = "laptopSequence", sequenceName = "laptopSequence", initialValue = 200, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "laptopSequence")
    @Column(name = "laptop_id")
    private int laptopId;
    @Column(name = "brand")
    private String brand;
    @Column(name = "serial_Num")
    private String modelNumber;

    @OneToOne
    @JoinColumn(
            name = "student_id",
            referencedColumnName = "student_id",
            foreignKey = @ForeignKey(name = "Student_Fk"))
    private Student student;

    public Laptop() {
    }

    public Laptop(String brand, String modelNumber, Student student) {
        this.brand = brand;
        this.modelNumber = modelNumber;
        this.student = student;
    }

    public int getLaptopId() {
        return laptopId;
    }

    public void setLaptopId(int laptopId) {
        this.laptopId = laptopId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "laptopId=" + laptopId +
                ", brand='" + brand + '\'' +
                ", modelNumber='" + modelNumber + '\'' +
                '}';
    }
}
