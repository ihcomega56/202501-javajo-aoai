package org.maaya.functions.aoai;


import com.azure.ai.openai.OpenAIClient;
import com.azure.ai.openai.OpenAIClientBuilder;
import com.azure.ai.openai.models.*;
import com.azure.core.credential.AzureKeyCredential;
import com.azure.core.util.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Auzre OpenAI Serviceを呼び出すクラス
 */
public class AoaiCaller {

    String systemMessage = """
            xxxxxx
            """;

    /**
     * Azure OpenAI Service を使ってテーマに沿った文章を作成する
     * @param theme テーマ
     * @return 回答文章
     */
    public String createSentence(String theme) {
        // Azure OpenAI Serviceのリクエスト設定をする


        //チャットリクエスト


        //レスポンスデータの取得


        return "";
    }

}
