package com.act.techtalk2022.service;

import com.act.techtalk2022.controller.request.CreateAttenderRequest;
import com.act.techtalk2022.controller.request.UpdateAttenderRequest;
import com.act.techtalk2022.repository.AttenderRepository;
import com.act.techtalk2022.repository.enitiy.AttenderEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

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
        entity.setFullName(request.getFullName());
        entity.setIsJoinExperienceSection(request.getIsJoinExperienceSection());
        entity.setMonthsOfExperience(request.getMonthsOfExperience());
        entity.setOrganization(request.getOrganization());
        entity.setRole(request.getRole());
        return attenderRepository.save(entity);
    }

    public List<AttenderEntity> getAllAttenders() {
        return attenderRepository.findAll();
    }

    public void updateAttender(Integer attenderId, UpdateAttenderRequest request) {
        AttenderEntity entity = attenderRepository.getOne(attenderId);

        entity.setFullName(request.getFullName());
        entity.setEmail(request.getEmail());
        entity.setDateOfBirth(request.getDateOfBirth());
        entity.setAvatar(request.getAvatar());
        entity.setOrganization(request.getOrganization());
        entity.setRole(request.getRole());
        entity.setMonthsOfExperience(request.getMonthsOfExperience());
        entity.setIsJoinExperienceSection(request.getIsJoinExperienceSection());

        attenderRepository.save(entity);
    }

    public void deleteAttender(Integer attenderId) {
        return;
    }
}
