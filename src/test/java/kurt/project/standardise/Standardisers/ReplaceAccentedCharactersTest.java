package kurt.project.standardise.Standardisers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ReplaceAccentedCharactersTest {

    @Test
    @DisplayName("Ensure accented characters are replaced with ISO basic Latin alphabet characters.")
    public void replaceAccentedCharacters(){

        ReplaceAccentedCharacters replaceAccentedCharacters = new ReplaceAccentedCharacters();

        String input = "ÀÁÂÃÄÅÇĎÈÉÊËÌÍÎÏÑÒÓÔÕÖŠÙÚÛÜÝŸŽàáâãäåçďèéêëìíîïñòóôõöšùúûüýÿž";

        String output = replaceAccentedCharacters.apply(input);

        assertThat(output).isEqualTo("AAAAAACDEEEEIIIINOOOOOSUUUUYYZaaaaaacdeeeeiiiinooooosuuuuyyz");
    }
}

