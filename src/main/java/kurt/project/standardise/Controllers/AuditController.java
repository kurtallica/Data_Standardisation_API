package kurt.project.standardise.Controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import kurt.project.standardise.Model.Entry;
import kurt.project.standardise.Repository.EntryRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Tag(
    name = "Audit Controller",
    description = "Endpoints for getting, updating and deleting audit records from the standardisation database"
)
@RestController
public class AuditController {

    private final EntryRepository entryRepository;

    AuditController(EntryRepository entryRepository) {
        this.entryRepository = entryRepository;
    }

        @Operation(summary = "Get one record from the table")
    @GetMapping(value = "/getOneRecord")
    @ResponseBody
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public Map<String, Entry> getOneRecord(
            @Parameter(description = "The audit record to be retrieved", example = "1")
            @RequestParam long id) throws Exception {
        return Map.of("output", entryRepository.getReferenceById(id));
    }

    @Operation(summary = "Get all records from the table")
    @GetMapping(value = "/get-all-records")
    @ResponseBody
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public Map<String, List<?>> getAllRecords() throws Exception {

        return Map.of("output", entryRepository.findAll());

    }

        @Operation(summary = "Delete one record from the table")
    @DeleteMapping(value = "/deleteRecord")
    @ResponseBody
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public void deleteRecord(
            @Parameter(description = "ID of the audit record to be deleted", example = "1")
            @RequestParam long id) throws Exception {

        try {
            entryRepository.deleteById(id);
        } catch (Exception e) {
            e.getMessage();
            System.out.println("Exception: " + e);
        }
    }

        @Operation(summary = "Update one record from the table")
    @PatchMapping(value = "/updateRecord")
    @ResponseBody
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public void updateRecord(
            @Parameter(description = "ID of the audit record to be updated", example = "1")
            @RequestParam long id,
            @Parameter(description = "The input String to be standardised", example = "Tuomas Petäjä, 21056879")
            @RequestParam(required = false) String term,
            @Parameter(description = "The standardisation service method to be used", example = "singleStandardise")
            @RequestParam(required = false) String standardiseMethod,
            @Parameter(description = "The input string in standardised format", example = "TUOMAS PETÄJÄ, 21056879")
            @RequestParam(required = false) String outputTerm) throws Exception {

        Entry entry = entryRepository.getReferenceById(id);

        if (term != null) {
            entry.setTerm(term);
        }
        if (standardiseMethod != null) {
            entry.setStandardisation_method(standardiseMethod);
        }
        if (outputTerm != null) {
            entry.setOutput_term(outputTerm);
        }
        entryRepository.save(entry);
        entryRepository.flush();
    }
}
