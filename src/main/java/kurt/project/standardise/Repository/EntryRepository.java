package kurt.project.standardise.Repository;

import kurt.project.standardise.Model.Entry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntryRepository extends JpaRepository<Entry, Long>, EntryRepositoryCustom {
}
