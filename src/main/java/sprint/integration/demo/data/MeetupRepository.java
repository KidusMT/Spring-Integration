package sprint.integration.demo.data;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sprint.integration.demo.domain.Meetup;

@Repository
public interface MeetupRepository extends JpaRepository<Meetup, Integer> {
}
