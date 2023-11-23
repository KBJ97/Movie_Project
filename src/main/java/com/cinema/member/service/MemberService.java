package com.cinema.member.service;
import com.cinema.member.entity.MemberEntity;
import com.cinema.member.dto.MemberDTO;
import com.cinema.member.repository.MemberRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void save(MemberDTO dto){
        // dto의 값 확인
        log.info("Received DTO in service: {}", dto);

        dto.setPass1(passwordEncoder.encode(dto.getPass1()));
        MemberEntity entity = dto.toEntity(); // DTO를 Entity로 변환
        memberRepository.save(entity); // DB insert
    }

    public int countUid(String uid){
        return memberRepository.countByUid(uid);
    }

    public int countHp(String hp) {
        return memberRepository.countByHp(hp);
    }

//    // 비밀번호 찾기를 통한 비밀번호 재설정
//    public void updatePass(String uid, String pass) {
//        pass = passwordEncoder.encode(pass);
//        MemberEntity entity = memberRepository.findById(uid).get();
//        entity.setPass(pass);
//        memberRepository.save(entity);
//    }

//    // 회원 탈퇴
//    public void updateWdate(String uid) {
//        MemberEntity entity = memberRepository.findById(uid).get();
//        entity.setWdate(LocalDateTime.now());
//        memberRepository.save(entity);
//    }
//
//    // 회원정보 수정 (전화번호)
//    public void updateMember(MemberDTO memberDTO) {
//        MemberEntity entity = memberRepository.findById(memberDTO.getUid()).get();
//        entity.setHp(memberDTO.getHp());
//        memberRepository.save(entity);
//    }
}
