package xyz.itwill05.di;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class CollectionBean {
	//값 저장
	private Set<String> nameSet;
	private List<String> nameList;
	//컨트롤러 객체 저장 (엄밀히 말하면, 컨트롤러인터페이스를 상속받은 자식클래스의 객체)
	private Set<Controller> controllerSet; 
	private List<Controller> controllerList;
	
	private Map<String, Controller> controllerMap;
	private Properties controllerProperties;
	
	public Properties getControllerProperties() {
		return controllerProperties;
	}

	public void setControllerProperties(Properties controllerProperties) {
		this.controllerProperties = controllerProperties;
	}

	public Map<String, Controller> getControllerMap() {
		return controllerMap;
	}

	public void setControllerMap(Map<String, Controller> controllerMap) {
		this.controllerMap = controllerMap;
	}

	public CollectionBean() {
		System.out.println("### CollectionBean 클래스의 기본 생성자 호출 ###");
	}

	public Set<String> getNameSet() {
		return nameSet;
	}

	public void setNameSet(Set<String> nameSet) {
		this.nameSet = nameSet;
	}

	public List<String> getNameList() {
		return nameList;
	}

	public void setNameList(List<String> nameList) {
		this.nameList = nameList;
	}

	public Set<Controller> getControllerSet() {
		return controllerSet;
	}

	public void setControllerSet(Set<Controller> controllerSet) {
		this.controllerSet = controllerSet;
	}

	public List<Controller> getControllerList() {
		return controllerList;
	}

	public void setControllerList(List<Controller> controllerList) {
		this.controllerList = controllerList;
	}
	
}
