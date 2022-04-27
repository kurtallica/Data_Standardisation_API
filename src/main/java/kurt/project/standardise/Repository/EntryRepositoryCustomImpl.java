package kurt.project.standardise.Repository;

import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class EntryRepositoryCustomImpl implements EntryRepositoryCustom{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public String getEntryById(long id) {
        String sql = "" +
                "SELECT term" +
                "FROM standardise_audit" +
                "WHERE record_id = :id";
        TypedQuery<String> query = entityManager.createQuery(sql, String.class);
        query.setParameter("id", id);

        return query.getSingleResult();
    }

    @Override
    public List<List<String>> procedureGetInputMethodOutputWhereFullStandardise() {

        String sql = "GetInputMethodOutputWhereFullStandardise";
        StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery(sql);

        return storedProcedureQuery.getResultList();
    }
}

