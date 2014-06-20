require "constant.pl";
require "http.pl";

#list metaspace names(GET)
sub getMetaspaces{
	my($responseType)=@_;
	if($responseType eq undef){
		$responseType = 'json';
	}
	get("$host/rest/metaspaces",$responseType);
}

#display metaspace memberDef(GET)
sub getMemberDef{
	my($responseType, $metaspaceName)=@_;
	if($responseType eq undef){
		$responseType = 'json';
	}
	if($metaspaceName eq undef){
		print "metaspaceName is required";
		return "";
	}
	get("$host/rest/metaspaces/$metaspaceName",$responseType);
}

#list metaspace members(GET)
sub getMembers{
	my($responseType, $metaspaceName)=@_;
	if($responseType eq undef){
		$responseType = 'json';
	}
	if($metaspaceName eq undef){
		print "metaspaceName is required";
		return "";
	}
	get("$host/rest/metaspaces/$metaspaceName/members",$responseType);
}

#list space names(GET)
sub getSpaces{
	my($responseType, $metaspaceName)=@_;
	if($responseType eq undef){
		$responseType = 'json';
	}
	if($metaspaceName eq undef){
		print "metaspaceName is required";
		return "";
	}
	get("$host/rest/metaspaces/$metaspaceName/spaces",$responseType);
}

#display spaceDef(GET)
sub getSpaceDef{
	my($responseType, $metaspaceName, $spaceName)=@_;
	if($responseType eq undef){
		$responseType = 'json';
	}
	if($metaspaceName eq undef){
		print "metaspaceName is required";
		return "";
	}
	get("$host/rest/metaspaces/$metaspaceName/spaces/$spaceName/def",$responseType);
}

#list space stats(GET)
sub getSpaceStats{
	my($responseType, $metaspaceName, $spaceName)=@_;
	if($responseType eq undef){
		$responseType = 'json';
	}
	if($metaspaceName eq undef){
		print "metaspaceName is required";
		return "";
	}
	if($spaceName eq undef){
		print "spaceName is required";
		return "";
	}
	get("$host/rest/metaspaces/$metaspaceName/spaces/$spaceName/stats",$responseType);
}

#list space members(GET)
sub getSpaceMembers{
	my($responseType, $metaspaceName, $spaceName)=@_;
	if($responseType eq undef){
		$responseType = 'json';
	}
	if($metaspaceName eq undef){
		print "metaspaceName is required";
		return "";
	}
	if($spaceName eq undef){
		print "spaceName is required";
		return "";
	}
	get("$host/rest/metaspaces/$metaspaceName/spaces/$spaceName/members",$responseType);
}

#create space(POST)
sub createSpace{
	my($responseType, $metaspaceName, $spaceName, $body)=@_;
	if($responseType eq undef){
		$responseType = 'json';
	}
	if($metaspaceName eq undef){
		print "metaspaceName is required";
		return "";
	}
	if($spaceName eq undef){
		print "spaceName is required";
		return "";
	}
	post("$host/rest/metaspaces/$metaspaceName/spaces/$spaceName",$responseType,$body);
}

#alter space(PUT)
sub alterSpace{
	my($responseType, $metaspaceName, $spaceName, $body)=@_;
	if($responseType eq undef){
		$responseType = 'json';
	}
	if($metaspaceName eq undef){
		print "metaspaceName is required";
		return "";
	}
	if($spaceName eq undef){
		print "spaceName is required";
		return "";
	}
	put("$host/rest/metaspaces/$metaspaceName/spaces/$spaceName",$responseType,$body);
}

#drop space(DELETE)
sub dropSpace{
	my($responseType, $metaspaceName, $spaceName)=@_;
	if($responseType eq undef){
		$responseType = 'json';
	}
	if($metaspaceName eq undef){
		print "metaspaceName is required";
		return "";
	}
	if($spaceName eq undef){
		print "spaceName is required";
		return "";
	}
	del("$host/rest/metaspaces/$metaspaceName/spaces/$spaceName",$responseType);
}

#put tuple(POST)
sub putTuple{
	my($responseType, $metaspaceName, $spaceName, $body)=@_;
	if($responseType eq undef){
		$responseType = 'json';
	}
	if($metaspaceName eq undef){
		print "metaspaceName is required";
		return "";
	}
	if($spaceName eq undef){
		print "spaceName is required";
		return "";
	}
	$headers{'compareAndPut'} = 'false';
	post("$host/rest/metaspaces/$metaspaceName/spaces/$spaceName/tuples",$responseType,$body,%header);
}

#put tuples(POST)
sub putTuples{
	my($responseType, $metaspaceName, $spaceName, $body)=@_;
	if($responseType eq undef){
		$responseType = 'json';
	}
	if($metaspaceName eq undef){
		print "metaspaceName is required";
		return "";
	}
	if($spaceName eq undef){
		print "spaceName is required";
		return "";
	}
	$headers{'compareAndPutAll'} = 'false';
	post("$host/rest/metaspaces/$metaspaceName/spaces/$spaceName/tuples/all",$responseType,$body,%header);
}

