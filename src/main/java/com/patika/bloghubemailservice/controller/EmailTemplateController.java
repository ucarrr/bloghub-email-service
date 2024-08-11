package com.patika.bloghubemailservice.controller;

import com.patika.bloghubemailservice.model.enums.EmailTemplate;
import com.patika.bloghubemailservice.service.EmailService;
import com.patika.bloghubemailservice.service.EmailServiceTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/email-templates")
public class EmailTemplateController {

    private final EmailServiceTemplate emailServiceTemplate;

    @PostMapping("/{email-template}")
    public EmailTemplate createTemplate(@PathVariable("email-template") EmailTemplate emailTemplate,
                                        @RequestBody String templateContent) {
        return emailServiceTemplate.createTemplate(emailTemplate,templateContent);

    }
}
