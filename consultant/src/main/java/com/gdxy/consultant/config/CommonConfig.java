package com.gdxy.consultant.config;


import com.gdxy.consultant.aiservice.ConsultantService;
import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.memory.chat.ChatMemoryProvider;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.service.AiServices;
import dev.langchain4j.store.memory.chat.ChatMemoryStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonConfig {
    @Autowired
    private OpenAiChatModel openAiChatModel;
    @Autowired
    private ChatMemoryStore redisChatMemoryStore;
////    方法一
//    @Bean
//    public ConsultantService consultantService(){
//        ConsultantService consultantService = AiServices.builder(ConsultantService.class)
//                .chatModel(openAiChatModel)
//                .build();
//        return consultantService;
//    }

//    构建会话记忆对象
    @Bean
    public ChatMemory chatMemory(){
        MessageWindowChatMemory memory=MessageWindowChatMemory.builder()
                .maxMessages(20)
                .build();
        return memory;
    }

//    构建ChatMemoryProvider对象
    @Bean
    public ChatMemoryProvider chatMemoryProvider(){
        ChatMemoryProvider chatMemoryProvider=new ChatMemoryProvider() {
            @Override
            public ChatMemory get(Object memoryId) {
                MessageWindowChatMemory messageWindowChatMemory=MessageWindowChatMemory.builder()
                        .id(memoryId)
                        .maxMessages(20)
                        .chatMemoryStore(redisChatMemoryStore)
                        .build();
                return messageWindowChatMemory;
            }
        };
        return chatMemoryProvider;
    }

}
