package com.example.demo.Service;

import com.example.demo.Model.kullanici;
import com.example.demo.Repository.kullaniciRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class kullaniciService {

    @Autowired
    private kullaniciRepository kullaniciRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public void kayitOl(kullanici kullanici) {
        String hashedSifre = passwordEncoder.encode(kullanici.getSifre());
        kullanici.setSifre(hashedSifre);

        kullaniciRepository.save(kullanici);
    }

    public kullanici girisYap(String email, String sifre) {
        kullanici kullanici = kullaniciRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Kullanıcı bulunamadı: " + email));

        if (passwordEncoder.matches(sifre, kullanici.getSifre())) {
            return kullanici;
        } else {
            throw new HataliSifreException("Hatalı şifre");
        }
    }

    public static class HataliSifreException extends RuntimeException {
        public HataliSifreException(String message) {
            super(message);
        }
    }

    public void bilgileriGuncelle(kullanici yeniBilgiler) {
        kullanici kullanici = kullaniciRepository.findById(yeniBilgiler.getEmail()).orElse(null);
        if (kullanici != null) {
            kullanici.setAd(yeniBilgiler.getAd());
            kullanici.setSoyad(yeniBilgiler.getSoyad());
            kullanici.setEmail(yeniBilgiler.getEmail());

            kullaniciRepository.save(kullanici);
        }
    }

    public void sifreGuncelle(String email, String yeniSifre) {
        kullanici kullanici = kullaniciRepository.findById(email).orElse(null);
        if (kullanici != null) {
            String hashedSifre = passwordEncoder.encode(yeniSifre);
            kullanici.setSifre(hashedSifre);

            kullaniciRepository.save(kullanici);
        }
    }

    public String getAdSoyadByEmail(String email) {
        kullanici kullanici = kullaniciRepository.findById(email).orElse(null);

        if (kullanici != null) {
            return kullanici.getAd() + " " + kullanici.getSoyad();
        }

        return null;
    }
}

