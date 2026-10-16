package com.demo.example.mscustomerdummy.service;

import com.demo.example.mscustomerdummy.model.Customer;
import com.demo.example.mscustomerdummy.model.CustomerRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerService {
  public Flux<Customer> listCustomers();
  public Mono<Customer> getCustomer(String id);
  public Mono<Customer> createCustomer(CustomerRequest customer);
  public Mono<Customer> updateCustomer(String id, CustomerRequest customer);
  public Mono<Void> deleteCustomer(String id);

}
