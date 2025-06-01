package tniteam.marketplaceb2b.graphql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import tniteam.marketplaceb2b.dao.PaymentRepository;
import tniteam.marketplaceb2b.dao.ProductRepository;
import tniteam.marketplaceb2b.model.Payment;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class PaymentGraphQL {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private ProductRepository productRepository;

    // ✅ Query : Liste de tous les paiements
    @QueryMapping
    public List<Payment> allPayments() {
        return paymentRepository.findAll();
    }

    // ✅ Query : Paiement par ID
    @QueryMapping
    public Payment paymentById(@Argument Long id) {
        return paymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found with id " + id));
    }

    // ✅ Mutation : Créer un paiement
    @MutationMapping
    public Payment createPayment(@Argument Float amount, @Argument String currency, @Argument Long id) {
        productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id " + id));

        Payment payment = new Payment();
        payment.setAmount(amount);
        payment.setCurrency(currency);
        payment.setProductId(id);
        payment.setStatus("PENDING");
        payment.setCreatedAt(LocalDateTime.now().toString());
        payment.setStatus("SUCCESS");
        return paymentRepository.save(payment);
    }

    // ✅ Mutation : Mettre à jour le statut d’un paiement
    @MutationMapping
    public Payment updatePayment(@Argument Long id, @Argument String status) {
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found with id " + id));
        payment.setStatus(status);
        return paymentRepository.save(payment);
    }

    // ✅ Mutation : Supprimer un paiement
    @MutationMapping
    public Boolean deletePayment(@Argument Long id) {
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found with id " + id));
        paymentRepository.delete(payment);
        return true;
    }
}
