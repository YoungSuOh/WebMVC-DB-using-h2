package hello.hellospring.domain;

public class Member {
    private Long id; // system이 저장한 id -> 고객이 저장한 id 아님
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
