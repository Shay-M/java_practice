package io.nice.wealthrating.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import io.nice.wealthrating.models.RichPerson;

public interface WealthRatingRepository extends JpaRepository<RichPerson, Long>{

}
