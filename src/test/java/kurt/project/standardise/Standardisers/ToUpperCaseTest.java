package kurt.project.standardise.Standardisers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ToUpperCaseTest {

    private ToUpperCase toUpperCaseStandardiser = new ToUpperCase();

    @Test
    @DisplayName("Ensure lower-case input String is converted to upper-case.")
    public void ensureLowerCaseInputStringIsUpperCased(){

        String input = "hello";
        String output = toUpperCaseStandardiser.apply(input);

        assertThat(output).isEqualTo("HELLO");
    }

    @Test
    @DisplayName("Ensure mixed-case input String is converted to upper-case.")
    public void ensureMixedCaseInputStringIsUpperCased() {

        String input = "Hello";
        String output = toUpperCaseStandardiser.apply(input);

        assertThat(output).isEqualTo("HELLO");
    }

}
