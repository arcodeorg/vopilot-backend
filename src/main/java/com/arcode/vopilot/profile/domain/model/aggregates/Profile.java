package com.arcode.vopilot.profile.domain.model.aggregates;

import com.arcode.vopilot.profile.domain.model.valueobjects.Address;
import com.arcode.vopilot.profile.domain.model.valueobjects.FullName;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Profile extends AbstractAggregateRoot<Profile> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Embedded
    private FullName name;

    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "address_street")),
            @AttributeOverride(name = "number", column = @Column(name = "address_number")),
            @AttributeOverride(name = "city", column = @Column(name = "address_city")),
            @AttributeOverride(name = "zipCode", column = @Column(name = "address_zip_code")),
            @AttributeOverride(name = "country", column = @Column(name = "address_country"))
    })
    @Embedded
    private Address address;

    @Email
    private String email;

    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date updatedAt;

    public Profile(String firstName, String lastName, String email, String street, String number, String city, String zipCode, String country) {
        this.name = new FullName(firstName, lastName);
        this.email = email;
        this.address = new Address(street, number, city, zipCode, country);
    }

    public void updateName(String firstName, String lastName) {
        this.name = new FullName(firstName, lastName);
    }

    public void updateEmail(String email) {
        this.email = email;
    }

    public void updateAddress(String streetAddress, String city, String zipCode, String country) {
        this.address = new Address(streetAddress, city, zipCode, country);
    }

    public String getFullName() {
        return name.getFullName();
    }

    public String getAddress() {
        return address.getAddress();
    }


    public String getEmailAddress() {
        return email;
    }
}
