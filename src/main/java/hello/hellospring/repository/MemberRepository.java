package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); // 회원이 저장됨
    Optional<Member>findById(Long id); // 저장소로부터 id를 찾아옴
    Optional<Member>findByName(String name);  // 저장소로부터 name을 찾아옴
    List<Member>findAll(); // 지금까지 저장된 모든 회원 list 반환
}
