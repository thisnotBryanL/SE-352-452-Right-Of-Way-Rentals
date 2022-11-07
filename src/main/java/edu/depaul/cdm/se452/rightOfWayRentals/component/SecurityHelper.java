package edu.depaul.cdm.se452.rightOfWayRentals.component;

import edu.depaul.cdm.se452.rightOfWayRentals.security.CustomerUserDetails;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class SecurityHelper {
    public CustomerUserDetails getCurrentCustomer() {
        return (CustomerUserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
    }
}
