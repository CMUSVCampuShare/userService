package com.campushare.userservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "address")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private String addressname; // corresponding to username
    private String streetAddress;
    private String aptNumber;
    private String city;
    private String state;
    private String zipcode;
}
