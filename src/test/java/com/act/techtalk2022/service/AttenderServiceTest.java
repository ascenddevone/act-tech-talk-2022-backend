package com.act.techtalk2022.service;


import com.act.techtalk2022.repository.AttenderRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AttenderServiceTest {

    @InjectMocks
    private AttenderService attenderService;

    @Mock
    private AttenderRepository attenderRepository;

    public void setUp() {

    }

    @Test
    public void dummyTest() {
        //This is dummy test
    }
//    @Test
//    public void test__createAttender__shouldReturnSuccess() {
//        CreateAttenderRequest request = new CreateAttenderRequest();
//
//        when(attenderRepository.save(any())).thenReturn(mock(AttenderEntity.class));
//        AttenderEntity result = attenderService.createAttender(request);
//
//        verify(attenderRepository, times(1)).save(any());
//        assertNotNull(result);
//    }
//
//    @Test
//    public void test__getAllAttenders__shouldReturnSuccess() {
//        when(attenderRepository.findAll()).thenReturn(mock(List.class));
//
//        List<AttenderEntity> result = attenderService.getAllAttenders();
//
//        verify(attenderRepository, times(1)).findAll();
//        assertNotNull(result);
//    }
//
//    @Test
//    public void test__updateAttender__shouldReturnSuccess() {
//        Integer id = 99;
//        UpdateAttenderRequest request = new UpdateAttenderRequest();
//
//        attenderService.updateAttender(id, request);
//
//        verify(attenderRepository, times(1)).save(any());
//    }
//
//    @Test
//    public void test__deleteAttender__shouldReturnSuccess() {
//        Integer id = 99;
//
//        doNothing().when(attenderRepository).delete(any());
//
//        attenderService.deleteAttender(id);
//
//        verify(attenderRepository, times(1)).delete(any());
//    }
}