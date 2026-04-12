package com.gdxy;

import dev.langchain4j.model.openai.OpenAiChatModel;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
//        2、构造OpenAiChatModel对象
        OpenAiChatModel model=OpenAiChatModel.builder()
                .baseUrl("https://dashscope.aliyuncs.com/compatible-mode/v1")
                .apiKey(System.getenv("DASHSCOPE_API_KEY"))
                .modelName("qwen3-max")
                .logRequests(true)//请求的日志信息
                .logResponses(true)//响应的日志信息
                .build();
//        3、调用chat方法，交互
        String res=model.chat("中国所有985大学有哪些？");
        System.out.println(res);
    }
}
