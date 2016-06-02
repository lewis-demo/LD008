package org.lewis.vaadin.hello.repository;

import java.util.List;

import org.lewis.vaadin.hello.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	public List<Customer> findByLastNameStartsWithIgnoreCase(String lastName);

}
