package com.medibill.main.loginusers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface LoginUserRepository extends JpaRepository<LoginUsers, String>{
}
