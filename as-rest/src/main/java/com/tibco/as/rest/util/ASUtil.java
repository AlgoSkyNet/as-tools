package com.tibco.as.rest.util;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tibco.as.rest.service.dto.MemberConfig;
import com.tibco.as.rest.service.dto.MetaspaceInfo;
import com.tibco.as.space.ASCommon;
import com.tibco.as.space.ASException;
import com.tibco.as.space.Member;
import com.tibco.as.space.MemberDef;
import com.tibco.as.space.Metaspace;

public class ASUtil {

	private static Logger logger = LoggerFactory.getLogger(ASUtil.class);
			
	public static Metaspace connectMetaspace (MemberConfig memberConfig) throws ASException {
        MemberDef memberDef = MemberDef.create();
        memberDef.setDiscovery(memberConfig.getDiscovery());
        memberDef.setListen(memberConfig.getListener());
        if(StringUtil.isNotEmpty(memberConfig.getMemberName())) {
        	memberDef.setMemberName(memberConfig.getMemberName());
        }
        return connectMetaspace(memberConfig.getMetaspaceName(), memberDef);		
	}
	
    public static Metaspace connectMetaspace (MetaspaceInfo metaspaceInfo) throws ASException {
        MemberDef memberDef = MemberDef.create();
        memberDef.setDiscovery(metaspaceInfo.getDiscovery());
        memberDef.setListen(metaspaceInfo.getListen());
        if(StringUtil.isNotEmpty(metaspaceInfo.getMemberName())) {
        	memberDef.setMemberName(metaspaceInfo.getMemberName());
        }
        return connectMetaspace(metaspaceInfo.getName(), memberDef);
    }

    public static synchronized Metaspace connectMetaspace (String metaspaceName, MemberDef memberDef) throws ASException {
    	
        Metaspace ms = ASCommon.getMetaspace(metaspaceName);

        if(ms==null){
        	ms = Metaspace.connect(metaspaceName, memberDef);
        }

        Collection<Member> members = ms.getMetaspaceMembers();
        logger.debug("Current metaspace members: ");
        for (Member member : members) {
        	logger.debug("\t" + member.getName() + " as " + member.getManagementRole());
        }

        return ms;
    }
}
