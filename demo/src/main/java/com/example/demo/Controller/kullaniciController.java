package com.example.demo.Controller;
import com.example.demo.Model.kullanici;

import com.example.demo.Service.kullaniciService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class kullaniciController {

    @Autowired
    private kullaniciService kullaniciService;

    @PostMapping("/KayitOl")
    public ResponseEntity<String> kayitOl(@RequestBody kullanici yeniKullanici) {
        kullaniciService.kayitOl(yeniKullanici);
        return ResponseEntity.ok("Kayıt başarılı.");
    }

    @PostMapping("/girisyap")
    public ResponseEntity<String> girisYap(@RequestParam String email, @RequestParam String sifre) {
        kullaniciService.girisYap(email, sifre);
        return ResponseEntity.ok("Giriş başarılı.");
    }

    @PutMapping("/profil")
    public ResponseEntity<String> bilgileriGuncelle(@RequestBody kullanici yeniBilgiler) {
        kullaniciService.bilgileriGuncelle(yeniBilgiler);
        return ResponseEntity.ok("Bilgiler güncellendi.");
    }

    @PutMapping("/sifredegistir")
    public ResponseEntity<String> sifreGuncelle(@RequestParam String email, @RequestParam String yeniSifre) {
        kullaniciService.sifreGuncelle(email, yeniSifre);
        return ResponseEntity.ok("Şifre güncellendi.");
    }

    @GetMapping("/Anaekran")
    public ResponseEntity<String> getAdSoyadByEmail(@RequestParam String email) {
        String adSoyad = kullaniciService.getAdSoyadByEmail(email);
        if (adSoyad != null) {
            return ResponseEntity.ok(adSoyad);
        } else {
            return ResponseEntity.badRequest().body("Kullanıcı bulunamadı.");
        }
    }
}
