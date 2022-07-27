package com.cdackolkata;  
  
import java.util.Set;  
  
import java.util.Map;  

public class Question {  
private int id;  
private String name,username;  
private Set<String> answers;  
  
public Question() {}  
public Question(String name, String username, Set<String> answers) {  
    super();  
    this.name = name;  
    this.username = username;  
    this.answers = answers;  
}  
public int getId() {  
    return id;  
}  
public void setId(int id) {  
    this.id = id;  
}  
public String getName() {  
    return name;  
}  
public void setName(String name) {  
    this.name = name;  
}  
public String getUsername() {  
    return username;  
}  
public void setUsername(String username) {  
    this.username = username;  
}  
public Set<String> getAnswers() {  
    return answers;  
}  
public void setAnswers(Set<String> answers) {  
    this.answers = answers;  
}  
}  
