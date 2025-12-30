package krishna.poc.mongo.service;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.ReplaceOptions;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;
import krishna.poc.mongo.entity.ConfigurationRule;
import krishna.poc.mongo.exception.MongoDocumentCreationException;
import krishna.poc.mongo.utils.client.MongoDBClient;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

@Slf4j
public class RequestProcessRuleService {

    private final MongoCollection<ConfigurationRule> collection;

    public RequestProcessRuleService(String collectionName) {
        this.collection = MongoDBClient.getDatabase()
                .getCollection(collectionName, ConfigurationRule.class);
    }

    // ---------- READ ----------

    public ConfigurationRule getRuleByRuleName(String ruleName) {
        if (ruleName == null || ruleName.isBlank()) {
            throw new IllegalArgumentException("ruleName must not be null or empty");
        }
        return collection.find(eq("_id", ruleName)).first();
    }

    public List<ConfigurationRule> getAllRules() {
        return collection.find().into(new ArrayList<>());
    }

    // ---------- CREATE ----------

    public InsertOneResult insertRule(ConfigurationRule rule) throws MongoDocumentCreationException {
        if (rule == null || rule.getRuleName() == null) {
            throw new IllegalArgumentException("ConfigurationRule or ruleName is null");
        }

        try {
            InsertOneResult result = collection.insertOne(rule);
            log.info("Rule inserted successfully. ruleName={}", rule.getRuleName());
            return result;
        } catch (Exception e) {
            log.error("Failed to insert rule. ruleName: {}", rule.getRuleName(), e);
            throw new MongoDocumentCreationException("Failed to insert rule ruleName: %s".formatted(rule.getRuleName()), e);
        }
    }

    // ---------- UPDATE (NO UPSERT) ----------

    public UpdateResult updateRule(ConfigurationRule rule) {
        if (rule == null || rule.getRuleName() == null) {
            throw new IllegalArgumentException("ConfigurationRule or ruleName is null");
        }

        UpdateResult result = collection.replaceOne(
                eq("_id", rule.getRuleName()),
                rule
        );

        if (result.getMatchedCount() == 0) {
            log.warn("No rule found to update. ruleName={}", rule.getRuleName());
        } else {
            log.info("Rule updated successfully. ruleName={}", rule.getRuleName());
        }

        return result;
    }

    // ---------- UPSERT (EXPLICIT) ----------

    public UpdateResult upsertRule(ConfigurationRule rule) {
        return collection.replaceOne(
                eq("_id", rule.getRuleName()),
                rule,
                new ReplaceOptions().upsert(true)
        );
    }

    // ---------- DELETE ----------

    public DeleteResult deleteRuleByRuleName(String ruleName) {
        if (ruleName == null || ruleName.isBlank()) {
            throw new IllegalArgumentException("ruleName must not be null or empty");
        }

        DeleteResult result = collection.deleteOne(eq("_id", ruleName));

        if (result.getDeletedCount() == 0) {
            log.warn("No rule found to delete. ruleName={}", ruleName);
        } else {
            log.info("Rule deleted successfully. ruleName={}", ruleName);
        }

        return result;
    }
}
