package top.yigege.domain;

/**
 * @ClassName: MessageType
 * @Description:TODO
 * @author: yigege
 * @date: 2019年03月29日 22:13
 */
public class MessageType {

    /**消息类型*/
    private Long messageTypeValue;

    /**消息类型描述*/
    private String messageTypeDescription;

    public Long getMessageTypeValue() {
        return messageTypeValue;
    }

    public void setMessageTypeValue(Long messageTypeValue) {
        this.messageTypeValue = messageTypeValue;
    }

    public String getMessageTypeDescription() {
        return messageTypeDescription;
    }

    public void setMessageTypeDescription(String messageTypeDescription) {
        this.messageTypeDescription = messageTypeDescription;
    }

    public MessageType(Long messageTypeValue, String messageTypeDescription) {
        this.messageTypeValue = messageTypeValue;
        this.messageTypeDescription = messageTypeDescription;
    }
}
