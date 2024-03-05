package com.example.trainBooking.repository;


import com.example.trainBooking.entity.Train;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TrainRepository extends JpaRepository<Train, Integer> {

    Train findByTrainNumber(Integer Id);

}
