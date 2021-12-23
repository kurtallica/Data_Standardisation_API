package kurt.project.standardise.Standardisers;

import org.apache.commons.lang3.StringUtils;

import java.text.Normalizer;

public class ReplaceAccentedCharacters extends StandardiserSuper{

    @Override
    public String apply(String input){
        return StringUtils.stripAccents(input);
    }
}
