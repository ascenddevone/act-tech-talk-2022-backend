package com.act.techtalk2022.controller;

import com.act.techtalk2022.controller.request.CreateAttenderRequest;
import com.act.techtalk2022.controller.request.UpdateAttenderRequest;
import com.act.techtalk2022.controller.response.AttenderResponse;
import com.act.techtalk2022.controller.response.CreateAttenderResponse;
import com.act.techtalk2022.controller.response.GeneralResponse;
import com.act.techtalk2022.controller.response.GetAllAttenderResponse;
import com.act.techtalk2022.exception.CommonException;
import com.act.techtalk2022.factory.ResponseFactory;
import com.act.techtalk2022.repository.enitiy.AttenderEntity;
import com.act.techtalk2022.service.AttenderService;
import com.act.techtalk2022.util.CommonUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Description;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@Slf4j
public class AttenderController {

    private final AttenderService attenderService;

    private final ResponseFactory responseFactory;

    @Description("get API version")
    @GetMapping(value = "/")
    public ResponseEntity<?> version() {
        return ResponseEntity.status(HttpStatus.OK).body(Instant.now() + ": Ascend Tech talk 2022");
    }

    //region Adds attender
    @Description("Adds new an attender")
    @PostMapping(
            value = "/attenders",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<GeneralResponse<CreateAttenderResponse>> addAttender(
            @RequestBody CreateAttenderRequest request) {
        log.info("========== Start to add new an attender  ==========");

        validateCreateAttender(request);

        AttenderEntity entity = attenderService.createAttender(request);

        log.info("========== End to add new an attender  ==========");
        return responseFactory.success(
                new CreateAttenderResponse(entity.getId()),
                CreateAttenderResponse.class);
    }

    private void validateCreateAttender(CreateAttenderRequest request) {
        if (null == request.getFullName() || request.getFullName().isEmpty()) {
            log.error("The full name cannot be blank");

            throw new CommonException(HttpStatus.BAD_REQUEST, "bad_request", "The full name cannot be blank");
        }

        if (null == request.getEmail() || request.getEmail().isEmpty()) {
            log.error("The email cannot be blank or validate");

            throw new CommonException(HttpStatus.BAD_REQUEST, "bad_request", "The email cannot be blank or validate");
        }

        if (null == request.getDateOfBirth()) {

            log.error("The date of birth cannot be blank or validate");

            throw new CommonException(HttpStatus.BAD_REQUEST, "bad_request", "The date of birth cannot be blank");

        }
        log.info("== End to validate user==");
    }

    //endregion Adds attender

    //region Get all attender
    @Description("Get all attender")
    @GetMapping(
            value = "/attenders",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<GeneralResponse<GetAllAttenderResponse>> getAllAttenders() {
        log.info("========== Start to get all attender  ==========");

        List<AttenderEntity> entities = attenderService.getAllAttenders();

        List<AttenderResponse> attenderResponses = entities.stream()
                .map(entity -> {
                    AttenderResponse response = new AttenderResponse();

                    response.setId(entity.getId());
                    response.setFullName(entity.getFullName());
                    response.setEmail(entity.getEmail());
                    response.setDateOfBirth(entity.getDateOfBirth());
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
    //endregion Get all attender

    //region Update an attender

    @Description("Update an attender")
    @PutMapping(value = "/attenders/{id}")
    public ResponseEntity<GeneralResponse<Object>> updateAttender(
            @PathVariable("id") Integer attenderId,
            @RequestBody UpdateAttenderRequest request) {
        log.info("========== Start to update an attender  ==========");

        Optional<AttenderEntity> entity = attenderService.findById(attenderId);

        if(!entity.isPresent()) {
            log.error("The attender is not found");
            throw new CommonException(HttpStatus.NOT_FOUND, "not_found", "The attender is not found");
        }

        validateUpdateAttender(request);
        attenderService.updateAttender(attenderId, request);

        log.info("========== End to update an attender  ==========");
        return responseFactory.success();
    }

    private void validateUpdateAttender(UpdateAttenderRequest request) {
        if (null == request.getFullName() || request.getFullName().isEmpty()) {
            log.error("The full name cannot be blank");

            throw new CommonException(HttpStatus.BAD_REQUEST, "bad_request", "The full name cannot be blank");
        }

        if (null == request.getEmail() || request.getEmail().isEmpty()) {
            log.error("The email cannot be blank or validate");

            throw new CommonException(HttpStatus.BAD_REQUEST, "bad_request", "The email cannot be blank or validate");
        }

        if (null == request.getDateOfBirth()) {

            log.error("The date of birth cannot be blank or validate");

            throw new CommonException(HttpStatus.BAD_REQUEST, "bad_request", "The date of birth cannot be blank");

        }
    }

    //endregion Update an attender

    //region Delete an attender
    @Description("Delete an attender")
    @DeleteMapping(value = "/attenders/{id}")
    public ResponseEntity<GeneralResponse<Object>> deleteAttender(
            @PathVariable("id") Integer attenderId) {
        log.info("========== Start to delete an attender  ==========");

        Optional<AttenderEntity> entity = attenderService.findById(attenderId);

        if(!entity.isPresent()) {
            log.error("The attender is not found");
            throw new CommonException(HttpStatus.NOT_FOUND, "not_found", "The attender is not found");
        }


        attenderService.deleteAttender(attenderId);

        log.info("========== End to delete an attender  ==========");
        return responseFactory.success();
    }

    private void validateDeleteAttender(Integer attenderId) {
    }
    //endregion Delete an attender
}