package com.example.reto3atenea.Repository.CRUD;

import com.example.reto3atenea.Model.Reservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer> {

    // Reporte 1
    // SELECT * FROM Reservation WHERE starData AFTER fechaA AND devolutionData BEFORE fechaB

    public List<Reservation> findAllByStartDateAfterAndDevolutionDateBefore(Date fechaA, Date fechaB);

    // Reporte 2
    // SELECT * FROM Reservation WHERE status = "valorNecesario"

    public List<Reservation> findAllByStatus(String status);

    // Reporte 3
    // SELECT client, COUNT(client) FROM Reservation GROUP BY Client ORDER BY COUNT(client) DESC;
    // [ client, totalClient]

    @Query("SELECT c.client, COUNT(c.client) FROM Reservation AS c GROUP BY c.client ORDER BY COUNT(c.client) DESC")
    public List<Object[]> getTotalReservationsByClient();
}
