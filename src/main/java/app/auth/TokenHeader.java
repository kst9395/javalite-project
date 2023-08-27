package app.auth;

public class TokenHeader {

    private String typ;

    private String alg;

    public static final TokenHeader RS256_HEADER = TokenHeader.builder().withAlgorithm("RS256").withType("jwt").build();

    public static TokenHeaderBuilder builder() {
        return new TokenHeaderBuilder();
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public String getAlg() {
        return alg;
    }

    public void setAlg(String alg) {
        this.alg = alg;
    }

    public static class TokenHeaderBuilder {
        private String type;
        private String alg;

        public TokenHeaderBuilder withType(String type) {
            this.type = type;
            return this;
        }

        public TokenHeaderBuilder withAlgorithm(String alg) {
            this.alg = alg;
            return this;
        }

        public TokenHeader build() {
            TokenHeader header = new TokenHeader();
            header.setAlg(alg);
            header.setTyp(type);
            return header;
        }


    }

}
