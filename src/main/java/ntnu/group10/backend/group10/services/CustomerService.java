package ntnu.group10.backend.group10.services;


import ntnu.group10.backend.group10.entities.Customer;
import ntnu.group10.backend.group10.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;



    public Customer findById(Integer id) {
        return customerRepository.findById(id).orElse(null);
    }

    public boolean add(Customer customer) {
        boolean added = false;
        if (customer != null) {
            Customer exsistingCustomer = findById(customer.getCustomerId());
            if ( exsistingCustomer == null) {
                customerRepository.save(customer);
                added = true;
            }
        }
        return added;
    }


    public boolean remove(int customerId) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        customer.ifPresent(customer1 -> customerRepository.delete(customer1));
        return customer.isPresent();
    }
}
