package com.example.demo.Repository;
import com.example.demo.Model.kullanici;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

public interface kullaniciRepository extends JpaRepository<kullanici, String> {
    Optional<kullanici> findByEmail(String email);

}