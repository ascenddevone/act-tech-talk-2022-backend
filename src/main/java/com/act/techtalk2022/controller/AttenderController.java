package com.act.techtalk2022.controller;

import com.act.techtalk2022.controller.request.CreateAttenderRequest;
import com.act.techtalk2022.controller.request.UpdateAttenderRequest;
import com.act.techtalk2022.controller.response.CreateAttenderResponse;
import com.act.techtalk2022.controller.response.GeneralResponse;
import com.act.techtalk2022.controller.response.GetAllAttenderResponse;
import com.act.techtalk2022.factory.ResponseFactory;
import com.act.techtalk2022.service.AttenderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Description;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class AttenderController {

    private final AttenderService attenderService;

    private final ResponseFactory responseFactory;


    @Description("Adds new an attender")
    @PostMapping(
            value = "/attenders",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<GeneralResponse<CreateAttenderResponse>> addAttender(
            @RequestBody CreateAttenderRequest request) {
        log.info("========== Start to add new an attender  ==========");

        //Your code is here
        log.info("========== End to add new an attender  ==========");
        return null;
    }

    @Description("Adds new attender")
    @GetMapping(
            value = "/attenders",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<GeneralResponse<GetAllAttenderResponse>> getAllAttenders() {
        log.info("========== Start to get all attender  ==========");

        //Your code is here

        log.info("========== End to get all attender  ==========");
        return null;
    }

    @Description("Update an attender")
    @PutMapping(
            value = "/attenders/{id}",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<GeneralResponse<Object>> updateAttender(
            @PathVariable("id") Integer attenderId,
            @RequestBody UpdateAttenderRequest request) {
        log.info("========== Start to update an attender  ==========");

        //Your code is here

        log.info("========== End to update an attender  ==========");
        return null;
    }

    @Description("Delete an attender")
    @DeleteMapping(
            value = "/attenders/{id}",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<GeneralResponse<Object>> deleteAttender(
            @PathVariable("id") Integer attenderId) {
        log.info("========== Start to delete an attender  ==========");

        //Your code is here

        log.info("========== End to delete an attender  ==========");
        return null;
    }
}