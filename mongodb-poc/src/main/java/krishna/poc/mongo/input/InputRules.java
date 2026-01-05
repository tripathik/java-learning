package krishna.poc.mongo.input;

public class InputRules {
    private InputRules(){}
    public static final String ACCOUNT_RULE = """
            {
               "RuleName": "Accounts",
               "RuleDescription": "Rule tp process the Account Registration Request.",
               "CorrelationIdPath": "$.metadata.correlation_id",
               "MessageIdPath": "$.metadata.message_id",
               "DefaultTargetId": [1],
               "DefaultTranslationRuleId": 2,
               "ProcessingConfig": {
                 "Preprocessing": true,
                 "FileProcessing": false,
                 "ResponseProcessing": false,
                 "MultitargetProcessing": false
               },
               "Listener": {},
               "Target": [
                 {
                   "TargetDetails": {},
                   "TargetType": "rest",
                   "TargetId": 1,
                   "TargetName": "test"
                 }
               ]
             }
             
            """;

    public static final String VEHICLE_RULE = """
            {
               "RuleName": "Vehicles",
               "RuleDescription": "Rule tp process the Account Registration Request.",
               "CorrelationIdPath": "$.metadata.correlation_id",
               "MessageIdPath": "$.metadata.message_id",
               "DefaultTargetId": [1],
               "DefaultTranslationRuleId": 2,
               "ProcessingConfig": {
                 "Preprocessing": true,
                 "FileProcessing": false,
                 "ResponseProcessing": false,
                 "MultitargetProcessing": false
               },
               "Listener": {},
               "Target": [
                 {
                   "TargetDetails": {},
                   "TargetType": "rest",
                   "TargetId": 1,
                   "TargetName": "test"
                 }
               ]
             }
            """;

    public static final String RESPONSE_RULE = """
            {
               "RuleName": "Response",
               "RuleDescription": "Rule tp process the Response Request.",
               "CorrelationIdPath": "$.metadata.correlation_id",
               "MessageIdPath": "$.metadata.message_id",
               "DefaultTargetId": [1],
               "DefaultTranslationRuleId": 2,
               "ProcessingConfig": {
                 "Preprocessing": true,
                 "FileProcessing": false,
                 "ResponseProcessing": false,
                 "MultitargetProcessing": false
               },
               "Listener": {},
               "Target": [
                 {
                   "TargetDetails": {},
                   "TargetType": "rest",
                   "TargetId": 1,
                   "TargetName": "test"
                 }
               ]
             }
            """;
}
