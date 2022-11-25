package Spring.io.groundSystem.ZPractice.Jpa.MemberShip;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PointRepository extends CrudRepository<Member, Integer>{
	
	List<Member> findAllById(Integer rn);
}
