package com.example.trainBooking.entity;

import com.example.trainBooking.dto.TrainDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "train_details")
public class Train {

    @Id
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

    public Train() {
        super();
    }

    @Override
    public String toString(){
        return "Train { Number : " + trainNumber + "Name : " +trainName + "Stations : "  + stations + "}";

    }

    public Train(Integer trainNumber, String trainName, List<String> stations) {
        super();
        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.stations = stations;
    }
    public TrainDTO trainToDTO( Train train ) {
        TrainDTO trainDTO = new TrainDTO();
        trainDTO.setStations(train.getStations());
        trainDTO.setTrainName(train.getTrainName());
        trainDTO.setTrainNumber(train.getTrainNumber());
        return trainDTO;
    }
}
