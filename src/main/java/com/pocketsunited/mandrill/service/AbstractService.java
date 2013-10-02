package com.pocketsunited.mandrill.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pocketsunited.mandrill.data.request.AbstractPayload;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import java.io.IOException;

/**
 * @author Michael Duergner <michael@pocketsunited.com>
 */
public abstract class AbstractService {

    final Logger logger = LoggerFactory.getLogger(getClass());

    String baseUrl = "https://mandrillapp.com/api/1.0";

    HttpClient httpClient;

    ObjectMapper objectMapper;

    String key;

    /**
     *
     * @param baseUrl
     */
    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    /**
     *
     * @param httpClient
     */
    public void setHttpClient(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /**
     *
     * @param objectMapper
     */
    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    /**
     *
     * @param key
     */
    public void setKey(String key) {
        this.key = key;
    }

    @PostConstruct
    public final void postConstruct() {
        onPostConstruct();
    }

    void onPostConstruct() {
        if (null == httpClient) {
            httpClient = new DefaultHttpClient(new PoolingClientConnectionManager());
        }
        if (null == objectMapper) {
            objectMapper = new ObjectMapper();
        }
    }

    <T extends AbstractPayload.Init<T, U>,U extends AbstractPayload> void integrateDefaultValues(AbstractPayload.Init<T, U> payloadBuilder) {
        if (!payloadBuilder.hasKey() && null != key && !key.isEmpty()) {
            payloadBuilder.withKey(key);
        }
    }

    <T, E extends Error> T send(final AbstractPayload payload, TypeReference<T> responseClass, Class<E> errorClass) throws E, IOException {
        try {
            HttpPost request = new HttpPost(baseUrl+payload.getPath());
            String body = objectMapper.writeValueAsString(payload);
            logger.info(body);
            request.setEntity(new StringEntity(body,"UTF-8"));
            HttpResponse response = httpClient.execute(request);
            if (200 == response.getStatusLine().getStatusCode()) {
                T result = objectMapper.readValue(response.getEntity().getContent(),responseClass);
                return result;
            }
            else {
                E error = objectMapper.readValue(response.getEntity().getContent(),errorClass);
                logger.debug("Got error {} while calling {}.", error.toString(), payload.getPath());
                throw error;
            }
        }
        catch (IOException e) {
            logger.debug("Got {} while calling {}.",e.getClass().getSimpleName(),payload.getPath());
            throw  e;
        }
    }
}