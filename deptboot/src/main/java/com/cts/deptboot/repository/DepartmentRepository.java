package com.cts.deptboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.deptboot.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>  {

}