#compare and put tuple(POST)
sub compareAndPutTuple{
	my($responseType, $metaspaceName, $spaceName, $body)=@_;
	if($responseType eq undef){
		$responseType = 'json';
	}
	if($metaspaceName eq undef){
		print "metaspaceName is required";
		return "";
	}
	if($spaceName eq undef){
		print "spaceName is required";
		return "";
	}
	$headers{'compareAndPut'} = 'true';
	post("$host/rest/metaspaces/$metaspaceName/spaces/$spaceName/tuples",$responseType,$body,%header);
}

#compare and put tuples(POST)
sub compareAndPutTuples{
	my($responseType, $metaspaceName, $spaceName, $body)=@_;
	if($responseType eq undef){
		$responseType = 'json';
	}
	if($metaspaceName eq undef){
		print "metaspaceName is required";
		return "";
	}
	if($spaceName eq undef){
		print "spaceName is required";
		return "";
	}
	$headers{'compareAndPutAll'} = 'true';
	post("$host/rest/metaspaces/$metaspaceName/spaces/$spaceName/tuples/all",$responseType,$body,%header);
}

#get tuple(GET)
sub getTuple{
	my($responseType, $metaspaceName, $spaceName, $tupleId)=@_;
	if($responseType eq undef){
		$responseType = 'json';
	}
	if($metaspaceName eq undef){
		print "metaspaceName is required";
		return "";
	}
	if($spaceName eq undef){
		print "spaceName is required";
		return "";
	}
	get("$host/rest/metaspaces/$metaspaceName/spaces/$spaceName/tuples/$tupleId",$responseType);
}

#take tuple(DELETE)
sub takeTuple{
	my($responseType, $metaspaceName, $spaceName, $body)=@_;
	if($responseType eq undef){
		$responseType = 'json';
	}
	if($metaspaceName eq undef){
		print "metaspaceName is required";
		return "";
	}
	if($spaceName eq undef){
		print "spaceName is required";
		return "";
	}
	$headers{'Content-Type'} = 'application/json';
	$headers{'compareAndTake'} = 'false';
	del("$host/rest/metaspaces/$metaspaceName/spaces/$spaceName/tuples",$responseType,$body,%header);
}

#take tuples(DELETE)
sub takeTuples{
	my($responseType, $metaspaceName, $spaceName, $body)=@_;
	if($responseType eq undef){
		$responseType = 'json';
	}
	if($metaspaceName eq undef){
		print "metaspaceName is required";
		return "";
	}
	if($spaceName eq undef){
		print "spaceName is required";
		return "";
	}
	$headers{'Content-Type'} = 'application/json';
	$headers{'compareAndTakeAll'} = 'false';
	del("$host/rest/metaspaces/$metaspaceName/spaces/$spaceName/tuples/all",$responseType,$body,%header);
}

#compare and take tuple(DELETE)
sub compareAndTakeTuple{
	my($responseType, $metaspaceName, $spaceName, $body)=@_;
	if($responseType eq undef){
		$responseType = 'json';
	}
	if($metaspaceName eq undef){
		print "metaspaceName is required";
		return "";
	}
	if($spaceName eq undef){
		print "spaceName is required";
		return "";
	}
	$headers{'compareAndTake'} = 'true';
	$headers{'Content-Type'} = 'application/json';
	del("$host/rest/metaspaces/$metaspaceName/spaces/$spaceName/tuples",$responseType,$body,%header);
}

#compare and take tuples(DELETE)
sub compareAndTakeTuples{
	my($responseType, $metaspaceName, $spaceName, $body)=@_;
	if($responseType eq undef){
		$responseType = 'json';
	}
	if($metaspaceName eq undef){
		print "metaspaceName is required";
		return "";
	}
	if($spaceName eq undef){
		print "spaceName is required";
		return "";
	}
	$headers{'compareAndTakeAll'} = 'true';
	$headers{'Content-Type'} = 'application/json';
	del("$host/rest/metaspaces/$metaspaceName/spaces/$spaceName/tuples/all",$responseType,$body,%header);
}

#get tuples(GET)
sub getTuples{
	my($responseType, $metaspaceName, $spaceName, $query, $limit)=@_;
	if($responseType eq undef){
		$responseType = 'json';
	}
	if($metaspaceName eq undef){
		print "metaspaceName is required";
		return "";
	}
	if($spaceName eq undef){
		print "spaceName is required";
		return "";
	}

	if($query eq undef){
		$query = "";
	}
	if($limit eq undef){
		$limit = 100;
	}
	get("$host/rest/metaspaces/$metaspaceName/spaces/$spaceName/tuples;query=$query;limit=$limit",$responseType);
}

#remote invoke(POST)
sub remoteInvoke{
	my($responseType, $metaspaceName, $spaceName, $type, $body)=@_;
	if($responseType eq undef){
		$responseType = 'json';
	}
	if($metaspaceName eq undef){
		print "metaspaceName is required";
		return "";
	}
	if($spaceName eq undef){
		print "spaceName is required";
		return "";
	}
	if($type eq undef){
		print "type is required";
		return "";
	}
	if($type eq "key" and $body eq undef){
		print "body is required";
		return "";
	}
	post("$host/rest/metaspaces/$metaspaceName/spaces/$spaceName/remote/$type",$responseType,$body);
}