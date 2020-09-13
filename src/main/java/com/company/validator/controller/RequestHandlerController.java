package com.company.validator.controller;

import com.company.validator.biz.requestvalidation.RequestValidationService;
import com.company.validator.model.HourlyStatsDTO;
import com.company.validator.model.request.RequestDTO;
import com.company.validator.model.response.ResponseDTO;
import com.company.validator.service.HourlyStatsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/requests")
public class RequestHandlerController {

    private final RequestValidationService requestValidationService;
    private final HourlyStatsService hourlyStatsService;

    public RequestHandlerController(RequestValidationService requestValidationService, HourlyStatsService hourlyStatsService) {
        this.requestValidationService = requestValidationService;
        this.hourlyStatsService = hourlyStatsService;
    }

    @PostMapping
    public ResponseEntity<ResponseDTO> saveRequest(@RequestBody RequestDTO requestDTO) {
        ResponseDTO responseDTO = this.requestValidationService.persistRequest(requestDTO);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping(value = "/customers/{customerID}")
    public ResponseEntity<List<HourlyStatsDTO>> getByCustomerId(@PathVariable Long customerID) {
        List<HourlyStatsDTO> stats = this.hourlyStatsService.findCustomerID(customerID);
        return ResponseEntity.ok(stats);
    }

    @GetMapping(value = "/times/{timeStamp}")
    public ResponseEntity<List<HourlyStatsDTO>> getByDate(@PathVariable Long timeStamp) {
        List<HourlyStatsDTO> stats = this.hourlyStatsService.findByTimeStamp(timeStamp);
        return ResponseEntity.ok(stats);
    }
}
