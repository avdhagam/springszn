package com.cars24.csms.data.dao.Impl;

import com.cars24.csms.data.dao.EmployeeDao;
import com.cars24.csms.data.req.CreateEmployeeRequest;
import com.cars24.csms.data.resp.CreateEmployeeResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Slf4j
@Repository
@RequiredArgsConstructor
public class EmployeeDaoImp implements EmployeeDao {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public int createEmployee(CreateEmployeeRequest createEmployeeRequest, int userId) {
        String sql = "INSERT INTO employees (user_id, name, email, department) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sql, userId, createEmployeeRequest.getName(), createEmployeeRequest.getEmail(), createEmployeeRequest.getRole());
    }

    @Override
    public boolean checkIfEmailExists(String email) {
        String sql = "SELECT COUNT(*) FROM employees WHERE email = ?";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, email);
        return count != null && count > 0;
    }

    @Override
    public Optional<CreateEmployeeResponse> getEmployeeById(int id) {
        String sql = "SELECT e.user_id, e.name, e.email, e.department FROM employees e WHERE e.user_id = ?";


        try {
            CreateEmployeeResponse employee = jdbcTemplate.queryForObject(
                    sql,
                    new Object[]{id},  // Pass query parameters as an array
                    new BeanPropertyRowMapper<>(CreateEmployeeResponse.class) // Map result to the object
            );
            return Optional.ofNullable(employee);
        } catch (Exception e) {
            log.error("[getEmployeeById] Employee with ID {} not found", id, e);
            return Optional.empty();
        }
    }



}
