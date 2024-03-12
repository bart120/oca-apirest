package com.orange.api.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.orange.api.models.Offer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class OffersController {

    @GetMapping("/offers")
    public List<Offer> getOffers() {
        List<Offer> list = Offer.getAllOffers();
        return list;
    }

    @GetMapping("/offers/{id}")
    public ResponseEntity<Offer> getOfferById(@PathVariable("id") long idOffer) {
        List<Offer> list = Offer.getAllOffers();
        Offer of = list.stream().filter(x -> x.getId() == idOffer).findFirst().orElse(null);
        if (of != null)
            return new ResponseEntity<>(of, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/offers/byname/{name}")
    public ResponseEntity<Offer> getOfferByName(@PathVariable("name") String name) {
        List<Offer> list = Offer.getAllOffers();
        Offer of = list.stream().filter(x -> x.getName().equals(name)).findFirst().orElse(null);
        if (of != null)
            return new ResponseEntity<>(of, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
