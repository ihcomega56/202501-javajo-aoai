package org.maaya.functions.aoai;

import java.util.*;
import com.microsoft.azure.functions.annotation.*;
import com.microsoft.azure.functions.*;

/**
 * Azure Functions(HTTP Trigger).
 */
public class HttpTrigger {
    /**
     * AOAIから文章を生成するシステム。
     * @param request リクエスト. themeパラメータを含む。
     */
    @FunctionName("ｘｘｘｘｘ")
    public HttpResponseMessage run(
            @com.microsoft.azure.functions.annotation.HttpTrigger(name = "req", methods = {HttpMethod.GET, HttpMethod.POST}, authLevel = AuthorizationLevel.FUNCTION) HttpRequestMessage<Optional<String>> request,
            final ExecutionContext context) {

        context.getLogger().info("生成開始！");

        // フリ文章作成


        //Azure OpenAI Service を使ってテーマに沿った文章を作成する


        if (response.text() == null) {
            return request.createResponseBuilder(HttpStatus.BAD_REQUEST).body("リクエスト変数確認してくれ!").build();
        } else {
            return request.createResponseBuilder(HttpStatus.OK).body(response).build();
        }
    }
}
