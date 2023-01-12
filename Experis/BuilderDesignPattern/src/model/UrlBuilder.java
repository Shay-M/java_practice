package model;

public final class UrlBuilder {
    private final String protocol;
    private final String hostname;
    private final String port;
    private final String pathname;

    public UrlBuilder(final Builder builder) {
        this.protocol = builder.protocol;
        this.hostname = builder.hostname;
        this.port = builder.port;
        this.pathname = builder.pathname;
    }
    //in class
    public static class Builder {

        private String protocol;
        private String hostname;
        private String port;
        private String pathname;

        public UrlBuilder build() {
            return new UrlBuilder(this);
        }

        public final Builder protocol(String protocol) {
            this.protocol = protocol;
            return this;
        }

        public final Builder hostname(String hostname) {
            this.hostname = hostname;
            return this;
        }

        public final Builder port(String port) {
            this.port = port;
            return this;
        }

        public final Builder pathname(String pathname) {
            this.pathname = pathname;
            return this;
        }
    }

}

