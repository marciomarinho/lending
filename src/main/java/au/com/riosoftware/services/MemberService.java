package au.com.riosoftware.services;


import au.com.riosoftware.domain.Member;
import au.com.riosoftware.domain.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    private MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    public Iterable<Member> getAll(){
        return memberRepository.findAll();

    }

    public Member newMember(Member member){
        return memberRepository.save(member);

    }

    public Member findOne(long id){
        return memberRepository.findOne(id);
    }

    public void delete(long id){
        memberRepository.delete(id);
    }
}
