package edu.depaul.cdm.se452.rightOfWayRentals.controller;

import edu.depaul.cdm.se452.rightOfWayRentals.exception.RightOfWayRentalsException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class ExceptionHandlingController {

    @ExceptionHandler
    public String error(final RightOfWayRentalsException e, final Model model) {
        model.addAttribute("exception", e.getMessage());
        return "error";
    }
}
