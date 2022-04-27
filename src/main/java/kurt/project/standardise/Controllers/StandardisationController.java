package kurt.project.standardise.Controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import kurt.project.standardise.Model.Entry;
import kurt.project.standardise.Repository.EntryRepository;
import kurt.project.standardise.Services.StandardisationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Map;

@Api(
        description = "Endpoints for partially or fully standardising string input.",
        tags = {"Standardisation Controller"}
)
@RestController
@AllArgsConstructor
public class StandardisationController {

    @Autowired
    StandardisationService standardisationService;

    @Autowired
    EntryRepository entryRepository;

    final String key = "output";

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String handleException(Exception e){
        LocalDateTime timestamp = LocalDateTime.now();
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;

        return "Date/Time:\t"
                + timestamp + "\n"
                + "Status:\t\t"
                + badRequest + "\n"
                + "Exception:\t"
                + e.getMessage();
    }

    @ApiOperation("Apply single standardiser to term")
    @GetMapping("/single-standardise")
    @ResponseBody
    public Map<String, String> singleStandardisationOfTerm(
            @ApiParam(value = "The input which will be standardised", example = "Baron Jaè'jebiphè")
            @RequestParam(required = false, value = "term") String term,
            @ApiParam(value = "The standardiser to be applied to \"term\"", example = "replaceAccentedCharacters")
            @RequestParam(value = "standardiserInput") String standardiserInput) throws Exception {

        Entry entry = new Entry();

        ArrayList<String> standardiserName = new ArrayList<>();
        standardiserName.add(standardiserInput);

        String standardised = standardisationService.definedStandardisation(term, standardiserName);

        entry.setTerm(term);
        entry.setStandardisation_method("singleStandardise");
        entry.setOutput_term(standardised);

        entryRepository.save(entry);
        entryRepository.flush();

        return Map.of(key, standardised);
    }

    @ApiOperation(value = "Apply one or more standardisers to term")
    @PostMapping("/multiple-standardise")
    @ResponseBody
    public Map<String, String> multipleStandardisationOfTerm(
            @ApiParam(value = "A map of String (term) and Object (standardiser) ",
                    example = "{\n" +
                            "   \"term\": \"Baron Jaè'jebiphè\", \n" +
                            "   \"standardisers\": \n" +
                            "   [\n" +
                            "   \"ToLowerCase\",\n" +
                            "   \"ToUpperCase\",\n" +
                            "   \"RemoveNumbers\",\n" +
                            "   \"RemovePunctuation\",\n" +
                            "   \"ReplaceAccentedCharacters\"\n" +
                            "   ]\n" +
                            "}")
            @RequestBody Map<String, Object> standardiserInput) throws Exception {

        Entry entry = new Entry();

        String term = (String) standardiserInput.get("term");
        ArrayList<String> inputStandardisers = (ArrayList<String>) standardiserInput.get("standardisers");
        String standardised = standardisationService.definedStandardisation(term, inputStandardisers);

        entry.setTerm(term);
        entry.setStandardisation_method("multipleStandardise");
        entry.setOutput_term(standardised);

        entryRepository.save(entry);
        entryRepository.flush();

        return Map.of(key, standardised);
    }

    @ResponseBody
    @ApiOperation(value="apply all standardisers to term")
    @GetMapping("/full-standardise")
    public Map<String, String> fullStandardisationOfTerm(
            @ApiParam(value = "The input which will be standardised", example = "Baron9 Jaè'jebiphè")
            @RequestParam(required = false, value = "term") String term) throws Exception {

        Entry entry = new Entry();

        String standardised = standardisationService.fullStandardisation(term);

        entry.setTerm(term);
        entry.setStandardisation_method("fullStandardise");
        entry.setOutput_term(standardised);

        entryRepository.save(entry);
        entryRepository.flush();

        return Map.of(key, standardised);
    }
}
