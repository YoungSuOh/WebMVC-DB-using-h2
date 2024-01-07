package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L; // key값을 생성해주는 애

    @Override
    public Member save(Member member) {
        member.setId(++sequence);  // id 세팅
        store.put(member.getId(), member); // store에 key, value 형태로 저장
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) { // store에서 꺼내면 됨.
        /*return store.get(id);*/  // null 일수도 있을 때 Optional.ofNullable로 감싸줌
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream().filter(member -> member.getName().equals(name))
                .findAny();  // findAny는 하나라도 찾아서 나오면 return
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
