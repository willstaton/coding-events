package org.launchcode.codingevents.models;

import javax.persistence.Entity;
import javax.validation.constraints.*;

/**
 * Created by Chris Bay
 */
@Entity
public class Event extends AbstractEntity {

    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    private String name;

    @Size(max = 500, message = "Description too long")
    private String description;

    @NotBlank(message = "E-mail is required")
    @Email(message = "Invalid e-mail. Try again")
    private String contactEmail;

    @NotBlank(message = "Location is required")
    @NotNull(message = "Can't be null?")
    private String location;

    private boolean regRequired;

    @DecimalMin(value = "1", message = "Must be greater than 0")
    private int noOfAttendees;

    public Event(String name, String description, String contactEmail, String location, boolean regRequired, int noOfAttendees) {
        this.name = name;
        this.description = description;
        this.contactEmail = contactEmail;
        this.location = location;
        this.regRequired = regRequired;
        this.noOfAttendees = noOfAttendees;
    }

    public Event() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isRegRequired() {
        return regRequired;
    }

    public void setRegRequired(boolean regRequired) {
        this.regRequired = regRequired;
    }

    public int getNoOfAttendees() {
        return noOfAttendees;
    }

    public void setNoOfAttendees(int noOfAttendees) {
        this.noOfAttendees = noOfAttendees;
    }


    @Override
    public String toString() {
        return name;
    }


}
