package com.example.demo.Repository;
import com.example.demo.Model.harfHesap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface harfHesapRepository extends JpaRepository<harfHesap, Long> {

}