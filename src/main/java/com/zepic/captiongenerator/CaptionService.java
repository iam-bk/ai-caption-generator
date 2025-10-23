package com.zepic.captiongenerator;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface CaptionService {

    String generateCaption(String imageUrl) throws JsonProcessingException;

}
