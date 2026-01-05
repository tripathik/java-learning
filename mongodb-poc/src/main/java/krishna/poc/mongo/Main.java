package krishna.poc.mongo;

import com.mongodb.client.result.InsertOneResult;
import krishna.poc.mongo.entity.ConfigurationRule;
import krishna.poc.mongo.exception.JsonObjectConverterException;
import krishna.poc.mongo.exception.MongoDocumentCreationException;
import krishna.poc.mongo.exception.RuleNotFoundException;
import krishna.poc.mongo.input.InputRules;
import krishna.poc.mongo.service.RequestProcessRuleService;
import krishna.poc.mongo.utils.CommonUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) throws JsonObjectConverterException, MongoDocumentCreationException, RuleNotFoundException {
        RequestProcessRuleService requestProcessRuleService = new RequestProcessRuleService("RequestProcessRules");
        String action = "insert";
        switch (action) {
            case "insert":
                String rule = InputRules.RESPONSE_RULE;
                ConfigurationRule configurationRule = CommonUtils.jsonToClassObject(rule, ConfigurationRule.class);
                InsertOneResult result = requestProcessRuleService.insertRule(configurationRule);
                log.info("Insert ID: {}", result.getInsertedId());
                break;
            case "get":
                ConfigurationRule ruleResult = requestProcessRuleService.getRuleByRuleName("Accounts");
                log.info("Received Rule: {}", ruleResult);
                break;
            case "findall":
                requestProcessRuleService.getAllRules();
                break;
            case "update":
                String ruleTobeUpdated = InputRules.RESPONSE_RULE;
                ConfigurationRule updateRule = CommonUtils.jsonToClassObject(ruleTobeUpdated, ConfigurationRule.class);
                requestProcessRuleService.updateRule(updateRule);
                break;
            case "delete":
                requestProcessRuleService.deleteRuleByRuleName("Response");
                break;
            default:
                break;

        }
    }
}