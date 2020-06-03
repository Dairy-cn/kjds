package com.cross.interfaces;

import org.springframework.http.*;
import org.springframework.util.Assert;
import org.springframework.util.MultiValueMap;
import org.springframework.util.ObjectUtils;

import java.io.Serializable;
import java.net.URI;
import java.util.Arrays;
import java.util.LinkedHashSet;

/*************************************************************
 * Description: 
 * Author: Dairy
 * CreateTime: 2019/12/11
 ************************************************************/


public class CustomerResponseEntity<T> extends HttpEntity<T> implements Serializable {
    
    private Object statusCode = null;
    
    public CustomerResponseEntity() {
    }
    
    public CustomerResponseEntity(HttpStatus status) {
        this((T) null, (MultiValueMap)null, (HttpStatus)status);
    }
    
    public CustomerResponseEntity(T body, HttpStatus status) {
        this(body, (MultiValueMap)null, (HttpStatus)status);
    }
    
    public CustomerResponseEntity(MultiValueMap<String, String> headers, HttpStatus status) {
        this((T) null, headers, (HttpStatus)status);
    }
    
    public CustomerResponseEntity(T body, MultiValueMap<String, String> headers, HttpStatus status) {
        super(body, headers);
        Assert.notNull(status, "HttpStatus must not be null");
        this.statusCode = status;
    }
    
    private CustomerResponseEntity(T body, MultiValueMap<String, String> headers, Object statusCode) {
        super(body, headers);
        this.statusCode = statusCode;
    }
    
    public HttpStatus getStatusCode() {
        return this.statusCode instanceof HttpStatus ? (HttpStatus)this.statusCode : HttpStatus.valueOf((Integer)this.statusCode);
    }
    
