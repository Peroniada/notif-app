package edu.sperek.jwtpushnotif.infrastructure.repository;

import edu.sperek.jwtpushnotif.domain.model.entity.User;
import edu.sperek.jwtpushnotif.domain.repository.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface H2UserRepository extends JpaRepository<User, Long>, UserRepository {}
