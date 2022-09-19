package com.act.techtalk2022.controller;


import com.act.techtalk2022.controller.request.CreateAttenderRequest;
import com.act.techtalk2022.controller.request.UpdateAttenderRequest;
import com.act.techtalk2022.controller.response.CreateAttenderResponse;
import com.act.techtalk2022.controller.response.GeneralResponse;
import com.act.techtalk2022.controller.response.GetAllAttenderResponse;
import com.act.techtalk2022.exception.CommonException;
import com.act.techtalk2022.factory.ResponseFactory;
import com.act.techtalk2022.repository.enitiy.AttenderEntity;
import com.act.techtalk2022.service.AttenderService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AttenderControllerTest {

    @InjectMocks
    private AttenderController attenderController;

    @InjectMocks
    private ExceptionHandlerController exceptionHandlerController;

    @Mock
    private AttenderService attenderService;

    @Mock
    private ResponseFactory responseFactory;


    @Before
    public void setUp() {
        when(responseFactory.success(any(), any())).thenCallRealMethod();
        when(responseFactory.success()).thenCallRealMethod();
    }

    @Test
    public void test__createAttender__shouldReturnSuccess() {
        CreateAttenderRequest request = new CreateAttenderRequest();

        Integer id = 99;
        AttenderEntity entity = new AttenderEntity();
        entity.setId(id);

        doNothing().when(attenderService)
                .validateCreateAttender(request);
        when(attenderService.createAttender(any())).thenReturn(entity);

        ResponseEntity<GeneralResponse<CreateAttenderResponse>> result
                = attenderController.addAttender(request);

        assertEquals(id, Objects.requireNonNull(result.getBody()).getData().getId());

        verify(attenderService, times(1)).createAttender(any());
    }

    @Test(expected = CommonException.class)
    public void test__createAttender__withInvalidData__shouldThrowException() {
        CreateAttenderRequest request = new CreateAttenderRequest();

        Integer id = 99;
        AttenderEntity entity = new AttenderEntity();
        entity.setId(id);

        doThrow(new CommonException("error", "Error message"))
                .when(attenderService)
                .validateCreateAttender(request);

        ResponseEntity<GeneralResponse<CreateAttenderResponse>> result
                = attenderController.addAttender(request);

        assertEquals(id, Objects.requireNonNull(result.getBody()).getData().getId());

        verify(attenderService, times(1)).createAttender(any());
    }


    @Test
    public void test__getAllAttenders__shouldReturnSuccess() {
        List<AttenderEntity> entities = new ArrayList<>();
        entities.add(new AttenderEntity());
        entities.add(new AttenderEntity());

        when(attenderService.getAllAttenders()).thenReturn(entities);

        ResponseEntity<GeneralResponse<GetAllAttenderResponse>> result
                = attenderController.getAllAttenders();


        assertEquals(entities.size(), Objects.requireNonNull(result.getBody()).getData().getAttenders().size());
        verify(attenderService, times(1)).getAllAttenders();
    }

    @Test
    public void test__updateAttender__shouldReturnSuccess() {
        UpdateAttenderRequest request = new UpdateAttenderRequest();
        Integer id = 99;

        doNothing()
                .when(attenderService)
                .validateUpdateAttender(request);

        attenderController.updateAttender(id, request);

        verify(attenderService, times(1)).updateAttender(anyInt(), any());
    }

    @Test(expected = CommonException.class)
    public void test__updateAttender__withInvalidData__shouldThrowException() {
        UpdateAttenderRequest request = new UpdateAttenderRequest();
        Integer id = 99;

        doThrow(new CommonException("error", "error message"))
                .when(attenderService)
                .validateUpdateAttender(request);

        attenderController.updateAttender(id, request);

        verify(attenderService, times(1)).updateAttender(anyInt(), any());
    }

    @Test(expected = CommonException.class)
    public void test__updateAttender__withInvalidId__shouldThrowException() {
        UpdateAttenderRequest request = new UpdateAttenderRequest();
        Integer id = 99;

        doThrow(new CommonException("error", "error message"))
                .when(attenderService)
                .validateAttender(id);

        attenderController.updateAttender(id, request);

        verify(attenderService, times(1)).updateAttender(anyInt(), any());
    }

    @Test
    public void test__deleteAttender__shouldReturnSuccess() {
        Integer id = 99;

        doNothing().when(attenderService).validateAttender(anyInt());
        attenderController.deleteAttender(id);

        verify(attenderService, times(1)).deleteAttender(any());
    }


    @Test(expected = CommonException.class)
    public void test__deleteAttender__withInvalidId__shouldThrowException() {
        Integer id = 99;

        doThrow(new CommonException("error", "error message"))
                .when(attenderService)
                .validateAttender(id);
        attenderController.deleteAttender(id);

        verify(attenderService, times(1)).deleteAttender(any());
    }
}