package ntnu.group10.backend.group10.controllers;


import ntnu.group10.backend.group10.entities.Address;
import ntnu.group10.backend.group10.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("address")
public class AddressController {

    @Autowired
    AddressService addressService;



    @PostMapping
    public ResponseEntity<String> add(@RequestBody Address address){
        ResponseEntity<String> responseEntity;
        if(addressService.add(address)){
            responseEntity = new ResponseEntity<>(HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id){
        ResponseEntity<String> responseEntity;
        if(addressService.remove(id)){
            responseEntity = new ResponseEntity<>(HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

}
