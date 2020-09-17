package io.omnipede.jpa.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="member")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    // NULL 이면 안됨, 유일하고 변하면 안됨
    // Long + 대체키 + 키 생성전략 사용 (비지니스와 관련 없는 것을 PK로 사용하자)
    // INT 는 사용하면 안됨 (10억, 20억은 금방 온다)
    private Long id;

    @Column(name="username", nullable = false, length = 20)
    private String name;

    @Column(name="age")
    private Integer age;

    // ENUM type 은 무조건 string 으로 넣어야 한다
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private MemberType memberType = MemberType.USER;

    // 가급적 지연 로딩 사용
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;
}
