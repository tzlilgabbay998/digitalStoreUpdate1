package com.example.mongo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Store {

    @Id
    private Long ReservationId;
    @NoNull
    private String title;
    @NoNull
    private String description;
    @NoNull
    private LocalDate dateOfOrder;

}