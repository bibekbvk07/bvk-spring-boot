package com.bibek.spring_mvc_validation.model;

import com.bibek.spring_mvc_validation.validation.CourseCode;
import jakarta.validation.constraints.*;

public class Customer {
    /**
     * ^: Asserts the start of the string.
     * [a-zA-Z]+: Matches one or more letters (both uppercase and lowercase).
     * $: Asserts the end of the string.
     */

    @NotNull(message = "is required")
    @Size(min=1, message = "is required")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "accepts only letters")
    private String firstName;
    @NotNull(message = "is required")
    @Size(min=1, message = "is required")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "accepts only letters")
    private String lastName;

    @NotNull(message = "is required")
    @Min(value = 0, message = "value should be equal or greater")
    @Max(value = 10, message = "value should be equal or lesser")
    private Integer freePasses;

    @Pattern(regexp = "^[0-9]{5}", message = "only 5 digits")
    private String postalCode;

    @CourseCode(value = "BVK", message = "should start with LUV")
    @Pattern(regexp = "^[BVK]{3}[0-9]{3}$",message = "invalid")
    private String courseCode;

    public Customer() {
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

    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
}
