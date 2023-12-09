package com.example.demo.Controller;

import com.example.demo.Model.harfHesap;
import com.example.demo.Service.harfHesapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class harfHesapController {

    @Autowired
    private harfHesapService harfHesapService;

    @PostMapping("/DersHarfNotuHesapla")
    public void hesaplaVeKaydet(@RequestBody harfHesap harfHesap) {
        harfHesapService.hesaplaVeKaydet(harfHesap);
    }

    @GetMapping("/GecmisNotlar")
    public List<harfHesap> getTumHarfHesaplar() {
        return harfHesapService.getTumHarfHesapları();
    }
}
