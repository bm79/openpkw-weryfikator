package org.openpkw.web.controllers;

import org.openpkw.services.rest.dto.DistrictsDTO;
import org.openpkw.services.rest.services.RESTService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

/**
 * @author SzestKam (Kamil Szestowicki) 
 */
@RestController
public class DistrictsController {

    private final static Logger LOGGER = LoggerFactory.getLogger(DistrictsController.class);

    @Inject
    RESTService restService;

    //zwraca listę wszystkich okręgów
    @RequestMapping("/districts")
    public ResponseEntity<DistrictsDTO> getDistricts() {
        ResponseEntity<DistrictsDTO> result;

        try {
            HttpHeaders htppHeaders = new HttpHeaders();
            htppHeaders.add("Access-Control-Allow-Origin", "*");
            htppHeaders.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
            result = new ResponseEntity<>(restService.getDistricts(), htppHeaders,HttpStatus.OK);
        } catch (NullPointerException nex) {
            String errorMsg = "Can't get districts [NullPointerException]";
            LOGGER.warn(errorMsg, nex);
            result = new ResponseEntity<>(restService.getDistricts(), HttpStatus.NOT_FOUND);
        }
        return result;
    }
    
}