    public int getStatusCodeValue() {
        return this.statusCode instanceof HttpStatus ? ((HttpStatus)this.statusCode).value() : (Integer)this.statusCode;
    }
    
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        } else if (!super.equals(other)) {
            return false;
        } else {
            CustomerResponseEntity<?> otherEntity = (CustomerResponseEntity)other;
            return ObjectUtils.nullSafeEquals(this.statusCode, otherEntity.statusCode);
        }
    }
    
    public int hashCode() {
        return super.hashCode() * 29 + ObjectUtils.nullSafeHashCode(this.statusCode);
    }
    
    public String toString() {
        StringBuilder builder = new StringBuilder("<");
        builder.append(this.statusCode.toString());
        if (this.statusCode instanceof HttpStatus) {
            builder.append(' ');
            builder.append(((HttpStatus)this.statusCode).getReasonPhrase());
        }
        
        builder.append(',');
        T body = this.getBody();
        HttpHeaders headers = this.getHeaders();
        if (body != null) {
            builder.append(body);
            if (headers != null) {
                builder.append(',');
            }
        }
        
        if (headers != null) {
            builder.append(headers);
        }
        
        builder.append('>');
        return builder.toString();
    }
    
    public static CustomerResponseEntity.BodyBuilder status(HttpStatus status) {
        Assert.notNull(status, "HttpStatus must not be null");
        return new CustomerResponseEntity.DefaultBuilder(status);
    }
    
    public static CustomerResponseEntity.BodyBuilder status(int status) {
        return new CustomerResponseEntity.DefaultBuilder(status);
    }
    
    public static CustomerResponseEntity.BodyBuilder ok() {
        return status(HttpStatus.OK);
    }
    
    public static <T> CustomerResponseEntity<T> ok(T body) {
        CustomerResponseEntity.BodyBuilder builder = ok();
        return builder.body(body);
    }
    
    public static CustomerResponseEntity.BodyBuilder created(URI location) {
        CustomerResponseEntity.BodyBuilder builder = status(HttpStatus.CREATED);
        return (CustomerResponseEntity.BodyBuilder)builder.location(location);
    }
    
    public static CustomerResponseEntity.BodyBuilder accepted() {
        return status(HttpStatus.ACCEPTED);
    }
    
    public static CustomerResponseEntity.HeadersBuilder<?> noContent() {
        return status(HttpStatus.NO_CONTENT);
    }
    
    public static CustomerResponseEntity.BodyBuilder badRequest() {
        return status(HttpStatus.BAD_REQUEST);
    }
    
    public static CustomerResponseEntity.HeadersBuilder<?> notFound() {
        return status(HttpStatus.NOT_FOUND);
    }
    
    public static CustomerResponseEntity.BodyBuilder unprocessableEntity() {
        return status(HttpStatus.UNPROCESSABLE_ENTITY);
    }
    
    private static class DefaultBuilder implements CustomerResponseEntity.BodyBuilder {
        private final Object statusCode;
        private final HttpHeaders headers = new HttpHeaders();
        
        public DefaultBuilder(Object statusCode) {
            this.statusCode = statusCode;
        }
        
        public CustomerResponseEntity.BodyBuilder header(String headerName, String... headerValues) {
            String[] var3 = headerValues;
            int var4 = headerValues.length;
            
            for(int var5 = 0; var5 < var4; ++var5) {
                String headerValue = var3[var5];
                this.headers.add(headerName, headerValue);
            }
            
            return this;
        }
        
        public CustomerResponseEntity.BodyBuilder headers(HttpHeaders headers) {
            if (headers != null) {
                this.headers.putAll(headers);
            }
            
            return this;
        }
        
        public CustomerResponseEntity.BodyBuilder allow(HttpMethod... allowedMethods) {
            this.headers.setAllow(new LinkedHashSet(Arrays.asList(allowedMethods)));
            return this;
        }
        
        public CustomerResponseEntity.BodyBuilder contentLength(long contentLength) {
            this.headers.setContentLength(contentLength);
            return this;
        }
        
        public CustomerResponseEntity.BodyBuilder contentType(MediaType contentType) {
            this.headers.setContentType(contentType);
            return this;
        }
        
        public CustomerResponseEntity.BodyBuilder eTag(String eTag) {
            if (eTag != null) {
                if (!eTag.startsWith("\"") && !eTag.startsWith("W/\"")) {
                    eTag = "\"" + eTag;
                }
                
                if (!eTag.endsWith("\"")) {
                    eTag = eTag + "\"";
                }
            }
            
            this.headers.setETag(eTag);
            return this;
        }
        
        public CustomerResponseEntity.BodyBuilder lastModified(long date) {
            this.headers.setLastModified(date);
            return this;
        }
        
        public CustomerResponseEntity.BodyBuilder location(URI location) {
            this.headers.setLocation(location);
            return this;
        }
        
        public CustomerResponseEntity.BodyBuilder cacheControl(CacheControl cacheControl) {
            String ccValue = cacheControl.getHeaderValue();
            if (ccValue != null) {
                this.headers.setCacheControl(cacheControl.getHeaderValue());
            }
            
            return this;
        }
        
        public CustomerResponseEntity.BodyBuilder varyBy(String... requestHeaders) {
            this.headers.setVary(Arrays.asList(requestHeaders));
            return this;
        }
        
        public <T> CustomerResponseEntity<T> build() {
            return (CustomerResponseEntity<T>) this.body((Object)null);
        }
        
        public <T> CustomerResponseEntity<T> body(T body) {
            return new CustomerResponseEntity(body, this.headers, this.statusCode);
        }
    }
    
    public interface BodyBuilder extends CustomerResponseEntity.HeadersBuilder<CustomerResponseEntity.BodyBuilder> {
        CustomerResponseEntity.BodyBuilder contentLength(long var1);
        
        CustomerResponseEntity.BodyBuilder contentType(MediaType var1);
        
        <T> CustomerResponseEntity<T> body(T var1);
    }
    
    public interface HeadersBuilder<B extends CustomerResponseEntity.HeadersBuilder<B>> {
        B header(String var1, String... var2);
        
        B headers(HttpHeaders var1);
        
        B allow(HttpMethod... var1);
        
        B eTag(String var1);
        
        B lastModified(long var1);
        
        B location(URI var1);
        
        B cacheControl(CacheControl var1);
        
        B varyBy(String... var1);
        
        <T> CustomerResponseEntity<T> build();
    }
}
