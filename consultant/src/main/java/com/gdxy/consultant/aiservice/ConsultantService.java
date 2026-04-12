package com.gdxy.consultant.aiservice;

import dev.langchain4j.service.spring.AiService;
import dev.langchain4j.service.spring.AiServiceWiringMode;
import reactor.core.publisher.Flux;

//方法二
@AiService(
        wiringMode = AiServiceWiringMode.EXPLICIT,//手动装配
        chatModel = "openAiChatModel",//指定模型
        streamingChatModel = "openAiStreamingChatModel"
)
//    方法三 自动装配
//@AiService
public interface ConsultantService {
//    用于聊天的方法
//    public String chat(String message);

    public Flux<String> chat(String message);
}
