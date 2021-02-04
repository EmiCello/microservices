package app2.controller;

import app2.domains.EmailInfo;
import app2.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ValidationException;

@RestController
@RequestMapping("/mail")
public class EmailController {

    @Autowired
    EmailService emailService;

    @PostMapping(value = "/feedback")
    public void sendFeedback(@RequestBody EmailInfo emailInfo, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidationException("Feedback is not valid.");
        }
        emailService.sendEmail(emailInfo);
    }
}