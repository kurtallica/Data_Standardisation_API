package kurt.project.standardise.Repository;

import java.util.List;

public interface EntryRepositoryCustom {

    String getEntryById(long id);
    List<List<String>> procedureGetInputMethodOutputWhereFullStandardise();
}
