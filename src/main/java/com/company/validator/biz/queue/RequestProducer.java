package com.company.validator.biz.queue;

import com.company.validator.model.request.RequestDTO;

import java.util.concurrent.BlockingQueue;

public class RequestProducer{

    private RequestDTO requestDTO;
    private final BlockingQueue<RequestDTO> toBeSaveStats;

    public RequestProducer(BlockingQueue<RequestDTO> toBeSaveStats, RequestDTO requestDTO) {
        this.toBeSaveStats = toBeSaveStats;
        this.requestDTO = requestDTO;
    }


    public void add() {
        toBeSaveStats.add(this.requestDTO);
    }
}
