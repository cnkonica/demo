package com.cnkonica.demo.example.repository;

import com.cnkonica.demo.example.domain.OrmUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrmUserRepository extends JpaRepository<OrmUser, Long> {
}
