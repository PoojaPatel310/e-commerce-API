package com.example.ecommercerestapi.serviceimpl;


import com.example.ecommercerestapi.entity.ContactUs;
import com.example.ecommercerestapi.repository.ContactUsRepository;
import com.example.ecommercerestapi.service.ContactUsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ContactUsServiceImpl implements ContactUsService {
    @Autowired
    ContactUsRepository repository;
    @Override
    public List<ContactUs> listAllContactUs() {
        return repository.findAll();
    }

    @Override
    public ContactUs getContactUsById(int id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public ContactUs insertContactUs(ContactUs contactUs) {
        return repository.save(contactUs);
    }

    @Override
    public ContactUs updateContactUs(ContactUs contactUs) {
        return repository.save(contactUs);
    }

    @Override
    public int deleteContactUs(int id) {
        repository.deleteById(id);
        return id;
    }
}
