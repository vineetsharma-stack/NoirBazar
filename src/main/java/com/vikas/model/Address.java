package com.vikas.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String locality;
    private String address;
    private String city;
    private String state;
    private String pinCode;
    private String phoneNumber;
    private String mobile;

    public String getMobile() {
        return (mobile != null && !mobile.isEmpty()) ? mobile : phoneNumber;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
        if (this.phoneNumber == null || this.phoneNumber.isEmpty()) {
            this.phoneNumber = mobile;
        }
    }

    public String getPhoneNumber() {
        return (phoneNumber != null && !phoneNumber.isEmpty()) ? phoneNumber : mobile;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        if (this.mobile == null || this.mobile.isEmpty()) {
            this.mobile = phoneNumber;
        }
    }
}
