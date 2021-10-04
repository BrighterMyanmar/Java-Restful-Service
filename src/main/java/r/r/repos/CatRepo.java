package r.r.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import r.r.models.Category;

@Repository
public interface CatRepo extends JpaRepository<Category, Integer> {

}
