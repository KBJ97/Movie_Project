package com.cinema.member.repository;

import com.cinema.member.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, String> {

    int countByUid(String uid);
//    int countByEmail(String email);
//    MemberEntity findAllByEmail(String email);
//    int countByNameAndEmail(String name, String email);
//    int countByUidAndEmail(String uid, String email);
    int countByHp(String hp);
}
