package com.javalearn.hrpayroll.service;


import com.javalearn.hrpayroll.entities.Payment;
import com.javalearn.hrpayroll.entities.Worker;
import com.javalearn.hrpayroll.feignclients.WorkerFeignClient;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


    @Service
    public class PaymentService {
   @Autowired
   private WorkerFeignClient workerFeignClient;
    public Payment getPayment(long workerId, int days){

    Worker worker  = workerFeignClient.findById(workerId).getBody();

    return new Payment(worker.getName(), worker.getDailyIncome(), days);
}
}
