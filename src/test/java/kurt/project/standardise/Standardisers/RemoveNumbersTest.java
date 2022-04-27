package kurt.project.standardise.Standardisers;



import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RemoveNumbersTest {

    private RemoveNumbers removeNumbers = new RemoveNumbers();

    @Test
    @DisplayName("Ensure numbers are removed from input.")
    public void removeNumbers(){

        String input = "Fret No More - 0125457403";
        String output = removeNumbers.apply(input);

        assertThat(output).isEqualTo("Fret No More - ");
    }

    @Test
    @DisplayName("Ensure numbers which are joined to other characters are removed from input.")
    public void removeConjoinedNumbers(){

        String input = "2JZ - Fam1ily of engi7nes from the Toyota Supra56.";
        String output = removeNumbers.apply(input);

        assertThat(output).isEqualTo("JZ - Family of engines from the Toyota Supra.");
    }

    @Test
    @DisplayName("Ensure empty String is returned when String is comprised of only numbers.")
    public void removeNumbersFromStringOfNumbers(){

        String input = "0394759579837649567";
        String output = removeNumbers.apply(input);

        assertThat(output).isEqualTo("");
    }

}
