package com.ghosttrio.judomanager.search.adapter.port.out.elasticsearch.document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Getter
@Document(indexName = "dojos")
@AllArgsConstructor
@NoArgsConstructor
public class Dojo {
    @Id
    private String id;
    @Field(name = "dojo_id")
    private Long dojoId;
    @Field(name = "name")
    private String name;
    @Field(name = "dojo_code")
    private String dojoCode;
    @Field(name = "price")
    private String price;
    @Field(name = "location")
    private String location;
    @Field(name = "pin", type = FieldType.Object)
    private Pin pin;

    public static Dojo create(Long dojoId, String name, String dojoCode, String price, String location,
                              Double latitude, Double longitude) {
        Pin pin = new Pin(new Location(latitude, longitude));
        return new Dojo(null, dojoId, name, dojoCode, price, location, pin);
    }
}
