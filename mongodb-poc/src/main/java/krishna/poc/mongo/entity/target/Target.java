package krishna.poc.mongo.entity.target;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.util.Map;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Target {
    @BsonProperty("TargetDetails")
    @JsonProperty("TargetDetails")
    private Map<String, Object> targetDetails;

    @BsonProperty("TargetType")
    @JsonProperty("TargetType")
    private String targetType;

    @BsonProperty("TargetId")
    @JsonProperty("TargetId")
    private int targetId;

    @BsonProperty("TargetName")
    @JsonProperty("TargetName")
    private String targetName;
}
