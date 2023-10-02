package com.codegym.controller;

import com.codegym.model.Smartphone;
import com.codegym.service.ISmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/smartphones")
public class SmartphoneController {
    @Autowired
    private ISmartphoneService smartphoneService;

    @GetMapping
    public ResponseEntity<Iterable<Smartphone>> listSmartphone(){
        Iterable<Smartphone> smartphones = this.smartphoneService.findAll();
        return new ResponseEntity<>(smartphones, HttpStatus.OK);
        // nếu lúc này list rỗng thì luồng thực thi xử lý như thế nào?
    }

    @PostMapping
    public ResponseEntity<Smartphone> createSmartphone(@RequestBody Smartphone smartphone) {
        Smartphone newSmartPhone = this.smartphoneService.save(smartphone);
        return new ResponseEntity<>(newSmartPhone, HttpStatus.CREATED);
        // như trên
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Smartphone> deleteSmartPhone(@PathVariable Long id) {
        Optional<Smartphone> smartphoneOptional = this.smartphoneService.findById(id);
        if (smartphoneOptional.isPresent()) {
            this.smartphoneService.remove(id);
            return new ResponseEntity<>(smartphoneOptional.get(), HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
