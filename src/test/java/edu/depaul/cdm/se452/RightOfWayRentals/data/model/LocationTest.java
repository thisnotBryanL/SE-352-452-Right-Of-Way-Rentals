package edu.depaul.cdm.se452.RightOfWayRentals.data.model;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LocationTest {

    @Test
    void testEmpty() {
        final Location location = new Location();
        assertThat(location).isEqualTo(new Location());
        assertThat(location.getId()).isZero();
        assertThat(location.getCity()).isNull();
        assertThat(location.getState()).isNull();
        assertThat(location.getZipcode()).isNull();
    }

    @Test
    void testLocation() {
        final String state = "IL";
        final String city = "Chicago";
        final String zip = "60662";
        final long id = 1;
        final Location location = new Location(id, zip, city, state);
        assertThat(location.getId()).isEqualTo(id);
        assertThat(location.getCity()).isEqualTo(city);
        assertThat(location.getState()).isEqualTo(state);
        assertThat(location.getZipcode()).isEqualTo(zip);
        assertThat(location).isEqualTo(new Location(id, zip,city,state));
    }

}