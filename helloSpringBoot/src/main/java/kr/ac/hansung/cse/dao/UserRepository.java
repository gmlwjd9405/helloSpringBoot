package kr.ac.hansung.cse.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.ac.hansung.cse.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findByName(String name);
}
