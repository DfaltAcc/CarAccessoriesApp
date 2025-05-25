package za.ac.cput.service.Impl; // Or za.ac.cput.service

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import za.ac.cput.domain.Payment;
import za.ac.cput.repository.PaymentRepository; // Import your repository
import za.ac.cput.service.IPaymentService; // Import your service interface

import java.util.List;
import java.util.Optional;

@Service("paymentServiceImpl")
public class PaymentServiceImpl implements IPaymentService {

    private final PaymentRepository repository;


    @Autowired
    public PaymentServiceImpl(PaymentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Payment create(Payment payment) {
        return repository.save(payment);
    }

    @Override
    public Payment read(String id) {
        Optional<Payment> optionalPayment = repository.findById(id);
        return optionalPayment.orElse(null);
    }

    @Override
    public Payment update(Payment payment) {
        return repository.save(payment);
    }

    @Override
    public boolean delete(String id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Payment> getAll() {
        return repository.findAll();
    }


}