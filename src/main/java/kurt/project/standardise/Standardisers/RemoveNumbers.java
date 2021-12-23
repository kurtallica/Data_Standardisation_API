package kurt.project.standardise.Standardisers;

import java.util.regex.Pattern;

public class RemoveNumbers extends StandardiserSuper{

    @Override
    public String apply(String input){
        return input.replaceAll("[0-9]", "");
    }
}
