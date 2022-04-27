package kurt.project.standardise.Controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import kurt.project.standardise.Model.Entry;
import kurt.project.standardise.Repository.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(
        description = "Endpoints for getting," +
                " updating and deleting audit records from the standardisation database", tags = {"Audit Controller"}
)
@RestController
public class AuditController {

    @Autowired
    private EntryRepository entryRepository;

    @ApiOperation(value = "Get one record from the table")
    @GetMapping(value = "/getOneRecord")
    @ResponseBody
    public Map<String, Entry> getOneRecord(
            @ApiParam(value = "The audit record to be retrieved", example = "1")
            @RequestParam(value = "id") long id) throws Exception {

        if (entryRepository.getOne(id) == null) {
            throw new Exception("Record \"" + id + "\" not found");
        } else {
            return Map.of("output", entryRepository.getOne(id));
        }
    }

    @ApiOperation(value = "Get all records from the table")
    @GetMapping(value = "/get-all-records")
    @ResponseBody
    public Map<String, List<?>> getAllRecords() throws Exception {

        return Map.of("output", entryRepository.findAll());

    }

    @ApiOperation(value = "Delete one record from the table")
    @DeleteMapping(value = "/deleteRecord")
    @ResponseBody
    public void deleteRecord(
            @ApiParam(value = "ID of the audit record to be deleted", example = "1")
            @RequestParam(value = "id") long id) throws Exception {

        try {
            entryRepository.deleteById(id);
        } catch (Exception e) {
            e.getMessage();
            System.out.println("Exception: " + e);
        }
    }

    @ApiOperation(value = "Update one record from the table")
    @PatchMapping(value = "/updateRecord")
    @ResponseBody
    public void updateRecord(
            @ApiParam(value = "ID of the audit record to be updated", example = "1")
            @RequestParam(value = "id") long id,
            @ApiParam(value = "The input String to be standardised", example = "Tuomas Petäjä, 21056879")
            @RequestParam(required = false, value = "term") String term,
            @ApiParam(value = "The standardisation service method to be used", example = "singleStandardise")
            @RequestParam(required = false, value = "standardisation_method") String standardiseMethod,
            @ApiParam(value = "The input string in standardised format", example = "TUOMAS PETÄJÄ, 21056879")
            @RequestParam(required = false, value = "output_term") String outputTerm) throws Exception {

        Entry entry = entryRepository.getOne(id);

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
