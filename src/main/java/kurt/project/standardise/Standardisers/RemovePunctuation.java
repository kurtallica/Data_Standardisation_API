package kurt.project.standardise.Standardisers;

public class RemovePunctuation extends StandardiserSuper{

    @Override
    public String apply(String input){
        return input.replaceAll("\\p{Punct}", "");
    }
}
