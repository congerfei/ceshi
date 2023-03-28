package code.xml;

import lombok.Data;

import javax.xml.bind.annotation.*;


@XmlRootElement(name ="property")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class Property {

    @XmlAttribute(name = "id")//这个是跟着property的属性
    String id;

    @XmlElement(name="name")
    String name;

    @XmlElement(name="value")
    String value;

}
