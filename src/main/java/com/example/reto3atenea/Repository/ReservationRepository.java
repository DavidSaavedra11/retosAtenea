package com.example.reto3atenea.Repository;

import com.example.reto3atenea.Model.Client;
import com.example.reto3atenea.Model.DTOs.TotalAndClient;
import com.example.reto3atenea.Model.Reservation;
import com.example.reto3atenea.Repository.CRUD.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {
    @Autowired
    private ReservationCrudRepository reservationCrudRepository;

    public List<Reservation> findAll(){
        return (List<Reservation>) reservationCrudRepository.findAll();
    }

    public Optional<Reservation> getReservation(int id){
        return reservationCrudRepository.findById(id);
    }

    public Reservation save(Reservation reservation){
        return reservationCrudRepository.save(reservation);
    }

    public void delete (Reservation reservation){
        reservationCrudRepository.delete(reservation);
    }

    // Reto 5

    public  List<Reservation> getReservationsBetweenDates(Date fechaA, Date fechaB){
        return  reservationCrudRepository.findAllByStartDateAfterAndDevolutionDateBefore(fechaA, fechaB);
    }

    public  List<Reservation> getReservationsByStatus(String status){
        return reservationCrudRepository.findAllByStatus(status);
    }


    public List<Object[]> getTotalReservationsByClient(){
        return reservationCrudRepository.getTotalReservationsByClient();
    }




}
