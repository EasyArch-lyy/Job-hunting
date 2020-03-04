package Design_pattern.Responsibility_chain;

import java.util.Date;

//编写请求对象。这里我们假如处理告警信息
public class Alarm {

    //告警id
    private Integer id;
    //告警事件总数：这条告警是有几条事件合并而成的
    private Integer eventNumber;
    //告警名称
    private String alarmName;
    //告警发生位置
    private String alarmAddress;
    //是否确认告警 0:确认 1：未确认
    private Integer alarmAck;
    //告警等级 1：可疑 2：高危 3：严重 4：紧急
    private Integer alarmLevel;
    //告警类型 1:停电 2：硬件 3：软件
    private Integer alarmType;
    //告警发送时间
    private Date date;
    private String desc;

    public Alarm() {
    }

    public Alarm(Integer id, Integer eventNumber, String alarmName, String alarmAddress, Integer alarmAck,
                 Integer alarmLevel, Integer alarmType, Date date, String desc) {
        this.id = id;
        this.eventNumber = eventNumber;
        this.alarmName = alarmName;
        this.alarmAddress = alarmAddress;
        this.alarmAck = alarmAck;
        this.alarmLevel = alarmLevel;
        this.alarmType = alarmType;
        this.date = date;
        this.desc = desc;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getEventNumber()
    {
        return eventNumber;
    }

    public void setEventNumber(Integer eventNumber)
    {
        this.eventNumber = eventNumber;
    }

    public String getAlarmName()
    {
        return alarmName;
    }

    public void setAlarmName(String alarmName)
    {
        this.alarmName = alarmName;
    }

    public String getAlarmAddress()
    {
        return alarmAddress;
    }

    public void setAlarmAddress(String alarmAddress)
    {
        this.alarmAddress = alarmAddress;
    }

    public Integer getAlarmAck()
    {
        return alarmAck;
    }

    public void setAlarmAck(Integer alarmAck)
    {
        this.alarmAck = alarmAck;
    }

    public Integer getAlarmLevel()
    {
        return alarmLevel;
    }

    public void setAlarmLevel(Integer alarmLevel)
    {
        this.alarmLevel = alarmLevel;
    }

    public Integer getAlarmType()
    {
        return alarmType;
    }

    public void setAlarmType(Integer alarmType)
    {
        this.alarmType = alarmType;
    }

    public Date getDate()
    {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

    public String getDesc()
    {
        return desc;
    }

    public void setDesc(String desc)
    {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Alarm{" +
               "id=" + id +
               ", eventNumber=" + eventNumber +
               ", alarmName='" + alarmName + '\'' +
               ", alarmAddress='" + alarmAddress + '\'' +
               ", alarmAck=" + alarmAck +
               ", alarmLevel=" + alarmLevel +
               ", alarmType=" + alarmType +
               ", date=" + date +
               ", desc='" + desc + '\'' +
               '}';
    }
}