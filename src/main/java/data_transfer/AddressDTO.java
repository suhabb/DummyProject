package data_transfer;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "house_name",
        "house_number",
        "street",
        "county",
        "postcode"
})
@JsonDeserialize(builder = AddressDTO.AddressBuilder.class)
@Builder
@Value
public class AddressDTO {

    @JsonProperty("house_name")
    private final String houseName;
    @JsonProperty("house_number")
    private final String houseNumber;
    @JsonProperty("street")
    private final String district;
    @JsonProperty("county")
    private final String county;
    @JsonProperty("postcode")
    private final String postcode;

    @JsonPOJOBuilder(withPrefix = "")
    public static final class AddressBuilder {
        @JsonProperty("house_name")
        private String houseName;
        @JsonProperty("house_number")
        private String houseNumber;
    }
}
