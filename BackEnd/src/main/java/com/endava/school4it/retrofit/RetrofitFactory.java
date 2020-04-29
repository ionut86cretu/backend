package com.endava.school4it.retrofit;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.ObjectMapper;

import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

class RetrofitFactory {

    private static final int DEFAULT_TIMEOUT = 40;

    @Autowired
    private ObjectMapper jsonMapper;

    class Builder {

        private Map<String, String> headers;

        private String url;

        private OkHttpClient client;

        private int timeout;

        Builder(final String url) {
            this.url = url;
            headers = new HashMap<>();
        }

        Builder client(final OkHttpClient client) {
            this.client = client;
            return this;
        }

        Builder headers(final Map<String, String> headers) {
            this.headers.putAll(headers);
            return this;
        }

        Builder timeout(int timeout) {
            this.timeout = timeout;
            return this;
        }

        Retrofit build() {

            timeout = timeout > 0 ? timeout : DEFAULT_TIMEOUT;

            if (Objects.isNull(client)) {

                client = new OkHttpClient.Builder()
                        .addInterceptor(chain -> chain.proceed(
                                chain.request().newBuilder()
                                        .headers(chain.request().headers().newBuilder().addAll(Headers.of(headers)).build())
                                        .build()
                        ))
                        .readTimeout(timeout, TimeUnit.SECONDS)
                        .writeTimeout(timeout, TimeUnit.SECONDS)
                        .connectTimeout(timeout, TimeUnit.SECONDS)
                        .build();
            }

            return new Retrofit.Builder()
                    .client(client)
                    .baseUrl(url)
                    .addConverterFactory(NullOnEmptyConverterFactory.create())
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(JacksonConverterFactory.create(jsonMapper))
                    .build();
        }

    }

    private static class NullOnEmptyConverterFactory extends Converter.Factory {

        private NullOnEmptyConverterFactory() {
        }

        @Override
        public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
            return body -> (body.contentLength() == 0) ? null : retrofit.nextResponseBodyConverter(this, type, annotations).convert(body);
        }

        public static Converter.Factory create() {
            return new NullOnEmptyConverterFactory();
        }

    }

}
