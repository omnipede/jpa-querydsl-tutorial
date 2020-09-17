package io.omnipede.jpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="team")
@Getter
@Setter
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "team")
    // 객체의 양방향 관계는 사실 서로 다른 단방향 관계 2개다
    // 연관관계의 주인만이 외래 키를 관리 (등록, 수정)
    // 주인은 mappedBy 속성 X
    // 주인이 아닌쪽은 mappedBy 로 주인 지정
    // 주인이 아닌쪽은 읽기만 가능
    // 외래키가 있는 곳을 주인으로 지정
    private List<Member> members = new ArrayList<>();
}
