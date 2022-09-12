package com.act.techtalk2022.controller;

import com.act.techtalk2022.controller.request.CreateAttenderRequest;
import com.act.techtalk2022.controller.request.UpdateAttenderRequest;
import com.act.techtalk2022.controller.response.AttenderResponse;
import com.act.techtalk2022.controller.response.CreateAttenderResponse;
import com.act.techtalk2022.controller.response.GeneralResponse;
import com.act.techtalk2022.controller.response.GetAllAttenderResponse;
import com.act.techtalk2022.factory.ResponseFactory;
import com.act.techtalk2022.repository.enitiy.AttenderEntity;
import com.act.techtalk2022.service.AttenderService;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Description;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@Slf4j
public class AttenderController {

    private static final String SIMPLE_DATE_FORMAT = "yyyy-MM-dd";
    private final AttenderService attenderService;

    private final ResponseFactory responseFactory;

    @Description("get API version")
    @GetMapping(value = "/")
    public ResponseEntity<?> version() {
        return ResponseEntity.status(HttpStatus.OK).body(Instant.now() + ": Ascend Tech talk 2022");
    }

    @Description("Adds new an attender")
    @PostMapping(
            value = "/attenders",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<GeneralResponse<CreateAttenderResponse>> addAttender(
            @RequestBody CreateAttenderRequest request) {
        log.info("========== Start to add new an attender  ==========");

        AttenderEntity entity = attenderService.createAttender(request);

        log.info("========== End to add new an attender  ==========");
        return responseFactory.success(
                new CreateAttenderResponse(entity.getId()),
                CreateAttenderResponse.class);
    }

    @Description("Adds new attender")
    @GetMapping(
            value = "/attenders",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<GeneralResponse<GetAllAttenderResponse>> getAllAttenders() {
        log.info("========== Start to get all attender  ==========");

        List<AttenderEntity> entities = attenderService.getAllAttenders();

        DateFormat simpleDateFormat = new SimpleDateFormat(SIMPLE_DATE_FORMAT);

        List<AttenderResponse> attenderResponses = entities.stream()
                .map(entity -> {
                    AttenderResponse response = new AttenderResponse();

                    response.setId(entity.getId());
                    response.setFullName(entity.getFullName());
                    response.setEmail(entity.getEmail());
                    response.setDateOfBirth(ObjectUtils.isEmpty(entity.getDateOfBirth()) ? null : simpleDateFormat.format(entity.getDateOfBirth()));
                    response.setAvatar(entity.getAvatar());
                    response.setOrganization(entity.getOrganization());
                    response.setRole(entity.getRole());
                    response.setMonthsOfExperience(entity.getMonthsOfExperience());
                    response.setIsJoinExperienceSection(entity.getIsJoinExperienceSection());
                    return response;
                })
                .collect(Collectors.toList());

        log.info("========== End to get all attender  ==========");
        return responseFactory.success(
                new GetAllAttenderResponse(attenderResponses),
                GetAllAttenderResponse.class
        );
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

        attenderService.updateAttender(attenderId, request);

        log.info("========== End to update an attender  ==========");
        return responseFactory.success();
    }

    @Description("Delete an attender")
    @DeleteMapping(
            value = "/attenders/{id}",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<GeneralResponse<Object>> deleteAttender(
            @PathVariable("id") Integer attenderId) {
        log.info("========== Start to delete an attender  ==========");

        attenderService.deleteAttender(attenderId);

        log.info("========== End to delete an attender  ==========");
        return responseFactory.success();
    }
}