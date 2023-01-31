package jpa.pricehoon.channel;

import jakarta.persistence.*;
import jpa.pricehoon.thread.Thread;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.LinkedHashSet;
import java.util.Set;
@NoArgsConstructor(access = AccessLevel.PROTECTED)

@Entity
@Getter

public class Channel {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Long id;


    /**
     * 컬럼 - 연관관계 컬럼을 제외한 컬럼을 정의합니다.
     */
    private String name;

    @Enumerated(EnumType.STRING) // String타입으로 저장하겠다.
    private Type type;

    public enum Type{
        PUBLIC,
        PRIVATE
    }

    /**
     * 생성자 - 약속된 형태로만 생성가능하도록 합니다.
     */

    @Builder
    public Channel(String name,Type type){
        this.name = name;
        this.type = type;
    }

    /**
     * 연관관계 - Foreign Key 값을 따로 컬럼으로 정의하지 않고 연관 관계로 정의합니다.
     */

    @OneToMany(mappedBy = "channel")
    private Set<Thread> threads = new LinkedHashSet<>();

    /**
     * 연관관계 편의 메소드 - 반대쪽에는 연관관계 편의 메소드가 없도록 주의합니다.
     */
    public void addThread(Thread thread){
        this.threads.add(thread);
    }

    /**
     * 서비스 메소드 - 외부에서 엔티티를 수정할 메소드를 정의합니다. (단일 책임을 가지도록 주의합니다.)
     */



}
