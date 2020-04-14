
package com.estafet.openshift.boost.messages.github;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "content_type",
    "insecure_ssl",
    "url"
})
public class Config {

    @JsonProperty("content_type")
    private String contentType;
    @JsonProperty("insecure_ssl")
    private String insecureSsl;
    @JsonProperty("url")
    private String url;

    @JsonProperty("content_type")
    public String getContentType() {
        return contentType;
    }

    @JsonProperty("content_type")
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    @JsonProperty("insecure_ssl")
    public String getInsecureSsl() {
        return insecureSsl;
    }

    @JsonProperty("insecure_ssl")
    public void setInsecureSsl(String insecureSsl) {
        this.insecureSsl = insecureSsl;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

}
