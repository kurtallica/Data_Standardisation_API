package kurt.project.standardise.Services;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StandardisationServiceTest {

    StandardisationService standardisationService = new StandardisationService();

    @Test
    @DisplayName("Ensure the fullStandardisation service runs successfully.")
    public void ensureFullStandardiseSuccessful() throws Exception {

        StandardisationService standardisationService = new StandardisationService();

        String input = "Tuomas Petäjä, 21056879";
        String output = standardisationService.fullStandardisation(input);

        assertThat(output).isEqualTo("TUOMAS PETAJA ");

    }

    @Test
    @DisplayName("Ensure that null values throw an exception in fullStandardisation service.")
    public void checkNullValueFullStandardisationServiceThrowsException() throws Exception {

        Throwable exception = assertThrows(Exception.class, new Executable() {

            @Override
            public void execute() throws Throwable {

                String input = null;
                String output = standardisationService.fullStandardisation(input);

            }
        });
        assertThat(exception.getMessage()).isEqualTo("Term is null. Please enter a term to continue.");

    }

    @Test
    @DisplayName("Ensure the definedStandardisation service runs successfully.")
    public void ensureDefinedStandardiseSuccessful() throws Exception {

        ArrayList<String> standardiserNameInput = new ArrayList<>();

        standardiserNameInput.add(0, "toUpperCase");
        standardiserNameInput.add(1, "removeNumbers");

        String input = "tuomas petäjä, 21056879";
        String output = standardisationService.definedStandardisation(input, standardiserNameInput);

        assertThat(output).isEqualTo("TUOMAS PETÄJÄ, ");

    }

    @Test
    @DisplayName("Ensure that null values are handled by the definedStandardisation service and not ignored.")
    public void checkDefinedStandardisationNullValueThrowsException() throws Exception {

        ArrayList<String> standardiserNameInput = new ArrayList<>();

        Throwable exception = assertThrows(Exception.class, new Executable() {

            @Override
            public void execute() throws Throwable {

                standardiserNameInput.add(0, "toUpperCase");
                standardiserNameInput.add(1, "removePunctuation");

                String input = null;
                String output = standardisationService.definedStandardisation(input, standardiserNameInput);

            }
        });
        assertThat(exception.getMessage()).isEqualTo("Term is null. Please enter a term to continue.");

    }

    @Test
    @DisplayName("Ensure that incorrect Standardiser names are handled and not ignored.")
    public void checkIncorrectStandardiserThrowsException() throws Exception {

        ArrayList<String> standardiserNameInp = new ArrayList<>();

        Throwable exception = assertThrows(Exception.class, new Executable() {

            @Override
            public void execute() throws Throwable {

                standardiserNameInp.add(0, "toUpperCase");
                standardiserNameInp.add(1, "removeNumerals");

                String input = "Tuomas Petäjä, 21056879";
                String output = standardisationService.definedStandardisation(input, standardiserNameInp);

            }
        });
        assertThat(exception.getMessage()).isEqualTo("Standardiser \"removeNumerals\" not found.");
    }

    @Test
    @DisplayName("Ensure that String comprised of standardise-able characters is successfully standardised.")
    public void checkStandardisationOnNumbersAndPunctuationIsSuccessful() throws Exception {

        ArrayList<String> standardiserNameInput = new ArrayList<>();

        standardiserNameInput.add(0, "removePunctuation");
        standardiserNameInput.add(1, "removeNumbers");

        String input = "21122021!1993,.?#'@2020";
        String output = standardisationService.definedStandardisation(input, standardiserNameInput);

        assertThat(output).isEqualTo("");

    }

    @Test
    @DisplayName("Ensure that the same standardiser executing more than once will not break the Standardisation Service.")
    public void ensureDuplicateStandardiserExecutionDoesNotBreakService() throws Exception {

        ArrayList<String> standardiserNameInput = new ArrayList<>();

        standardiserNameInput.add(0, "removePunctuation");
        standardiserNameInput.add(1, "removePunctuation");


        String input = "!;'#{}'?Tuomas Petäjä[]*&^%";
        String output;

        output = standardisationService.definedStandardisation(input, standardiserNameInput);

        assertThat(output).isEqualTo("Tuomas Petäjä");
    }

    /*@Test
    @DisplayName("Ensure that Standardisers are applied in the order that they are given.")
    public void ensureStandardiserExecutionOrderIsCorrect() throws Exception {

        ArrayList<String> standardiserNameInput = new ArrayList<>();

        standardiserNameInput.add(0, "removePunctuation");
        standardiserNameInput.add(1, "replaceAccentedCharacters");
        standardiserNameInput.add(2, "removeNumbers");
        standardiserNameInput.add(3, "toUpperCase");

        for(String sni : standardiserNameInput){

            System.out.println("Current standardiserNameInput: "  + standardiserNameInput);
                assertThat(sni).isEqualTo(standardisationService.currStandardiser);
            System.out.println("Standardiser applied: "  + standardisationService.currStandardiser);
        }


    }*/
}

