package kurt.project.standardise.Controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import kurt.project.standardise.Services.StandardisationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    final String key = "output";

    @ApiOperation("Apply single standardiser to term")
    @GetMapping("/single-standardise")
    @ResponseBody
    public Map<String, String> singleStandardisationOfTerm(
            @ApiParam(value = "The input which will be standardised", example = "Baron Jaè'jebiphè")
            @RequestParam(required = false, value = "term") String term,
            @ApiParam(value = "The standardiser to be applied to \"term\"", example = "replaceAccentedCharacters")
            @RequestParam(value = "standardiserInput") String standardiserInput) throws Exception {

        ArrayList<String> standardiserName = new ArrayList<>();
        standardiserName.add(standardiserInput);

        return Map.of(key, standardisationService.definedStandardisation(term, standardiserName));
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

        String term = (String) standardiserInput.get("term");
        ArrayList<String> inputStandardisers = (ArrayList<String>) standardiserInput.get("standardisers");

        return Map.of(key, standardisationService.definedStandardisation(term, inputStandardisers));
    }

    @ResponseBody
    @ApiOperation(value="apply all standardisers to term")
    @GetMapping("/full-standardise")
    public Map<String, String> fullStandardisationOfTerm(
            @ApiParam(value = "The input which will be standardised", example = "Baron9 Jaè'jebiphè")
            @RequestParam(required = false, value = "term") String term) throws Exception {

        return Map.of(key, standardisationService.fullStandardisation(term));
    }
}
