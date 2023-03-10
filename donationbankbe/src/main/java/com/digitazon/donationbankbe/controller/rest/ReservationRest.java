package com.digitazon.donationbankbe.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitazon.donationbankbe.model.Reservation;
import com.digitazon.donationbankbe.service.ReservationService;

@RestController
@RequestMapping("/api/reservation")
@CrossOrigin
public class ReservationRest {

    @Autowired
    ReservationService reservationService;


    @GetMapping("/all")
    public ResponseEntity<List<Reservation>> getAllReservation() {

        return new ResponseEntity<>(reservationService.getAllReservation(), HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable Long id) {

        return new ResponseEntity<>(reservationService.findReservationById(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation newReservation) {

        return new ResponseEntity<Reservation>(reservationService.saveReservation(newReservation), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteReservationById(@PathVariable String id) {

        Long idLong = Long.parseLong(id);

        reservationService.deleteReservationById(idLong);

        return new ResponseEntity<>("delete successful", HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Reservation> updateReservation(@PathVariable long id,
            @RequestBody Reservation newReservation) {

        return new ResponseEntity<>(reservationService.updateReservation(newReservation), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Reservation> updateReservationById(@PathVariable Long id,
            @RequestBody Reservation newReservation) {

        return new ResponseEntity<Reservation>(reservationService.updateReservationById(newReservation, id),
                HttpStatus.OK);
    }

}
