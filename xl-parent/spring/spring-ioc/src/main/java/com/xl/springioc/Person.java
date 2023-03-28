package com.xl.springioc;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * Author: xl
 * date :2020/11/25 15:58
 * description:
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
public class Person {

    private Long pid;
    private String pname;
    private Student students;
    private List lists;
    private Set sets;
    private Map maps;
    private Properties properties;

    public Long getPid() {
        return pid;
    }
    public void setPid(Long pid) {
        this.pid = pid;
    }
    public String getPname() {
        return pname;
    }
    public void setPname(String pname) {
        this.pname = pname;
    }
    public Student getStudents() {
        return students;
    }
    public void setStudents(Student students) {
        this.students = students;
    }
    public List getLists() {
        return lists;
    }
    public void setLists(List lists) {
        this.lists = lists;
    }
    public Set getSets() {
        return sets;
    }
    public void setSets(Set sets) {
        this.sets = sets;
    }
    public Map getMaps() {
        return maps;
    }
    public void setMaps(Map maps) {
        this.maps = maps;
    }
    public Properties getProperties() {
        return properties;
    }
    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "Person{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", students=" + students +
                ", lists=" + lists +
                ", sets=" + sets +
                ", maps=" + maps +
                ", properties=" + properties +
                '}';
    }
}
