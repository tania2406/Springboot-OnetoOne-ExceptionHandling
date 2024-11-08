package com.springbootproject.Springboot_OnetoOne_sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class CunsumerController {

    @Autowired
    ConsumerRepository crepo;
    @Autowired
    AddressRepository arepo;

    @GetMapping("/test")
    public String test()
    {
        return " this is OnetoOne with exception test";
    }
    @PostMapping("/save")
    public String addConsumer(@RequestBody Consumer csr)
    {
        Consumer existingConsumer= crepo.findById(csr.getId())
                .orElse(null);
        if(existingConsumer==null)
        {
            csr.getAddress().setConsumer(csr);
           Consumer consumer= crepo.save(csr);
            return "consumer added successfully";
        }
        else
            throw new ConsumerAlreadyExistsException(
                    "consumer already exists!!"
            );
    }
    @GetMapping("/all")
    public List<Consumer> all()
    {
        return crepo.findAll();
    }
    @GetMapping("/{id}")
    public Consumer getconsumer(@PathVariable int id)
    {
        return crepo.findById(id).orElseThrow(
                () -> new NoSuchElementException(
                        "NO Consumer Present with Id= "+id));

    }
    @PutMapping ("/update/{id}")
    public String updateConsumer(@RequestBody Consumer csr,@PathVariable int id)
    {
        Consumer existingConsumer =crepo.findById(csr.getId()).orElse(null);
        if (existingConsumer== null)
            throw new NoSuchConsumerExistsException("No such Consumer exists!!");
        else {
            existingConsumer.setAddress(csr.getAddress());
            existingConsumer.setName(csr.getName());
            crepo.save(existingConsumer);
            return "record updated successfully";

        }
    }
}
