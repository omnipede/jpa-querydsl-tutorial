package io.omnipede.jpa.repository;

import io.omnipede.jpa.entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Page<Member> findByName(String name, Pageable pageable);
    Member findByName(String name);
}
