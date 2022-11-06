package edu.depaul.cdm.se452.rightOfWayRentals.controller;

import edu.depaul.cdm.se452.rightOfWayRentals.component.SecurityHelper;
import edu.depaul.cdm.se452.rightOfWayRentals.security.CustomerUserDetails;
import edu.depaul.cdm.se452.rightOfWayRentals.service.CustomerService;
import edu.depaul.cdm.se452.rightOfWayRentals.service.ReservationService;
import edu.depaul.cdm.se452.rightOfWayRentals.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequiredArgsConstructor
public class RentalCarUIController {

    private final CustomerService customerService;
    private final ReservationService reservationService;
    private final VehicleService vehicleService;
    private final SecurityHelper securityHelper;

    @GetMapping(value = "/")
    public RedirectView redirectToHome() {
        return new RedirectView("/home");
    }

    @GetMapping("home")
    public String home(final Model model) {
        final CustomerUserDetails currentCustomer = securityHelper.getCurrentCustomer();
        model.addAttribute("username", currentCustomer.getUsername());
        return "home";
    }
}
