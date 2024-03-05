package com.example.trainBooking.serviceImpl;

import com.example.trainBooking.dto.SourceDestination;
import com.example.trainBooking.dto.TrainDTO;
import com.example.trainBooking.dto.TrainNumber;
import com.example.trainBooking.entity.Train;
import com.example.trainBooking.repository.TrainRepository;
import com.example.trainBooking.service.TrainService;
import exception.TrainNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class TrainServiceImpl implements TrainService {
    @Autowired
    TrainRepository trainRepository;

    @Override
    public void addTrain(TrainDTO train) {
        // Validate required fields
        if (train.getTrainNumber() == null || train.getTrainName() == null || train.getStations() == null || train.getStations().isEmpty()) {
            throw new IllegalArgumentException("Train details are incomplete");
        }

        try {
            trainRepository.save(train.dtoToTrain(train));
        } catch (Exception e) {
            throw new ValidationException("Failed to add train", e);
        }
    }
    @Override
    public void updateTrain(TrainDTO train) {
        if (Objects.nonNull(train.getTrainNumber())) {
            Train trainDetails = trainRepository.findByTrainNumber(train.getTrainNumber());
            if (Objects.nonNull(trainDetails)) {
                trainRepository.save(train.dtoToTrain(train));
            } else {
                throw new EntityNotFoundException("No train found");
            }
        } else {
            throw new EntityNotFoundException("Please enter train number");
        }
    }
    @Override
    public List<TrainDTO> findTrain(SourceDestination sourceDestination) {
        List<TrainDTO> trainsDtos = new ArrayList<>();
        List<Train> allTrains = trainRepository.findAll();

        for (Train t : allTrains) {
            int indexOfSource = -1;
            int indexOfDestination = -1;
            String[] stations = t.getStations().get(0).split(",");

            for (int i = 0; i < stations.length; i++) {
                if (stations[i].equals(sourceDestination.getSource())) {
                    indexOfSource = i;
                }
                if (stations[i].equals(sourceDestination.getDestination())) {
                    indexOfDestination = i;
                }
            }

            if (indexOfSource != -1 && indexOfDestination != -1 && indexOfSource < indexOfDestination) {
                List<String> substation = new ArrayList<>(Arrays.asList(Arrays.copyOfRange(stations, indexOfSource, indexOfDestination + 1)));
                Train modifiedTrain = new Train(t.getTrainNumber(), t.getTrainName(), substation);
                trainsDtos.add(modifiedTrain.trainToDTO(modifiedTrain));
            }
        }
        return trainsDtos;
    }

    @Override
    public void removeTrain(TrainNumber trainNumber) {
        if (Objects.nonNull(trainNumber.getTrainNo())) {
            Train train = trainRepository.findByTrainNumber(trainNumber.getTrainNo());
            if (train != null) {
                trainRepository.delete(train);
            } else {
                throw new TrainNotFoundException("No entry found for train number: " + trainNumber.getTrainNo());
            }
        } else {
            throw new TrainNotFoundException("Invalid train number provided");
        }
    }
}
