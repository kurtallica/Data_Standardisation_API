package kurt.project.standardise.Standardisers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RemovePunctuationTest {

    RemovePunctuation removePunctuation = new RemovePunctuation();

    @Test
    @DisplayName("Ensure special characters are removed.")
    public void removeSpecialCharacters(){

        String input = "!/$£¬%^&*()_HellÁo+-{}[]|\\<>?,/.~@:;'#`";
        String output = removePunctuation.apply(input);

        assertThat(output).isEqualTo("HellÁo");
    }

    @Test
    @DisplayName("Ensure accented characters are not removed.")
    public void removeOnlySpecialCharacters() {

        String input = "!/$£¬%^&*()_Hëllø+-{}[]|\\<>?,/.~@:;'#` 2021";
        String output = removePunctuation.apply(input);

        assertThat(output).isEqualTo("Hëllø 2021");
    }

}

