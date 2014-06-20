package com.tibco.as.rest.service.dto;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "members")
public class MembersInfo extends BaseDto{

    @XmlElement(name="member")
	private List<Member> members =  new ArrayList<Member>();
	

	public List<Member> getMembers() {
		return members;
	}


	public void setMembers(List<Member> members) {
		this.members = members;
	}

	public static Member createMember(){
		return new Member();
	}
	
	public static class Member {

		private String id;

		private String name;

		private String managementRole;

		private String address;

		private Calendar joinTime;
		
		private int port;
		
		public Member(){
			
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getManagementRole() {
			return managementRole;
		}

		public void setManagementRole(String managementRole) {
			this.managementRole = managementRole;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public Calendar getJoinTime() {
			return joinTime;
		}

		public void setJoinTime(Calendar joinTime) {
			this.joinTime = joinTime;
		}

		public int getPort() {
			return port;
		}

		public void setPort(int port) {
			this.port = port;
		}
	}
}
