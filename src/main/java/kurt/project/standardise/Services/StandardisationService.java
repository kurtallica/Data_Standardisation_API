package kurt.project.standardise.Services;

import kurt.project.standardise.Standardisers.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class StandardisationService {

    ArrayList<StandardiserSuper> standardisers = new ArrayList<>();
    Map<Integer, StandardiserSuper> standardiserMap = new HashMap<>();

    public StandardisationService() {

        RemoveNumbers removeNumbers = new RemoveNumbers();
        RemovePunctuation removePunctuation = new RemovePunctuation();
        ReplaceAccentedCharacters replaceAccentedCharacters = new ReplaceAccentedCharacters();
        ToLowerCase toLowerCase = new ToLowerCase();
        ToUpperCase toUpperCase = new ToUpperCase();

        standardisers.add(toLowerCase);
        standardisers.add(toUpperCase);
        standardisers.add(removeNumbers);
        standardisers.add(removePunctuation);
        standardisers.add(replaceAccentedCharacters);

        standardiserMap.put(1, toLowerCase);
        standardiserMap.put(2, toUpperCase);
        standardiserMap.put(3, removeNumbers);
        standardiserMap.put(4, removePunctuation);
        standardiserMap.put(5, replaceAccentedCharacters);
    }


    public String fullStandardisation(String term) throws Exception {
        if (term == null) {
            throw new Exception("Term is null. Please enter a term to continue.");
        } else if (term.equals("")) {
            return "";
        } else {
            for (StandardiserSuper stn : standardisers) {
                term = stn.apply(term);
            }
            return term;
        }
    }

    public String definedStandardisation(String term, ArrayList<String> standardiserInput) throws Exception {

        boolean stnFound;

        if (term == null) {
            throw new Exception("Term is null. Please enter a term to continue.");
        } else if (term.equals("")) {
            return "";
        } else {
            for (String sni : standardiserInput) {
                stnFound = false;
                for (StandardiserSuper stn : standardisers) {
                    if (sni.equalsIgnoreCase(stn.getStandardiserName())) {
                        stnFound = true;
                        term = stn.apply(term);
                        break;
                    }
                }
                if (!stnFound) {
                    throw new Exception("Standardiser \"" + "sni" + "\" not found.");
                }
            }
        }
        return term;
    }
}
