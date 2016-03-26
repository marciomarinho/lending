package au.com.riosoftware.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/members")
public class MemberController {

    @RequestMapping(method = RequestMethod.GET)
    public String listMembers() {
        return "members/list";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String addMember() {
        return "members/new";
    }

}
