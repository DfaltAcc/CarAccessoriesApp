package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import za.ac.cput.domain.Payment;
import za.ac.cput.service.IPaymentService;

import java.util.List;

@RestController
@RequestMapping("/payroll/payments")
public class PaymentController {

    private final IPaymentService paymentService;
    @Autowired
    public PaymentController(IPaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/create")
    public ResponseEntity<Payment> create(@RequestBody Payment payment) {
        Payment createdPayment = paymentService.create(payment);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPayment);
    }


    @GetMapping("/read/{id}")
    public ResponseEntity<Payment> read(@PathVariable String id) {
        Payment payment = paymentService.read(id);
        if (payment != null) {
            return ResponseEntity.ok(payment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Payment> update(@RequestBody Payment payment) {
        Payment updatedPayment = paymentService.update(payment);
        if (updatedPayment != null) {
            return ResponseEntity.ok(updatedPayment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        boolean deleted = paymentService.delete(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Payment>> getAll() {
        List<Payment> payments = paymentService.getAll();
        return ResponseEntity.ok(payments);
    }
}