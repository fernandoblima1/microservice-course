package com.ati.hrpayroll.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ati.hrpayroll.entities.Payment;
import com.ati.hrpayroll.services.PaymentService;

@Controller
@RequestMapping(value = "/payment")
public class PaymentResource {
  
  @Autowired
  private PaymentService service;

  @GetMapping("/{workerId}/days/{days}")
  public ResponseEntity<Payment> getPayment(@PathVariable Long workerId, @PathVariable Integer days){
    Payment payment = service.getPayment(workerId, days);
    return ResponseEntity.ok(payment);
  }

}
