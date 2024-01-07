package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController { // 선언하면 멤버 컨트롤러를 스프링에 객체 형태로 넣어둠
    /*private final MemberService memberService = new MemberService();*/ // new해서 하면 MemberController 말고도 다른 여러 컨트롤러가 MemberService를 가져다 쓸 수 있음
    private final MemberService memberService; // 스프링 컨테이너에 등록

    @Autowired  // MemberService를 스프링이 컨테이너에 있는 MemberService에 연결을 시켜줌
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }
    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);
        return "redirect:/";
    }
    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members",members);
        return "members/memberList";
    }
}
