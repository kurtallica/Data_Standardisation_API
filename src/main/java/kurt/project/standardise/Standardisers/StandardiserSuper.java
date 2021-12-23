package kurt.project.standardise.Standardisers;

public abstract class StandardiserSuper {

    public abstract String apply(String input);

    public String getStandardiserName(){return getClass().getSimpleName();};
}
