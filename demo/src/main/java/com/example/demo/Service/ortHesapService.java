package com.example.demo.Service;
import com.example.demo.Model.ders;
import com.example.demo.Model.ortHesap;
import com.example.demo.Repository.ortHesapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ortHesapService {

    @Autowired
    private ortHesapRepository ortHesapRepository;

    public void hesaplaVeKaydet(ortHesap ortHesap) {

        double dersOrtalamasi = calculateDonemOrtalamasi(ortHesap);

        calculateGenelNotOrtalamasi(ortHesap);

        ortHesapRepository.save(ortHesap);
    }

    public double calculateDonemOrtalamasi(ortHesap ortHesap) {
        int toplamKredi = 0;
        double toplamPuan = 0;

        for (ders ders : ortHesap.getDersList()) {
            String dersAdi = ders.getDersAdi();
            int kredi = ders.getKredi();
            String harfNotu = ders.getHarfNotu();

            double score = convertHarfNotuToPuan(harfNotu);

            toplamPuan += kredi * score;

            toplamKredi += kredi;
        }
        ortHesap ortHesap1 = new ortHesap();
        double donemOrt = ortHesap1.getDonemOrt();
        donemOrt=toplamPuan / toplamKredi;

        return donemOrt;
    }

    private double convertHarfNotuToPuan(String harfNotu) {
        ortHesap ortHesap = new ortHesap();
        if ("FD".equalsIgnoreCase(ortHesap.getHarfSis())) {
            if(harfNotu=="AA")
                return 4.0;
            else if(harfNotu=="BA")
                return 3.5;
            else if(harfNotu=="BB")
                return 3.0;
            else if(harfNotu=="CB")
                return 2.5;
            else if(harfNotu=="CC")
                return 2.0;
            else if(harfNotu=="DC")
                return 1.5;
            else if(harfNotu=="DD")
                return 1.0;
            else
                return 0.0;
        }
        else if ("CD".equalsIgnoreCase(ortHesap.getHarfSis())) {
            if(harfNotu=="AA")
                return 4.0;
            else if(harfNotu=="AB")
                return 3.7;
            else if(harfNotu=="BA")
                return 3.3;
            else if(harfNotu=="BB")
                return 3.0;
            else if(harfNotu=="BC")
                return 2.7;
            else if(harfNotu=="CB")
                return 2.3;
            else if(harfNotu=="CC")
                return 2.0;
            else if(harfNotu=="CD")
                return 1.7;
            else if(harfNotu=="DC")
                return 1.3;
            else if(harfNotu=="DD")
                return 1.0;
            else
                return 0.0;
        }
        else if ("A".equalsIgnoreCase(ortHesap.getHarfSis())) {
            if(harfNotu=="A")
                return 4.0;
            else if(harfNotu=="A-")
                return 3.7;
            else if(harfNotu=="B+")
                return 3.3;
            else if(harfNotu=="B")
                return 3.0;
            else if(harfNotu=="B-")
                return 2.7;
            else if(harfNotu=="C+")
                return 2.3;
            else if(harfNotu=="C")
                return 2.0;
            else if(harfNotu=="C-")
                return 1.7;
            else if(harfNotu=="D+")
                return 1.3;
            else if(harfNotu=="D")
                return 1.0;
            else
                return 0.0;
        }
        return -1;
    }


    private double calculateGenelNotOrtalamasi(ortHesap ortHesap) {
        double dersOrtalamasi=0.0;
        int toplamKredi = 0;
        double toplamPuan = 0;
        double ort = ortHesap.getGno();
        int eskiKredi = ortHesap.getEskiKredi();
        for (ders ders : ortHesap.getDersList()) {
            String dersAdi = ders.getDersAdi();
            int kredi = ders.getKredi();
            String harfNotu = ders.getHarfNotu();

            double score = convertHarfNotuToPuan(harfNotu);

            toplamPuan += kredi * score;

            toplamKredi += kredi;
        }

        return (ort * eskiKredi + dersOrtalamasi * toplamKredi) / (eskiKredi+toplamKredi);
    }

    public List<GenelNotOrtalamasiDTO> getGenelNotOrtalamalari() {
        List<ortHesap> tumOrtHesaplar = ortHesapRepository.findAll();

        List<GenelNotOrtalamasiDTO> genelNotOrtalamalari = new ArrayList<>();

        for (ortHesap ortHesap : tumOrtHesaplar) {
            double genelNotOrtalamasi = calculateGenelNotOrtalamasi(ortHesap);
            Date hesaplamaTarihi = ortHesap.getDate();

            GenelNotOrtalamasiDTO dto = new GenelNotOrtalamasiDTO(genelNotOrtalamasi, hesaplamaTarihi);
            genelNotOrtalamalari.add(dto);
        }

        return genelNotOrtalamalari;
    }
    public static class GenelNotOrtalamasiDTO {
        private double genelNotOrtalamasi;
        private Date hesaplamaTarihi;

        public GenelNotOrtalamasiDTO(double genelNotOrtalamasi, Date hesaplamaTarihi) {
            this.genelNotOrtalamasi = genelNotOrtalamasi;
            this.hesaplamaTarihi = hesaplamaTarihi;
        }

    }
}


