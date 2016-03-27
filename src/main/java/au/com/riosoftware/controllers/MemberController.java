package au.com.riosoftware.controllers;

import au.com.riosoftware.domain.Member;
import au.com.riosoftware.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String listMembers(Model model) {
        model.addAttribute("members", memberService.getAll());
        return "members/list";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String addMember(Model model) {
        model.addAttribute("member", new Member());
        return "members/new";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createMember(@ModelAttribute Member member) {
        memberService.newMember(member);
        return "redirect:/members";
    }

    @RequestMapping(value = "/{id}/delete")
    public String delete(@PathVariable long id){
        memberService.delete(id);
        return "redirect:/members";
    }


}
