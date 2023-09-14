package com.codegym.repository;

import com.codegym.model.Customer;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Repository
public class Repository implements IRepository {
    private static List<Customer> customers = new ArrayList<>();

    static {
        customers.add(new Customer(1, "Nguyen Khac Nhat", "nhat@codegym.vn", "Ha Noi"));
        customers.add(new Customer(1, "Dang Huy Hoa", "hoa@codegym.vn", "Ha Noi"));
        customers.add(new Customer(1, "Le Thi Chau", "chau@codegym.vn", "Ha Noi"));
        customers.add(new Customer(1, "Nguyen Thuy Duong", "duong@codegym.vn", "Ha Noi"));
        customers.add(new Customer(1, "Codegym", "codegym@codegym.vn", "Ha Noi"));
    }

    @Override
    public List<Customer> showList() {
        return customers;
    }
}
