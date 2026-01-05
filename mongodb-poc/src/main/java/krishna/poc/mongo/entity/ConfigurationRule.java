package krishna.poc.mongo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import krishna.poc.mongo.entity.processing.ProcessingConfig;
import krishna.poc.mongo.entity.target.Target;
import lombok.*;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ConfigurationRule {
    @BsonId
    @BsonProperty("_id")
    @JsonProperty("RuleName")
    private String ruleName;

    @BsonProperty("RuleDescription")
    @JsonProperty("RuleDescription")
    private String ruleDescription;

    @BsonProperty("CorrelationIdPath")
    @JsonProperty("CorrelationIdPath")
    private String correlationIdPath;

    @BsonProperty("MessageIdPath")
    @JsonProperty("MessageIdPath")
    private String messageIdPath;

    @BsonProperty("DefaultTargetId")
    @JsonProperty("DefaultTargetId")
    private List<Integer> defaultTargetId;

    @BsonProperty("DefaultTranslationRuleId")
    @JsonProperty("DefaultTranslationRuleId")
    private int defaultTranslationRuleId;

    @BsonProperty("ProcessingConfig")
    @JsonProperty("ProcessingConfig")
    private ProcessingConfig processingConfig;

    @BsonProperty("Listener")
    @JsonProperty("Listener")
    private Map<String, Object> listener;

    @BsonProperty("Target")
    @JsonProperty("Target")
    private List<Target> target;
}
