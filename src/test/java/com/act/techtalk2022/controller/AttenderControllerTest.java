package com.act.techtalk2022.controller;


import com.act.techtalk2022.controller.request.CreateAttenderRequest;
import com.act.techtalk2022.controller.request.UpdateAttenderRequest;
import com.act.techtalk2022.controller.response.CreateAttenderResponse;
import com.act.techtalk2022.controller.response.GeneralResponse;
import com.act.techtalk2022.controller.response.GetAllAttenderResponse;
import com.act.techtalk2022.exception.CommonException;
import com.act.techtalk2022.factory.ResponseFactory;
import com.act.techtalk2022.service.AttenderService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.any;
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

        when(responseFactory.error(any(HttpStatus.class), any(CommonException.class))).thenCallRealMethod();
        when(responseFactory.error(any(HttpStatus.class), anyString(), anyString())).thenCallRealMethod();
    }

    @Test
    public void test__createAttender__shouldReturnSuccess() {
        CreateAttenderRequest request = new CreateAttenderRequest();

        ResponseEntity<GeneralResponse<CreateAttenderResponse>> result = attenderController.addAttender(request);

        verify(attenderService, times(1)).createAttender(any());
    }


    @Test
    public void test__getAllAttenders__shouldReturnSuccess() {
        ResponseEntity<GeneralResponse<GetAllAttenderResponse>> result = attenderController.getAllAttenders();


        verify(attenderService, times(1)).getAllAttenders();
    }


    @Test
    public void test__updateAttender__shouldReturnSuccess() {
        UpdateAttenderRequest request = new UpdateAttenderRequest();
        Integer id = 99;

        ResponseEntity<GeneralResponse<Object>> result = attenderController.updateAttender(id, request);

        verify(attenderService, times(1)).updateAttender(anyInt(), any());
    }


    @Test
    public void test__deleteAttender__shouldReturnSuccess() {
        Integer id = 99;

        ResponseEntity<GeneralResponse<Object>> result = attenderController.deleteAttender(id);

        verify(attenderService, times(1)).deleteAttender(any());
    }
}