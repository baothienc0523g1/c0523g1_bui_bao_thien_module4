package com.codegym.repository;

import com.codegym.model.Customer;

import java.util.ArrayList;
import java.util.List;
@org.springframework.stereotype.Repository
public class Repository implements IRepository{
    private static List<Customer> customerList = new ArrayList<>();
    static {
        customerList.add(new Customer(1, "Nguyen Khac Nhat", "nhat@codegym.vn", "Ha Noi"));
        customerList.add(new Customer(2, "Dang Huy Hoa", "hoa@codegym.vn", "Da Neng"));
        customerList.add(new Customer(3, "Le Thuy Chau", "chou@codegym.vn", "Kwang Binh"));
        customerList.add(new Customer(4, "Nguyen Hoang Thuy Duong", "duong@codegym.vn", "Dong Nike"));
        customerList.add(new Customer(5, "Tran Bao Lam", "lam@codegym.vn", "Like Chou"));
    }
    @Override
    public List<Customer> findAll() {
        return customerList;
    }

    @Override
    public Customer findByID(int id) {
        return customerList.get(id);
    }

    @Override
    public void save(Customer customer) {
        customerList.add(customer);
    }
}
