package com.cross.merchants.utils.weixin.sdk;

/**
 * @Auther: 钟棋
 * @Date: 2018/10/31 12:32
 * @Email: 2020131266@qq.com
 * @Describe:
 */
/**
 * 域名管理，实现主备域名自动切换
 */
public abstract interface IWXPayDomain {

    abstract void report(final String domain, long elapsedTimeMillis, final Exception ex);

    abstract DomainInfo getDomain(final WXPayConfig config);

    static class DomainInfo{
        public String domain;       //域名
        public boolean primaryDomain;     //该域名是否为主域名。例如:api.mch.weixin.qq.com为主域名
        public DomainInfo(String domain, boolean primaryDomain) {
            this.domain = domain;
            this.primaryDomain = primaryDomain;
        }

        @Override
        public String toString() {
            return "DomainInfo{" +
                    "domain='" + domain + '\'' +
                    ", primaryDomain=" + primaryDomain +
                    '}';
        }
    }
}
