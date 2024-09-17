package com.saurbah.lms.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saurbah.lms.model.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
