package au.com.riosoftware.domain.repositories;

import au.com.riosoftware.domain.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends CrudRepository<Member,Long>{
}
