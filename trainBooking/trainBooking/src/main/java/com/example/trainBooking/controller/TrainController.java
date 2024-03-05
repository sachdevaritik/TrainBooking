package com.example.trainBooking.controller;

import com.example.trainBooking.dto.SourceDestination;
import com.example.trainBooking.dto.TrainDTO;
import com.example.trainBooking.dto.TrainNumber;
import com.example.trainBooking.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/train")
public class TrainController {
    @Autowired
    TrainService trainService;

    @PostMapping("/find")
    public ResponseEntity<List<TrainDTO>> findTrain(@RequestBody SourceDestination sourceDestination){
        List<TrainDTO> trainDTO = trainService.findTrain(sourceDestination);
        return new ResponseEntity<List<TrainDTO>>(trainDTO, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<TrainDTO> addTrain(@RequestBody TrainDTO train){
        trainService.addTrain( train);
        return new ResponseEntity<TrainDTO>(train, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<TrainDTO> updateTrain(@RequestBody TrainDTO train){
        trainService.updateTrain( train );
        return new ResponseEntity<TrainDTO>(train, HttpStatus.OK);
    }

    @PostMapping("/remove")
    public HttpStatus removeTrain(@RequestBody TrainNumber trainNumber){
        trainService.removeTrain( trainNumber );
        return HttpStatus.OK;
    }

}
