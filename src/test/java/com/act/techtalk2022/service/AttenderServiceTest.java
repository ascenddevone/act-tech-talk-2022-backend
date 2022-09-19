package com.act.techtalk2022.service;


import com.act.techtalk2022.controller.request.CreateAttenderRequest;
import com.act.techtalk2022.controller.request.UpdateAttenderRequest;
import com.act.techtalk2022.exception.CommonException;
import com.act.techtalk2022.repository.AttenderRepository;
import com.act.techtalk2022.repository.enitiy.AttenderEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class AttenderServiceTest {

    @InjectMocks
    private AttenderService attenderService;

    @Mock
    private AttenderRepository attenderRepository;

    public void setUp() {
        //Do nothing
    }

    @Test
    public void test__createAttender__shouldReturnSuccess() {
        CreateAttenderRequest request = new CreateAttenderRequest(
                "Nguyen Van Nam",
                "nam@gmail.com",
                new Date(),
                null,
                null,
                null,
                12,
                false
        );

        when(attenderRepository.save(any())).thenReturn(mock(AttenderEntity.class));
        AttenderEntity result = attenderService.createAttender(request);

        verify(attenderRepository, times(1)).save(any());
        assertNotNull(result);
    }

    @Test
    public void test__getAllAttenders__shouldReturnSuccess() {
        when(attenderRepository.findAll()).thenReturn(mock(List.class));

        List<AttenderEntity> result = attenderService.getAllAttenders();

        verify(attenderRepository, times(1)).findAll();
        assertNotNull(result);
    }

    @Test
    public void test__updateAttender__shouldReturnSuccess() {
        Integer id = 99;
        UpdateAttenderRequest request = new UpdateAttenderRequest(
                "Nguyen Van Nam",
                "nam@gmail.com",
                new Date(),
                null,
                null,
                null,
                12,
                false
        );

        when(attenderRepository.getOne(any())).thenReturn(new AttenderEntity());
        attenderService.updateAttender(id, request);

        verify(attenderRepository, times(1)).save(any());
    }

    @Test
    public void test__deleteAttender__shouldReturnSuccess() {
        Integer id = 99;

        doNothing().when(attenderRepository).deleteById(any());

        attenderService.deleteAttender(id);

        verify(attenderRepository, times(1)).deleteById(any());
    }

    @Test
    public void test__validateUpdateAttender__shouldReturnSuccess() {
        UpdateAttenderRequest request = new UpdateAttenderRequest(
                "Nguyen Van Nam",
                "nam@gmail.com",
                new Date(),
                null,
                null,
                null,
                12,
                false
        );

        attenderService.validateUpdateAttender(request);
    }

    @Test(expected = CommonException.class)
    public void test__validateUpdateAttender__withoutFullName__shouldThrowException() {
        UpdateAttenderRequest request = new UpdateAttenderRequest(
                null,
                "nam@gmail.com",
                new Date(),
                null,
                null,
                null,
                12,
                false
        );

        attenderService.validateUpdateAttender(request);
    }

    @Test(expected = CommonException.class)
    public void test__validateUpdateAttender__withEmptyFullName__shouldThrowException() {
        UpdateAttenderRequest request = new UpdateAttenderRequest(
                null,
                "nam@gmail.com",
                new Date(),
                null,
                null,
                null,
                12,
                false
        );

        attenderService.validateUpdateAttender(request);
    }

    @Test(expected = CommonException.class)
    public void test__validateUpdateAttender__withoutEmail__shouldThrowException() {
        UpdateAttenderRequest request = new UpdateAttenderRequest(
                "Nguyen Van Nam",
                null,
                new Date(),
                null,
                null,
                null,
                12,
                false
        );

        attenderService.validateUpdateAttender(request);
    }

    @Test(expected = CommonException.class)
    public void test__validateUpdateAttender__withEmptyEmail__shouldThrowException() {
        UpdateAttenderRequest request = new UpdateAttenderRequest(
                "Nguyen Van Nam",
                "",
                new Date(),
                null,
                null,
                null,
                12,
                false
        );

        attenderService.validateUpdateAttender(request);
    }

    @Test(expected = CommonException.class)
    public void test__validateUpdateAttender__withInvalidEmail__shouldThrowException() {
        UpdateAttenderRequest request = new UpdateAttenderRequest(
                "Nguyen Van Nam",
                "invalid email",
                new Date(),
                null,
                null,
                null,
                12,
                false
        );

        attenderService.validateUpdateAttender(request);
    }

    @Test(expected = CommonException.class)
    public void test__validateUpdateAttender__withoutDateOfBirth__shouldThrowException() {
        UpdateAttenderRequest request = new UpdateAttenderRequest(
                "Nguyen Van Nam",
                "nam@gmail.com",
                null,
                null,
                null,
                null,
                12,
                false
        );

        attenderService.validateUpdateAttender(request);
    }

    @Test
    public void test__validateCreateAttender__shouldReturnSuccess() {
        CreateAttenderRequest request = new CreateAttenderRequest(
                "Nguyen Van Nam",
                "nam@gmail.com",
                new Date(),
                null,
                null,
                null,
                12,
                false
        );

        attenderService.validateCreateAttender(request);
    }

    @Test(expected = CommonException.class)
    public void test__validateCreateAttender__withoutFullName__shouldThrowException() {
        CreateAttenderRequest request = new CreateAttenderRequest(
                null,
                "nam@gmail.com",
                new Date(),
                null,
                null,
                null,
                12,
                false
        );

        attenderService.validateCreateAttender(request);
    }

    @Test(expected = CommonException.class)
    public void test__validateCreateAttender__withEmptyFullName__shouldThrowException() {
        CreateAttenderRequest request = new CreateAttenderRequest(
                null,
                "nam@gmail.com",
                new Date(),
                null,
                null,
                null,
                12,
                false
        );

        attenderService.validateCreateAttender(request);
    }

    @Test(expected = CommonException.class)
    public void test__validateCreateAttender__withoutEmail__shouldThrowException() {
        CreateAttenderRequest request = new CreateAttenderRequest(
                "Nguyen Van Nam",
                null,
                new Date(),
                null,
                null,
                null,
                12,
                false
        );

        attenderService.validateCreateAttender(request);
    }

    @Test(expected = CommonException.class)
    public void test__validateCreateAttender__withEmptyEmail__shouldThrowException() {
        CreateAttenderRequest request = new CreateAttenderRequest(
                "Nguyen Van Nam",
                "",
                new Date(),
                null,
                null,
                null,
                12,
                false
        );

        attenderService.validateCreateAttender(request);
    }

    @Test(expected = CommonException.class)
    public void test__validateCreateAttender__withInvalidEmail__shouldThrowException() {
        CreateAttenderRequest request = new CreateAttenderRequest(
                "Nguyen Van Nam",
                "invalid email",
                new Date(),
                null,
                null,
                null,
                12,
                false
        );

        attenderService.validateCreateAttender(request);
    }

    @Test(expected = CommonException.class)
    public void test__validateCreateAttender__withoutDateOfBirth__shouldThrowException() {
        CreateAttenderRequest request = new CreateAttenderRequest(
                "Nguyen Van Nam",
                "nam@gmail.com",
                null,
                null,
                null,
                null,
                12,
                false
        );

        attenderService.validateCreateAttender(request);
    }

    @Test
    public void test__validateAttender__shouldReturnSuccess() {
        Integer id = 99;

        when(attenderRepository.findById(any())).thenReturn(Optional.of(new AttenderEntity()));

        attenderService.validateAttender(id);
        verify(attenderRepository, times(1)).findById(id);
    }

    @Test(expected = CommonException.class)
    public void test__validateAttender__withoutAttender__shouldReturnSuccess() {
        Integer id = 99;

        when(attenderRepository.findById(any())).thenReturn(Optional.empty());

        attenderService.validateAttender(id);
        verify(attenderRepository, times(1)).findById(id);
    }
}