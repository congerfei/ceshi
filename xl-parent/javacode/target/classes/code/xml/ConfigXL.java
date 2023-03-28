package code.xml;

import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.List;

@Data
@XmlRootElement(name="configuration")
@XmlAccessorType(XmlAccessType.FIELD)
public class ConfigXL {

    @XmlAttribute(name = "id")//这个是跟着property的属性
    String id;

    @XmlElement(name = "property")
    List<Property> propertys;

}
