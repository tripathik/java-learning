package krishna.poc.mongo.handler;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import krishna.poc.mongo.entity.ConfigurationRule;
import krishna.poc.mongo.service.RequestProcessRuleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedConstruction;
import org.mockito.Mockito;

import com.amazonaws.services.lambda.runtime.Context;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
class RuleHandlerTest {
    private RuleHandler handler;
    private Context context;

    @BeforeEach
    void setUp() {
        context = Mockito.mock(Context.class);
        handler = new RuleHandler();
    }

    @Test
    void testGetRule_Success() {
        try (MockedConstruction<RequestProcessRuleService> mocked =
                     Mockito.mockConstruction(RequestProcessRuleService.class,
                             (mock, ctx) -> {
                                 Mockito.when(mock.getRuleByRuleName("Accounts"))
                                         .thenReturn(new ConfigurationRule());
                             })) {

            APIGatewayProxyRequestEvent request = new APIGatewayProxyRequestEvent()
                    .withHttpMethod("GET")
                    .withPathParameters(Map.of("ruleName", "Accounts"));

            APIGatewayProxyResponseEvent response =
                    handler.handleRequest(request, context);

            assertEquals(200, response.getStatusCode());
        }
    }
    @Test
    void testGetRule_NotFound() {
        try (MockedConstruction<RequestProcessRuleService> mocked =
                     Mockito.mockConstruction(RequestProcessRuleService.class,
                             (mock, ctx) -> {
                                 Mockito.when(mock.getRuleByRuleName("Unknown"))
                                         .thenReturn(null);
                             })) {

            APIGatewayProxyRequestEvent request = new APIGatewayProxyRequestEvent()
                    .withHttpMethod("GET")
                    .withPathParameters(Map.of("ruleName", "Unknown"));

            APIGatewayProxyResponseEvent response =
                    handler.handleRequest(request, context);

            assertEquals(404, response.getStatusCode());
        }
    }
}