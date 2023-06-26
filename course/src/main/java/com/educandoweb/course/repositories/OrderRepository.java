package com.educandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.course.entities.Order;

//Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
