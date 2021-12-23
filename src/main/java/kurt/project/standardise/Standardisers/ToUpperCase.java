package kurt.project.standardise.Standardisers;

public class ToUpperCase extends StandardiserSuper{

    @Override
    public String apply(String input){
        return input.toUpperCase();
    };
}
