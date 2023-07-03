package com.example.ecommercerestapi.restcontroller;

import com.example.ecommercerestapi.entity.Service;
import com.example.ecommercerestapi.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service")
public class ServiceController {
    @Autowired
    private ServiceService serviceService;

    public ServiceController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    @GetMapping
    public ResponseEntity<List<Service>> listALl(){
        List<Service> services = serviceService.listAllService();
        return new ResponseEntity<>(services, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Service> getServiceById(@PathVariable("id") int id){
        Service service = serviceService.getServiceById(id);
        return new ResponseEntity<>(service,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Service> insert(@RequestBody Service service){
        Service savedService = serviceService.insertService(service);
        return new ResponseEntity<>(savedService,HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Service> update(@PathVariable("id") int id,
                                          @RequestBody Service service){
        service.setId(id);
        Service updatedService = serviceService.updateService(service);
        return new ResponseEntity<>(updatedService,HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable("id")int id){
        serviceService.deleteService(id);
        return new ResponseEntity<>("Service Deleted Successfully",HttpStatus.OK);
    }
}
