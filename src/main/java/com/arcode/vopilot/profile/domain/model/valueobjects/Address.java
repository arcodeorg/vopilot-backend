package com.arcode.vopilot.profile.domain.model.valueobjects;

public record Address(
        String street,
        String number,
        String city,
        String zipCode,
        String country
) {
    public Address() {
        this(null, null, null, null, null);
    }

    public Address(String street, String city, String zipCode, String country) {
        this(street, null, city, zipCode, country);
    }

    public Address {
        if (street == null || street.isBlank()) {
            throw new IllegalArgumentException("Street must not be null or blank");
        }

        if (city == null || city.isBlank()) {
            throw new IllegalArgumentException("City must not be null or blank");
        }

        if (zipCode == null || zipCode.isBlank()) {
            throw new IllegalArgumentException("Zip code must not be null or blank");
        }

        if (country == null || country.isBlank()) {
            throw new IllegalArgumentException("Country must not be null or blank");
        }
    }

    public String getAddress() {
        return String.format("%s %s %s %s %s", street, number, city, zipCode, country);
    }
}
