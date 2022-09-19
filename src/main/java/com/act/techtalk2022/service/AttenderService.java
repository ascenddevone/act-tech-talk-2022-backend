package com.act.techtalk2022.service;

import com.act.techtalk2022.constant.ExceptionConstant;
import com.act.techtalk2022.controller.request.CreateAttenderRequest;
import com.act.techtalk2022.controller.request.UpdateAttenderRequest;
import com.act.techtalk2022.exception.CommonException;
import com.act.techtalk2022.repository.AttenderRepository;
import com.act.techtalk2022.repository.enitiy.AttenderEntity;
import com.act.techtalk2022.util.CommonUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class AttenderService {

    private final AttenderRepository attenderRepository;

    public AttenderEntity createAttender(CreateAttenderRequest request) {
        AttenderEntity entity = new AttenderEntity();
        entity.setAvatar(request.getAvatar());
        entity.setEmail(request.getEmail());
        entity.setDateOfBirth(request.getDateOfBirth());
        entity.setIsJoinExperienceSection(request.getIsJoinExperienceSection());
        entity.setRole(request.getRole());
        entity.setOrganization(request.getOrganization());
        entity.setMonthsOfExperience(request.getMonthsOfExperience());
        entity.setFullName(request.getFullName());
        //Your code is here
        return attenderRepository.save(entity);
    }

    public List<AttenderEntity> getAllAttenders() {

        //Your code is here
        return attenderRepository.findAll();

    }

    public void updateAttender(Integer attenderId, UpdateAttenderRequest request) {
        AttenderEntity entity = attenderRepository.getOne(attenderId);

        entity.setId(attenderId);
        entity.setAvatar(request.getAvatar());
        entity.setEmail(request.getEmail());
        entity.setDateOfBirth(request.getDateOfBirth());
        entity.setIsJoinExperienceSection(request.getIsJoinExperienceSection());
        entity.setRole(request.getRole());
        entity.setOrganization(request.getOrganization());
        entity.setMonthsOfExperience(request.getMonthsOfExperience());
        entity.setFullName(request.getFullName());

        attenderRepository.save(entity);
    }

    public void deleteAttender(Integer attenderId) {
        attenderRepository.deleteById(attenderId);
    }

    public void validateUpdateAttender(UpdateAttenderRequest request) {
        if (null == request.getFullName()
                || request.getFullName().isEmpty()) {
            log.error(ExceptionConstant.FULL_NAME_CANNOT_BE_BLANK_MESSAGE);

            throw new CommonException(HttpStatus.BAD_REQUEST, ExceptionConstant.BAD_REQUEST_CODE, ExceptionConstant.FULL_NAME_CANNOT_BE_BLANK_MESSAGE);
        }

        if (null == request.getEmail()
                || request.getEmail().isEmpty()
                || !CommonUtil.validate(request.getEmail())) {
            log.error(ExceptionConstant.EMAIL_CANNOT_BE_BLANK_OR_INVALID_MESSAGE);

            throw new CommonException(HttpStatus.BAD_REQUEST, ExceptionConstant.BAD_REQUEST_CODE, ExceptionConstant.EMAIL_CANNOT_BE_BLANK_OR_INVALID_MESSAGE);
        }

        if (null == request.getDateOfBirth()) {

            log.error(ExceptionConstant.DATE_OF_BIRTH_CANNOT_BE_BLANK_MESSAGE);

            throw new CommonException(HttpStatus.BAD_REQUEST, ExceptionConstant.BAD_REQUEST_CODE, ExceptionConstant.DATE_OF_BIRTH_CANNOT_BE_BLANK_MESSAGE);

        }
    }

    public void validateCreateAttender(CreateAttenderRequest request) {
        if (null == request.getFullName()
                || request.getFullName().isEmpty()) {
            log.error(ExceptionConstant.FULL_NAME_CANNOT_BE_BLANK_MESSAGE);

            throw new CommonException(HttpStatus.BAD_REQUEST, ExceptionConstant.BAD_REQUEST_CODE, ExceptionConstant.FULL_NAME_CANNOT_BE_BLANK_MESSAGE);
        }

        if (null == request.getEmail()
                || request.getEmail().isEmpty()
                || !CommonUtil.validate(request.getEmail())) {
            log.error(ExceptionConstant.EMAIL_CANNOT_BE_BLANK_OR_INVALID_MESSAGE);

            throw new CommonException(HttpStatus.BAD_REQUEST, ExceptionConstant.BAD_REQUEST_CODE, ExceptionConstant.EMAIL_CANNOT_BE_BLANK_OR_INVALID_MESSAGE);
        }

        if (null == request.getDateOfBirth()) {

            log.error(ExceptionConstant.DATE_OF_BIRTH_CANNOT_BE_BLANK_MESSAGE);

            throw new CommonException(HttpStatus.BAD_REQUEST, ExceptionConstant.BAD_REQUEST_CODE, ExceptionConstant.DATE_OF_BIRTH_CANNOT_BE_BLANK_MESSAGE);
        }
        log.info("== End to validate user==");
    }

    public void validateAttender(Integer attenderId) {
        Optional<AttenderEntity> entity = attenderRepository.findById(attenderId);

        if (!entity.isPresent()) {
            log.error(ExceptionConstant.ATTENDER_IS_NOT_FOUND_MESSAGE);
            throw new CommonException(HttpStatus.NOT_FOUND, ExceptionConstant.NOT_FOUND_CODE, ExceptionConstant.ATTENDER_IS_NOT_FOUND_MESSAGE);
        }
    }
}
