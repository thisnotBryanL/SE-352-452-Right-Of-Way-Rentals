package edu.depaul.cdm.se452.rightOfWayRentals.service;

import edu.depaul.cdm.se452.rightOfWayRentals.data.model.Customer;
import edu.depaul.cdm.se452.rightOfWayRentals.data.model.CustomerCredentials;
import edu.depaul.cdm.se452.rightOfWayRentals.data.repository.CustomerCredentialsRepository;
import edu.depaul.cdm.se452.rightOfWayRentals.data.repository.CustomerRepository;
import edu.depaul.cdm.se452.rightOfWayRentals.security.CustomerUserDetails;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerUserDetailsService implements UserDetailsService {
    private final CustomerRepository customerRepository;
    private final CustomerCredentialsRepository credentialsRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.trace("Attempting to retrieve customer with username : {}", username);
        final CustomerCredentials customerCredentials = credentialsRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Customer details not found for the username : " + username));
        log.trace("Customer credentials found : {}", customerCredentials);
        final Customer customer = customerRepository.findById(customerCredentials.getCustomerId())
                .orElseThrow(() -> new UsernameNotFoundException("Customer no longer exists in the database : " + username));
        log.trace("Found customer : {}", customer);
        return new CustomerUserDetails(customerCredentials, customer);
    }
}
