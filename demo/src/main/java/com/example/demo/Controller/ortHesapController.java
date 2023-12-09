
package com.example.demo.Controller;

import com.example.demo.Model.ortHesap;
import com.example.demo.Service.ortHesapService;
import com.example.demo.Service.ortHesapService.GenelNotOrtalamasiDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class ortHesapController {

    @Autowired
    private ortHesapService ortHesapService;

    @PostMapping("/NotOrtalamasiHesapla")
    public void hesaplaVeKaydet(@RequestBody ortHesap ortHesap) {
        ortHesapService.hesaplaVeKaydet(ortHesap);
    }

    @GetMapping("/GecmisNotlar")
    public List<GenelNotOrtalamasiDTO> getGenelNotOrtalamalari() {
        return ortHesapService.getGenelNotOrtalamalari();
    }
}
