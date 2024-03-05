package com.example.trainBooking.service;


import com.example.trainBooking.dto.SourceDestination;
import com.example.trainBooking.dto.TrainNumber;
import com.example.trainBooking.dto.TrainDTO;

import java.util.List;

public interface TrainService {

    void addTrain( TrainDTO train);

    void updateTrain( TrainDTO train);

    List<TrainDTO> findTrain(SourceDestination sourceDestination);

    void removeTrain(TrainNumber trainNumber);



}

