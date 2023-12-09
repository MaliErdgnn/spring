package com.example.demo.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Model.harfHesap;
import com.example.demo.Repository.harfHesapRepository;
import com.example.demo.Model.quiz;
import com.example.demo.Model.odev;
import com.example.demo.Model.proje;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Service
public class harfHesapService {

    @Autowired
    private harfHesapRepository harfHesapRepository;
    private quiz quiz;
    private odev odev;
    private proje proje;

    public static Date getCurrentDate() {
        LocalDate localDate = LocalDate.now();
        return java.util.Date.from(localDate.atStartOfDay().atZone(java.time.ZoneId.systemDefault()).toInstant());
    }

    public void hesaplaVeKaydet(harfHesap harfHesap) {
        double ort = harfHesap.getVizeNot() * (harfHesap.getVizeYuzde() / 100) +
                harfHesap.getFinalNot() * (harfHesap.getFinalYuzde() / 100) +
                quiz.getQuizNot() * (harfHesap.getQuizYuzde() / 100) +
                odev.getOdevNot() * (harfHesap.getOdevYuzde() / 100) +
                proje.getProjeNot() * (harfHesap.getProjeYuzde() / 100);

        harfHesap.setPuan(ort);

        double sinifOrtalama = harfHesap.getSinifOrt();
        harfHesap.setSinifOrt(sinifOrtalama);

        if ("Katalog".equalsIgnoreCase(harfHesap.getNotSis())) {
            harfHesap.setHarfNot(katalogSistemiHarfNotuBelirle(ort));
        } else if ("Çan".equalsIgnoreCase(harfHesap.getNotSis())) {
            harfHesap.setHarfNot(canSistemiHarfNotuBelirle(harfHesap.getPuan(), harfHesap.getSinifOrt()));
        }
        harfHesap.setTarih(getCurrentDate());
        harfHesapRepository.save(harfHesap);
    }

    private String katalogSistemiHarfNotuBelirle(double puan) {
        harfHesap harfHesap = new harfHesap();
        if ("FD".equalsIgnoreCase(harfHesap.getHarfSIS())) {
            if (puan >= 90)
                return "AA";
            else if (puan >= 85 && puan <= 89)
                return "BA";
            else if (puan >= 80 && puan <= 84)
                return "BB";
            else if (puan >= 70 && puan <= 79)
                return "CB";
            else if (puan >= 60 && puan <= 69)
                return "CC";
            else if (puan >= 50 && puan <= 59)
                return "DC";
            else if (puan >= 45 && puan <= 49)
                return "DD";
            else
                return "FD";
        } else if ("CD".equalsIgnoreCase(harfHesap.getHarfSIS())) {
            if (puan >= 84)
                return "AA";
            else if (puan >= 77 && puan <= 83)
                return "AB";
            else if (puan >= 71 && puan <= 76)
                return "BA";
            else if (puan >= 66 && puan <= 70)
                return "BB";
            else if (puan >= 61 && puan <= 65)
                return "BC";
            else if (puan >= 56 && puan <= 60)
                return "CB";
            else if (puan >= 50 && puan <= 55)
                return "CC";
            else if (puan >= 46 && puan <= 49)
                return "CD";
            else if (puan >= 40 && puan <= 45)
                return "DC";
            else if (puan >= 33 && puan <= 39)
                return "DD";
            else
                return "FF";
        } else if ("A".equalsIgnoreCase(harfHesap.getHarfSIS())) {
            if (puan >= 95)
                return "A";
            else if (puan >= 90 && puan <= 94)
                return "A-";
            else if (puan >= 85 && puan <= 89)
                return "B+";
            else if (puan >= 80 && puan <= 84)
                return "B";
            else if (puan >= 75 && puan <= 79)
                return "B-";
            else if (puan >= 70 && puan <= 74)
                return "C+";
            else if (puan >= 65 && puan <= 69)
                return "C";
            else if (puan >= 60 && puan <= 64)
                return "C-";
            else if (puan >= 55 && puan <= 59)
                return "D+";
            else if (puan >= 50 && puan <= 54)
                return "D";
            else
                return "F";
        }
        return "Geçersiz";
    }

    private String canSistemiHarfNotuBelirle(double puan, double sinifOrtalama) {
        double fark = puan - sinifOrtalama;

        harfHesap harfHesap = new harfHesap();

        if ("FD".equalsIgnoreCase(harfHesap.getHarfSIS())) {
            if (fark >= 30)
                return "AA";
            else if (fark >= 25 && fark <= 29)
                return "BA";
            else if (fark >= 20 && fark <= 24)
                return "BB";
            else if (fark >= 10 && fark <= 19)
                return "CB";
            else if (fark >= 0 && fark <= 9)
                return "CC";
            else if (fark >= -10 && puan <= -1)
                return "DC";
            else if (fark >= -15 && puan <= -11)
                return "DD";
            else
                return "FF";
        } else if ("CD".equalsIgnoreCase(harfHesap.getHarfSIS())) {
            if (fark >= 34)
                return "AA";
            else if (fark >= 27 && fark <= 33)
                return "AB";
            else if (fark >= 21 && fark <= 26)
                return "BA";
            else if (fark >= 16 && fark <= 20)
                return "BB";
            else if (fark >= 11 && fark <= 15)
                return "BC";
            else if (fark >= 6 && fark <= 10)
                return "CB";
            else if (fark >= 0 && fark <= 5)
                return "CC";
            else if (fark >= -4 && fark <= -1)
                return "CD";
            else if (fark >= -10 && fark <= -5)
                return "DC";
            else if (fark >= -17 && fark <= -11)
                return "DD";
            else
                return "FF";

        } else if ("A".equalsIgnoreCase(harfHesap.getHarfSIS())) {
            if (fark >= 30)
                return "A";
            else if (fark >= 25 && fark <= 29)
                return "A-";
            else if (fark >= 20 && fark <= 84)
                return "B+";
            else if (fark >= 15 && fark <= 21)
                return "B";
            else if (fark >= 10 && fark <= 14)
                return "B-";
            else if (fark >= 5 && fark <= 9)
                return "C+";
            else if (fark >= 0 && fark <= 4)
                return "C";
            else if (fark >= -5 && fark <= -1)
                return "C-";
            else if (fark >= -10 && fark <= -6)
                return "D+";
            else if (fark >= -15 && fark <= -11)
                return "D";
            else
                return "F";
        }
        return "Geçersiz";
    }

    public List<harfHesap> getTumHarfHesapları() {
        return harfHesapRepository.findAll();
    }
}
