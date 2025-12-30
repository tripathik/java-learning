package krishna.poc.mongo.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import krishna.poc.mongo.entity.ConfigurationRule;
import krishna.poc.mongo.service.RequestProcessRuleService;
import krishna.poc.mongo.utils.CommonUtils;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class RuleHandler implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

    private static final RequestProcessRuleService ruleService = new RequestProcessRuleService(System.getenv("requestProcessRuleCollectionName"));

    @Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent request, Context context) {
        try {
            String httpMethod = request.getHttpMethod();
            Map<String, String> pathParams = request.getPathParameters();

            return switch (httpMethod) {
                case "GET" -> handleGet(pathParams);
                case "POST" -> handleCreate(request.getBody());
                case "PUT" -> handleUpdate(request.getBody());
                case "DELETE" -> handleDelete(pathParams);
                default -> response(405, "Method Not Allowed");
            };

        } catch (Exception e) {
            log.error("Unhandled exception", e);
            return response(500, e.getMessage());
        }
    }

    // ---------------- HANDLERS ----------------

    private APIGatewayProxyResponseEvent handleGet(Map<String, String> pathParams) {
        String ruleName = pathParams != null ? pathParams.get("ruleName") : null;

        if (ruleName == null) {
            return response(400, "ruleName path parameter is required");
        }

        ConfigurationRule rule = ruleService.getRuleByRuleName(ruleName);

        if (rule == null) {
            return response(404, "Rule not found");
        }

        return response(200, rule);
    }

    private APIGatewayProxyResponseEvent handleCreate(String body) throws Exception {
        ConfigurationRule rule = CommonUtils.jsonToClassObject(body, ConfigurationRule.class);

        ruleService.insertRule(rule);
        return response(201, "Rule created successfully");
    }

    private APIGatewayProxyResponseEvent handleUpdate(String body) throws Exception {
        ConfigurationRule rule = CommonUtils.jsonToClassObject(body, ConfigurationRule.class);

        ruleService.updateRule(rule);
        return response(200, "Rule updated successfully");
    }

    private APIGatewayProxyResponseEvent handleDelete(Map<String, String> pathParams) {
        String ruleName = pathParams != null ? pathParams.get("ruleName") : null;

        if (ruleName == null) {
            return response(400, "ruleName path parameter is required");
        }

        ruleService.deleteRuleByRuleName(ruleName);
        return response(200, "Rule deleted successfully");
    }

    // ---------------- RESPONSE UTILS ----------------
    private APIGatewayProxyResponseEvent response(int statusCode, Object body) {
        try {
            return new APIGatewayProxyResponseEvent()
                    .withStatusCode(statusCode)
                    .withHeaders(Map.of("Content-Type", "application/json"))
                    .withBody(CommonUtils.objectToString(body));
        } catch (Exception e) {
            return new APIGatewayProxyResponseEvent()
                    .withStatusCode(500)
                    .withBody("Serialization error");
        }
    }
}
