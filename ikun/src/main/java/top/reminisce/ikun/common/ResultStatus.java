package top.reminisce.ikun.common;

/**
 * @author BlueSkyCarry
 */
public enum ResultStatus {
    /**
     * 处理过程发生错误，包括业务逻辑错误或服务器异常
     */
    FAIL(0),
    /**
     * 成功的一次处理。
     */
    SUCCESS(1),
    /**
     * 其他。例如此次理需要由客户端进一步确认
     */
    OTHER(2);

    private final int value;

    ResultStatus(int value) {
        this.value = value;
    }

    public static ResultStatus valueOf(int status) {
        ResultStatus[] var1 = values();
        for (ResultStatus rs : var1) {
            if (rs.value == status) {
                return rs;
            }
        }
        return null;
    }

    public int value() {
        return this.value;
    }
}
