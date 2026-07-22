package com.example.budgeting;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@EnabledIfEnvironmentVariable(named = "GEMINI_API_KEY", matches = ".+")
class GeminiAiChatModelIT {

    @Autowired
    private ChatModel chatModel;

    @Test
    void should_receiveResponse_when_chatModelIsCalled() {
        String response = chatModel.call("Responda apenas com 'OK' se você estiver recebendo esta mensagem.");

        System.out.println("Resposta da IA: " + response);

        assertThat(response).isNotBlank();
    }
}