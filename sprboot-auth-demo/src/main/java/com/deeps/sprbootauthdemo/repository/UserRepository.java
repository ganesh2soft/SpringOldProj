package com.deeps.sprbootauthdemo.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.deeps.sprbootauthdemo.model.Users;

@Repository
@Transactional(readOnly = true)
public interface UserRepository extends JpaRepository<Users, Integer> {

	Users findByUserName(String username);

}
