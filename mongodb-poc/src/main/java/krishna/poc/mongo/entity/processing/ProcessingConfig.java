package krishna.poc.mongo.entity.processing;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.codecs.pojo.annotations.BsonProperty;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProcessingConfig {
    @BsonProperty("Preprocessing")
    @JsonProperty("Preprocessing")
    private boolean preprocessing;

    @BsonProperty("FileProcessing")
    @JsonProperty("FileProcessing")
    private boolean fileProcessing;

    @BsonProperty("ResponseProcessing")
    @JsonProperty("ResponseProcessing")
    private boolean responseProcessing;

    @BsonProperty("MultitargetProcessing")
    @JsonProperty("MultitargetProcessing")
    private boolean multiTargetProcessing;
}