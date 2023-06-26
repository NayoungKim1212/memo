package com.sparta.memo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter // Lombok의 Getter
@MappedSuperclass // JPA Entity Class들이 해당 출생 Class를 상속할 경우
                 // createdAt이랑 modifiedAt처럼 추상클래스(abstract class)에 선언한 멤버 변수를
                // Column으로 인식해줌 (Entity Clss의 상속이라고 생각하면 됨)
                // 추상 클래스가 아니여도 구현은 가능 하지만 왜 사용하는가?
                // Timstamped 같은 다른 Entity Class애 상속하기 위해 만들어진 Class인데
                // 객체로 생성할 일이 없기 때문에 abstract을 걸어줌
@EntityListeners(AuditingEntityListener.class) // 해당 class 즉, Timestamoed란 Class의 Auditiong 기능을 포함 시켜줌
                                              // ==> 자동으로 시간에 넣어주는 기능이 수행됨
public abstract class Timestamped {

    @CreatedDate // Entity 객체가 생성되어서 저장이 될 때 createdAt 시간 값이 자동으로 저장됨
                // but, 최초 생성 시간만 저장이 됨
    @Column(updatable = false) // 저장이 된 이후에는 수정이 되면 안되므로 update가 되지 않게 막아줌
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdAt;

    @LastModifiedDate // 조회한 Entity 객체 값을 변경할 때 변경된 시간이 modifiedAt에 자동으로 저장
    @Column
    @Temporal(TemporalType.TIMESTAMP) // Date Package에 들어있는 타입이나 Calender 같은 날짜 데이터를 mapping 할 때 사용
    private LocalDateTime modifiedAt;
}