package com.act.techtalk2022.service;

import com.act.techtalk2022.controller.request.CreateAttenderRequest;
import com.act.techtalk2022.controller.request.UpdateAttenderRequest;
import com.act.techtalk2022.repository.AttenderRepository;
import com.act.techtalk2022.repository.enitiy.AttenderEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
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
        List<AttenderEntity> list = attenderRepository.findAll();
        return list;

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

    public Optional<AttenderEntity> findById(Integer attenderId) {
        return attenderRepository.findById(attenderId);
    }
}
