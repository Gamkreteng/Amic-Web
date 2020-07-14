package com.tmu.amic.controller;

import com.tmu.amic.controller.request.ClientPartnerRequest;
import com.tmu.amic.controller.response.ClientPartnerResponse;
import com.tmu.amic.model.ClientPartner;
import com.tmu.amic.service.ClientPartnerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api")
public class ClientPartnerController {

    @Autowired
    private ClientPartnerServices clientPartnerServices;

    @GetMapping("/clientPartner")
    public List<ClientPartner> getAllClientPartner() {

        return clientPartnerServices.findAll();
    }

    @GetMapping("/clientPartner/{id}")
    public ClientPartnerResponse getById(@PathVariable long id) {
        return clientPartnerServices.getClientPartnerById(id);
    }

    @PostMapping("/clientPartner")
    public void creatClientPartner(@RequestBody ClientPartnerRequest clientPartner) {
        clientPartnerServices.creatClientPartner(clientPartner);
    }

    @PutMapping("/clientPartner/{id}")
    public void replaceClientPartner(@RequestBody ClientPartner updateClientPartner, @PathVariable Long id) {
        clientPartnerServices.replaceClientPartner(updateClientPartner, id);
    }

    @DeleteMapping("/clientPartner/{id}")
    public void delete(@PathVariable String id) {

        Long clientPartnerId = Long.parseLong(id);
        clientPartnerServices.deleteById(clientPartnerId);
    }
}
