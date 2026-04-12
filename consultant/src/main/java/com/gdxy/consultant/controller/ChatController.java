package com.gdxy.consultant.controller;

import com.gdxy.consultant.aiservice.ConsultantService;
import dev.langchain4j.model.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {
//    /*
//    * langchain4j-open-ai-spring-boot-starter这个起步依赖会自动注入OpenAiChatModel
//    * */
//    @Autowired
//    private OpenAiChatModel model;
//    @RequestMapping("/chat")
//    public String chat(String message){
//        String result=model.chat(message);
//        return result;
//    }

    @Autowired
    private ConsultantService consultantService;
    @RequestMapping("/chat")
    public String chat(String message){
        String result = consultantService.chat(message);
        return result;
    }
}
