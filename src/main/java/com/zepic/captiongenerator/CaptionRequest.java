package com.zepic.captiongenerator;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

@Data
public class CaptionRequest {

    @NotNull
    @URL
    private String imageUrl;

}
