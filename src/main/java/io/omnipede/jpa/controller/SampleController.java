package io.omnipede.jpa.controller;

import com.querydsl.jpa.impl.JPAQueryFactory;
import io.omnipede.jpa.entity.Member;
import io.omnipede.jpa.entity.QMember;
import io.omnipede.jpa.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class SampleController {
    // Repository 를 바로 쓰는 것 보다는 서비스레이어를 두는게 낫지만,
    // Hello world 이므로 그냥 쓴다
    private MemberRepository memberRepository;

    @Autowired
    public SampleController(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @PostConstruct
    public void init() {
        // 임시 데이터 추가
        memberRepository.save(Member.builder().name("John").age(30).build());
        memberRepository.save(Member.builder().name("John1").age(30).build());
        memberRepository.save(Member.builder().name("John2").age(30).build());
        memberRepository.save(Member.builder().name("John3").age(30).build());
    }

    @GetMapping("/hello")
    public Page<Member> member() {
        PageRequest pageRequest = PageRequest.of(0, 10);
        Page<Member> result = memberRepository.findByName("John", pageRequest);
        // Long total = result.getTotalElements(); // 전체 데이터 수

        // 실제로는 DTO를 반환해야 한다
        return memberRepository.findByName("John", pageRequest);
    }

    @GetMapping("/hello2")
    public List<Member> members() {
        return helloQueryDSL();
    }

    @PersistenceContext
    EntityManager em;

    public List<Member> helloQueryDSL() {
        JPAQueryFactory query = new JPAQueryFactory(em);
        QMember m = QMember.member;

        // QueryDSL 장점: 동적쿼리
        return query.selectFrom(m)
                .where(m.age.gt(18).and(m.name.contains("John")))
                .orderBy(m.age.desc())
                .limit(10)
                .offset(0)
                .fetch();
    }
}
