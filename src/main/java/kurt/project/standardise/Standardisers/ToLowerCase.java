package kurt.project.standardise.Standardisers;

public class ToLowerCase extends StandardiserSuper{

    @Override
    public String apply(String input){
        return input.toLowerCase();
    }
}
