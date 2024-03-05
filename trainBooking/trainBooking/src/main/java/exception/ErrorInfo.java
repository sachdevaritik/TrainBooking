package exception;

import java.time.LocalDateTime;

public class ErrorInfo {
    private String errMsg;
    private Integer errCode;
    private LocalDateTime errTimestamp;

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public Integer getErrCode() {
        return errCode;
    }

    public void setErrCode(Integer errCode) {
        this.errCode = errCode;
    }

    public LocalDateTime getErrTimestamp() {
        return errTimestamp;
    }

    public void setErrTimestamp(LocalDateTime errTimestamp) {
        this.errTimestamp = errTimestamp;
    }

    public ErrorInfo(String errMsg, Integer errCode, LocalDateTime errTimestamp) {
        super();
        this.errMsg = errMsg;
        this.errCode = errCode;
        this.errTimestamp = errTimestamp;
    }

    public ErrorInfo() {
        super();
    }
    @Override
    public String toString(){
        return "ErrorInfo [ errMsg="+ errMsg + ", errTimestamp=" + errTimestamp + ", errcode="+ errCode + "]";
    }
}
