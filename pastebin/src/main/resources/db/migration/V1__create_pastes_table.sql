CREATE TABLE pastes (
                        id          BIGSERIAL PRIMARY KEY,
                        hash        VARCHAR(10)  NOT NULL UNIQUE,
                        s3_key      VARCHAR(255) NOT NULL,
                        title       VARCHAR(255),
                        expires_at  TIMESTAMP WITH TIME ZONE NOT NULL,
                        created_at  TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT now(),
                        is_public   BOOLEAN NOT NULL DEFAULT true
);

CREATE INDEX idx_pastes_hash       ON pastes(hash);
CREATE INDEX idx_pastes_expires_at ON pastes(expires_at);