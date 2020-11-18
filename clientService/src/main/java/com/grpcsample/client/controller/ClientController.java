package com.grpcsample.client.controller;


import com.grpcsample.client.dto.PassBookDetails;
import com.grpcsample.client.service.PassbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientController {

    @Autowired
    private PassbookService passbookService;

    @GetMapping("/user/{userId}")
    public List<PassBookDetails> getTxnHistory(@PathVariable String userId)
    {
        return  this.passbookService.getPassBook(userId);
    }
}
