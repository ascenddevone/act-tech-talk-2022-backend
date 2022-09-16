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

@Service
@Slf4j
@RequiredArgsConstructor
public class AttenderService {

    private final AttenderRepository attenderRepository;

    public AttenderEntity createAttender(CreateAttenderRequest request) {
        AttenderEntity entity = new AttenderEntity();

        //Your code is here
        return attenderRepository.save(entity);
    }

    public List<AttenderEntity> getAllAttenders() {

        //Your code is here
        return Collections.emptyList();
    }

    public void updateAttender(Integer attenderId, UpdateAttenderRequest request) {
        AttenderEntity entity = attenderRepository.getOne(attenderId);

        //Your code is here

        attenderRepository.save(entity);
    }

    public void deleteAttender(Integer attenderId) {
        //Your code is here
        return;
    }
}
