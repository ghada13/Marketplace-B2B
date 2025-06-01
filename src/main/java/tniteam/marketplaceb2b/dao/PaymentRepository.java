package tniteam.marketplaceb2b.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import tniteam.marketplaceb2b.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}