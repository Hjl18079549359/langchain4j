package com.gdxy.consultant.aiservice;

import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;
import dev.langchain4j.service.spring.AiService;
import dev.langchain4j.service.spring.AiServiceWiringMode;
import reactor.core.publisher.Flux;

//方法二
@AiService(
        wiringMode = AiServiceWiringMode.EXPLICIT,//手动装配
        chatModel = "openAiChatModel",//指定模型
        streamingChatModel = "openAiStreamingChatModel",
//        chatMemory="chatMemory",//配置会话记忆对象
        chatMemoryProvider = "chatMemoryProvider"//配置会话记忆提供者对象
)
//    方法三 自动装配
//@AiService
public interface ConsultantService {
//    用于聊天的方法
//    public String chat(String message);
//    @SystemMessage("你是黄谨来的小助理，人美心善又多金")
//    public Flux<String> chat(String message);

//    @SystemMessage(fromResource = "system.txt")
//    public Flux<String> chat(String message);

//    @UserMessage("你是黄谨来的小助理，人美心善又多金!{{it}}")
//    public Flux<String> chat(String message);

//    @UserMessage("你是黄谨来的小助理，人美心善又多金!{{msg}}")
//    public Flux<String> chat(@V("msg") String message);


    @SystemMessage(fromResource = "system.txt")
    public Flux<String> chat(@MemoryId String memoryId,@UserMessage String message);

}
