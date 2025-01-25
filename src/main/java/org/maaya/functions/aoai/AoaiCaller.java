package org.maaya.functions.aoai;


import java.lang.module.Configuration;

import com.azure.ai.openai.OpenAIClient;
import com.azure.ai.openai.OpenAIClientBuilder;
import com.azure.ai.openai.models.*;
import com.azure.core.credential.AzureKeyCredential;
import com.azure.core.util.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.sun.org.apache.xerces.internal.impl.validation.ConfigurableValidationState;

/**
 * Auzre OpenAI Serviceを呼び出すクラス
 */
public class AoaiCaller {

    String systemMessage = """
            あなたは東京を代表するパリピ（パーティーピーポー、陽キャ）です。どんな質問にもハイテンションで長めに答えてください。
            語尾にはダジャレ風にパリピっぽい単語（例えばシャンパンタワー、ナイトプール、テキーラなど）をつけたりするとさらに素敵です。
            ちなみに知識や知能のレベルは小学生くらいです。でも、難しいことや知らないことを聞かれてもテンションだけで乗り切ってください。
            """;

    /**
     * Azure OpenAI Service を使ってテーマに沿った文章を作成する
     * @param theme テーマ
     * @return 回答文章
     */
    public String createSentence(String theme) {
        // Azure OpenAI Serviceのリクエスト設定をする
        String aoaiApiKey = Configuration.getGlobalConfiguration().get("AOAI_API_KEY");
        String aoaiEndpoint = Configuration.getGlobalConfiguration().get("AOAI_ENDPOINT");
        String aoaiModel = Configuration.getGlobalConfiguration().get("AOAI_MODEL");

        OpenAIClient client = new OpenAIClientBuilder()
        .credential(new AzureKeyCredential(aoaiApiKey))
        .endpoint(aoaiEndpoint)
        .buildClient();

        //チャットリクエスト
        List<ChatRequestMessage> chatMessages = new ArrayList<>();
        chatMessages.add(new ChatRequestSystemMessage(systemMessage));
        chatMessages.add(new ChatRequestUserMessage(theme));

        // execute chat
        ChatCompletions chatCompletions = client.chat().beginChat(aoaiModel, new ChatCompilationOptions(chatMessages));

        //レスポンスデータの取得
        return chatCompletions.getChatCompletion().getMessages().stream()
                .map(chatCompletion -> chatCompletion.getMessage().getContent())
                .collect(Collectors.joining("\n"));
    }

}
