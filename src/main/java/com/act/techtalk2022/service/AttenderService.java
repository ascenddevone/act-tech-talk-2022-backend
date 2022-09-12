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
        return null;
    }

    public List<AttenderEntity> getAllAttenders() {
        return null;
    }

    public void updateAttender(Integer attenderId, UpdateAttenderRequest request) {
        return;
    }

    public void deleteAttender(Integer attenderId) {
        return;
    }
}
