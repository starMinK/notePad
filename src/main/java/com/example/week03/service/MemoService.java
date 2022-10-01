package com.example.week03.service;

import com.example.week03.domain.Memo;
import com.example.week03.domain.MemoRepository;
import com.example.week03.domain.MemoRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service //Service임을 스프링에게 알려줌
@RequiredArgsConstructor //final 쓰면 못받을수도있을것 같은데?->의 조치
public class MemoService {

    private final MemoRepository memoRepository;

    @Transactional //이게 진짜 DB에 반영이 되야돼 ->한번 더 선언
    public Long update(Long id, MemoRequestDto requestDto){
        Memo memo = memoRepository.findById(id).orElseThrow(
                () -> new NullPointerException("id가 존재하지 않습니다.")
        );

        memo.update(requestDto);
        return memo.getId();
    }
}