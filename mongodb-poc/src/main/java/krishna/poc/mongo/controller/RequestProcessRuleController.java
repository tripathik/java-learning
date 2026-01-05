package krishna.poc.mongo.controller;

import com.mongodb.client.result.UpdateResult;
import krishna.poc.mongo.entity.ConfigurationRule;
import krishna.poc.mongo.exception.MongoDocumentCreationException;
import krishna.poc.mongo.service.RequestProcessRuleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/rules")
public class RequestProcessRuleController {

    private final RequestProcessRuleService ruleService;

    public RequestProcessRuleController() {
        this.ruleService = new RequestProcessRuleService("RequestProcessRules");
    }

    // ---------------- GET ----------------

    @GetMapping("/{ruleName}")
    public ResponseEntity<ConfigurationRule> getRule(
            @PathVariable String ruleName) {

        ConfigurationRule rule = ruleService.getRuleByRuleName(ruleName);

        if (rule == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(rule);
    }

    @GetMapping
    public ResponseEntity<List<ConfigurationRule>> getAllRules() {
        return ResponseEntity.ok(ruleService.getAllRules());
    }

    // ---------------- CREATE ----------------

    @PostMapping
    public ResponseEntity<String> createRule(
            @RequestBody ConfigurationRule rule) throws MongoDocumentCreationException {

        ruleService.insertRule(rule);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Rule created successfully");
    }

    // ---------------- UPDATE ----------------

    @PutMapping
    public ResponseEntity<String> updateRule(
            @RequestBody ConfigurationRule rule) {

        UpdateResult result =ruleService.updateRule(rule);
        if(result.getMatchedCount()>0){
            return ResponseEntity.ok("Rule updated successfully");
        }
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Rule not found to update operation");
    }

    // ---------------- DELETE ----------------

    @DeleteMapping("/{ruleName}")
    public ResponseEntity<String> deleteRule(
            @PathVariable String ruleName) {

        ruleService.deleteRuleByRuleName(ruleName);
        return ResponseEntity.ok("Rule deleted successfully");
    }
}
