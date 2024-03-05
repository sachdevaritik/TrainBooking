package com.example.trainBooking.dto;

import com.example.trainBooking.entity.Train;

import java.util.List;

public class TrainDTO {
    private  Integer trainNumber;
    private  String trainName;
    private List<String> stations;

    public Integer getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(Integer trainNumber) {
        this.trainNumber = trainNumber;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public List<String> getStations() {
        return stations;
    }

    public void setStations(List<String> stations) {
        this.stations = stations;
    }

    public TrainDTO() {
        super();
    }
    @Override
    public String toString(){
        return "TrainDTO { Number : " + trainNumber + "Name : " +trainName + "Stations : "  + stations + "}";

    }

    public TrainDTO(Integer trainNumber, String trainName, List<String> stations) {
        super();
        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.stations = stations;
    }

    public Train dtoToTrain(TrainDTO trainDTO ){
        Train train = new Train();
        train.setStations( trainDTO.getStations());
        train.setTrainName(trainDTO.getTrainName());
        train.setTrainNumber(trainDTO.getTrainNumber());
        return  train;
    }
}
