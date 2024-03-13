package com.orange.api.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.orange.api.models.Offer;
import com.orange.api.repositories.OffersRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class OffersController {

    @Autowired
    OffersRepository offerRepo;

    @GetMapping("/offers")
    public List<Offer> getOffers() {
        // List<Offer> list = Offer.getAllOffers();
        List<Offer> list = offerRepo.findAll();
        return list;
    }

    @GetMapping("/offers/{id}")
    public ResponseEntity<Offer> getOfferById(@PathVariable("id") long idOffer) {
        /*
         * List<Offer> list = Offer.getAllOffers();
         * Offer of = list.stream().filter(x -> x.getId() ==
         * idOffer).findFirst().orElse(null);
         * if (of != null)
         * return new ResponseEntity<>(of, HttpStatus.OK);
         * else
         * return new ResponseEntity<>(HttpStatus.NOT_FOUND);
         */
        Optional<Offer> offer = offerRepo.findById(idOffer);
        if (offer.isPresent())
            return new ResponseEntity<>(offer.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /*
     * @GetMapping("/offers/byname")
     * public ResponseEntity<Offer> getOfferByName(@RequestParam String name) {
     * List<Offer> list = Offer.getAllOffers();
     * Offer of = list.stream().filter(x ->
     * x.getName().equals(name)).findFirst().orElse(null);
     * if (of != null)
     * return new ResponseEntity<>(of, HttpStatus.OK);
     * else
     * return new ResponseEntity<>(HttpStatus.NOT_FOUND);
     * }
     */
    @PostMapping("/offers")
    public ResponseEntity<Offer> addOffer(@RequestBody Offer offer) {
        /*
         * if (offer.getName().equals(""))
         * return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
         * List<Offer> list = Offer.getAllOffers();
         * list.add(offer);
         * return new ResponseEntity<>(offer, HttpStatus.CREATED);
         */
        try {
            Offer result = offerRepo.save(offer);
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/offers/{id}")
    public ResponseEntity<Offer> updateOffer(@PathVariable("id") long idOffer, @RequestBody Offer offer) {
        Optional<Offer> of = offerRepo.findById(idOffer);
        if (of.isPresent()) {
            offerRepo.save(offer);
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        } else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

}
