package com.cfs.bms.repository;

import com.cfs.bms.model.Booking;
import com.cfs.bms.model.Movie;
import com.cfs.bms.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

    Optional<Payment> findByTransactionId(String transactionId);
}
