package com.BilgeAdam.controller;

import com.BilgeAdam.service.PersonelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.BilgeAdam.constants.RestApi.*;
@RestController
@RequiredArgsConstructor
@RequestMapping(PERSONEL)
public class PersonelController {

    private final PersonelService personelService;

    /**
     * Gerekli Methodlar belirlecenek ve AzurDevops a öncelikle eklenilecek.LÜTFEN DİKKAT EDELİM AZURE DEVOPS KULLANALIM
     */
}
