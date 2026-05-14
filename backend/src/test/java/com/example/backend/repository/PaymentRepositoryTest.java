
package com.example.backend.repository;

import com.example.backend.Entity.Payment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class PaymentRepositoryTest {

    @Autowired
    private PaymentRepository paymentRepository;

    @Test
    void shouldFindLatestPaymentByPaymentId() {

        Payment latestPayment =
                paymentRepository.findTopByOrderByPaymentIdDesc();

        assertNotNull(latestPayment);

        assertNotNull(latestPayment.getPaymentId());
    }
}