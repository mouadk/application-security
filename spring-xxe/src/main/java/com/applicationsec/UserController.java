package com.applicationsec;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.data.web.JsonPath;
import org.springframework.data.web.ProjectedPayload;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.xmlbeam.annotation.XBRead;


@RestController
class UserController {

    @PostMapping(value = "/")
    HttpEntity<String> post(@RequestBody UserPayload user) {
        return ResponseEntity
                .ok(String.format("Received firstname: %s, lastname: %s", user.getFirstname(), user.getLastname()));
    }

    @ProjectedPayload
    public interface UserPayload {

        @XBRead("//firstname")
        @JsonPath("$..firstname")
        String getFirstname();

        @XBRead("//lastname")
        @JsonPath("$..lastname")
        String getLastname();
    }

}