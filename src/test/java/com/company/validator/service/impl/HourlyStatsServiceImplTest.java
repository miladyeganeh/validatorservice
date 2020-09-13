package com.company.validator.service.impl;

import com.company.validator.domain.HourlyStatsEntity;
import com.company.validator.repository.HourlyStatsRepository;
import com.company.validator.service.HourlyStatsService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
class HourlyStatsServiceImplTest {

    @MockBean
    private HourlyStatsRepository hourlyStatsRepository;

    @Autowired
    private HourlyStatsService hourlyStatsService;

    @Test
    void success_save(){
        HourlyStatsEntity mockedHourlyStatsEntity = createHourlyStatsEntity();
        when(this.hourlyStatsRepository.save(any())).thenReturn(mockedHourlyStatsEntity);
        HourlyStatsEntity savedEntity = this.hourlyStatsService.save(mockedHourlyStatsEntity);
        assertThat(savedEntity.getInvalidRequestCount(), is(mockedHourlyStatsEntity.getInvalidRequestCount()));
        assertThat(savedEntity.getRequestCount(), is(mockedHourlyStatsEntity.getRequestCount()));
    }

    private HourlyStatsEntity createHourlyStatsEntity(){
        HourlyStatsEntity hourlyStatsEntity = new HourlyStatsEntity();
        hourlyStatsEntity.setInvalidRequestCount(1L);
        hourlyStatsEntity.setRequestCount(2l);
        return hourlyStatsEntity;
    }
}