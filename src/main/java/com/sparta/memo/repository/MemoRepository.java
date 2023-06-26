package com.sparta.memo.repository;


import com.sparta.memo.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface MemoRepository extends JpaRepository<Memo, Long> {
    List<Memo> findAllByOrderByModifiedAtDesc();
    // find : select --> All --> 전체 select
    // ByOrderBy : 순서 정렬(어떻게 가지고 올것인지)
    // ModifiedAt : ModifiedAt 필드로 정렬
    // Desc : 내림차순
    // ModifiedAt이라는 필드 데이터를 기준으로 정렬해서 전체 데이터를 내보낼 건데
    // 그 기준은 내림차순

//    List<Memo> findAllByUsername(String username); // 모두 가져올건데 Username에 해당하는 것만 가져옴
    // 만약 Robbie라는 사람이 메모 10개를 작성했다 --> Robbie가 작성한 모든 메모를 가지고 올 수 있음
    // 파라미터에 String username을 넣어주면 Username의 where 조건문에 넣어준 파라미터 값이 들어감

    List<Memo> findAllByContentsContainsOrderByModifiedAtDesc(String keyword);
}
