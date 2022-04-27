package kurt.project.standardise.Standardisers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ToLowerCaseTest {

    private ToLowerCase toLowerCaseStandardiser = new ToLowerCase();

    @Test
    @DisplayName("Ensure upper-case input String is converted to lower-case.")
    public void ensureLowerCaseInputStringIsUpperCased(){

        String input = "HELLO";
        String output = toLowerCaseStandardiser.apply(input);

        assertThat(output).isEqualTo("hello");
    }

    @Test
    @DisplayName("Ensure mixed-case input String is converted to lower-case.")
    public void ensureMixedCaseInputStringIsUpperCased() {

        String input = "HeLLo";
        String output = toLowerCaseStandardiser.apply(input);

        assertThat(output).isEqualTo("hello");
    }

}
