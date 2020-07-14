package com.tmu.amic.service;

import com.tmu.amic.controller.request.ClientPartnerRequest;
import com.tmu.amic.controller.response.ClientPartnerResponse;
import com.tmu.amic.model.ClientPartner;
import com.tmu.amic.repository.ClientPartnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientPartnerServices {

    @Autowired
    private ClientPartnerRepository clientPartnerRepository;

    public List<ClientPartner> findAll() {

        List<ClientPartner> it = clientPartnerRepository.findAll();

        ArrayList<ClientPartner> clientPartners = new ArrayList<ClientPartner>();
        it.forEach(e -> clientPartners.add(e));

        return clientPartners;
    }

    public ClientPartnerResponse getClientPartnerById(long id) {
        ClientPartnerResponse clientPartnerResponse = new ClientPartnerResponse();
        ClientPartner clientPartner = clientPartnerRepository.findById(id).get();


        clientPartnerResponse.setCpName(clientPartner.getCpName());
        clientPartnerResponse.setCpAddress(clientPartner.getCpAddress());
        clientPartnerResponse.setCpDetails(clientPartner.getCpDetails());

        return clientPartnerResponse;
    }

    public void deleteById(Long id) {

        clientPartnerRepository.deleteById(id);
    }

    public void creatClientPartner(ClientPartnerRequest clientPartner) {

        ClientPartner cp = new ClientPartner();

        cp.setCpName(clientPartner.getCpName());
        cp.setCpAddress(clientPartner.getCpAddress());
        cp.setCpDetails(clientPartner.getCpDetails());

    }

    public ClientPartner replaceClientPartner(@RequestBody ClientPartner updateClientPartner, @PathVariable Long id) {

        return clientPartnerRepository.findById(id)
                .map(clientPartner -> {
                    clientPartner.setCpName(updateClientPartner.getCpName());
                    clientPartner.setCpAddress(updateClientPartner.getCpAddress());
                    clientPartner.setCpDetails(updateClientPartner.getCpDetails());
                    return clientPartnerRepository.save(clientPartner);
                })
                .orElseGet(() -> {
                    updateClientPartner.setId(id);
                    return clientPartnerRepository.save(updateClientPartner);
                });
    }

}
