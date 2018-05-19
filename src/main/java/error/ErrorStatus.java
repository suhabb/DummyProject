package error;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ErrorStatus {
    CON_ERROR_PROXY {
        @Override
        String getValue() {
            return "con.error.proxy";
        }
    },
    RESP_ERROR_PROXY {
        @Override
        String getValue() {
            return "resp.error.proxy";
        }
    },
    CON_ERROR_DB {
        @Override
        String getValue() {
            return "con.error.db";
        }
    },
    RESP_ERROR_DB {
        @Override
        String getValue() {
            return "resp.error.db";
        }
    },
    RESP_ERROR_GCL_MS {
        @Override
        String getValue() {
            return "resp.error.gcl.ms";
        }
    },
    UNKNOWN_ERROR {
        @Override
        String getValue() {
            return "unknown.error";
        }
    }
    ;

    @JsonValue
    abstract String getValue();
}
