package io.omnipede.jpa;

import io.omnipede.jpa.entity.Member;
import io.omnipede.jpa.entity.MemberType;
import io.omnipede.jpa.entity.Team;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

@SpringBootApplication
public class Main {
    // private static final String persistenceUnit = "hello";

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
//        // Spring data jpa 없이 순수한 jpa 만 사용하는 버전
//        // EntityManagerFactory 는 모든 어플리케이션에서 하나만 생성해야 한다
//        EntityManagerFactory emf
//                = Persistence.createEntityManagerFactory(persistenceUnit);
//
//        // EntityManager 는 쓰레드간에 공유하면 안된다 (한번 사용하고 버려야함)
//        EntityManager em = emf.createEntityManager();
//        EntityTransaction transaction = em.getTransaction();
//        transaction.begin();
//
//        try {
//            // Team 추가
//            Team team = new Team();
//            team.setName("TeamA");
//            em.persist(team);
//
//            // Member 추가
//            Member member = new Member();
//            member.setName("hello");
//            member.setAge(30);
//            member.setMemberType(MemberType.ADMIN);
//            member.setTeam(team); // 연관관계의 주인입장에서 업데이트한다
//            em.persist(member);  // 엔티티를 영속
//
//            em.flush(); // 영속성 컨택스트를 데이터베이스에 반영. 단, 영속성 컨택스트를 비우지 않음
//            em.clear(); // 영속성 컨텍스트의 1차 캐시 클리어
//
//            // Member -> Team 탐색
//            Member findMember = em.find(Member.class, member.getId());
//            // em.detach(findMember); // 준영속 상태
//            findMember.setName("John2");
//            Team findTeam = findMember.getTeam(); // Proxy 객체
//            System.out.println(findTeam.getName());
//
//            // Team -> Member(s) 탐색
//            List<Member> members = findTeam.getMembers();
//            members.forEach((m) -> {
//                System.out.println(m.getName());
//            });
//
//            transaction.commit();
//        } catch (Exception e ){
//            transaction.rollback();
//        } finally {
//            em.close();
//        }
    }
}
