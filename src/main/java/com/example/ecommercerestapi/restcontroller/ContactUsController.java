package com.example.ecommercerestapi.restcontroller;

import com.example.ecommercerestapi.entity.ContactUs;
import com.example.ecommercerestapi.service.ContactUsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contactus")
public class ContactUsController {
    @Autowired
    private ContactUsService contactUsService;

    public ContactUsController(ContactUsService contactUsService) {
        this.contactUsService = contactUsService;
    }

    @GetMapping
    public ResponseEntity<List<ContactUs>> listAll(){
        List<ContactUs> contactUs = contactUsService.listAllContactUs();
        return new ResponseEntity<>(contactUs, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<ContactUs> getContactById(@PathVariable("id") int id){
    ContactUs contactUs = contactUsService.getContactUsById(id);
    return new ResponseEntity<>(contactUs,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ContactUs> insert(@RequestBody ContactUs contactUs){
        ContactUs savedContact = contactUsService.insertContactUs(contactUs);
        return new ResponseEntity<>(contactUs,HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<ContactUs> update(@PathVariable("id") int id,
                                            @RequestBody ContactUs contactUs){
        contactUs.setId(id);
        ContactUs updatedContact = contactUsService.updateContactUs(contactUs);
        return new ResponseEntity<>(updatedContact,HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int id){
        contactUsService.deleteContactUs(id);
        return new ResponseEntity<>("Contact Deleted Successfully",HttpStatus.OK);
    }
}
