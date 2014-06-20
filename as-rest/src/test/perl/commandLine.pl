require "rest.pl";
$responseType="json";
$metaspaceName = "myms";

while(1){
	printMessage();
	chomp($input = <STDIN>);
	
	if($input eq "0"){
		print "please input responseType(json/xml):";
		chomp($responseType = <STDIN>);
		if($responseType ne "xml"){
			$responseType = "json";
		}
		print "****************************************\n";
		print "set responseType to $responseType\n";
		print "****************************************\n";
	}elsif($input eq "1"){
		print "please input metaspaceName:";
		chomp($metaspaceName = <STDIN>);

		print "****************************************\n";
		print "set metaspaceName to $metaspaceName\n";
		print "****************************************\n";

	}elsif($input eq "2"){
		print "****************************************\n";
		print getMetaspaces($responseType);
		print "\n";
		print "****************************************\n";
	}elsif($input eq "3"){
		print "****************************************\n";
		print getMemberDef($responseType,$metaspaceName);
		print "\n";
		print "****************************************\n";
	}elsif($input eq "4"){
		print "****************************************\n";
		print getMembers($responseType,$metaspaceName);
		print "\n";
		print "****************************************\n";
	}elsif($input eq "5"){
		print "****************************************\n";
		print getSpaces($responseType,$metaspaceName);
		print "\n";
		print "****************************************\n";
	}elsif($input eq "6"){
		print "please input spaceName:";
		chomp($spaceName = <STDIN>);
		print "****************************************\n";
		print getSpaceDef($responseType,$metaspaceName,$spaceName);
		print "\n";
		print "****************************************\n";
	}elsif($input eq "7"){
		print "please input spaceName:";
		chomp($spaceName = <STDIN>);
		print "****************************************\n";
		print getSpaceStats($responseType,$metaspaceName,$spaceName);
		print "\n";
		print "****************************************\n";
	}elsif($input eq "8"){
		print "please input spaceName:";
		chomp($spaceName = <STDIN>);
		print "****************************************\n";
		print getSpaceMembers($responseType,$metaspaceName,$spaceName);
		print "\n";
		print "****************************************\n";
	}elsif($input eq "9"){
		print "please input spaceName:";
		chomp($spaceName = <STDIN>);
		$createSpaceBody = '{"name":"'.$spaceName.'","fields":[{"name":"key","type":"string"},{"name":"value","type":"string","nullable":false},'.
						   '{"name":"test","type":"integer","nullable":true}],"keyFieldNames":["key"],"indexes":[{"name":"aaa","fieldNames":["test"]}],'.
						   '"replicationCount":1}';
		createSpace($responseType,$metaspaceName,$spaceName,$createSpaceBody);
	}elsif($input eq "10"){
		print "please input spaceName:";
		chomp($spaceName = <STDIN>);
		$alterSpaceBody = '{"fields":[{"name":"alertTest","type":"string"},'.
						  '{"name":"alertTest1","type":"string"}],'.
						  '"indexes":[{"name":"ccc","fieldNames":["alertTest", "alertTest1"],"indexType":"hash"}]}';
		alterSpace($responseType,$metaspaceName,$spaceName,$alterSpaceBody);
	}elsif($input eq "11"){
		print "please input spaceName:";
		chomp($spaceName = <STDIN>);
		dropSpace($responseType,$metaspaceName,$spaceName);
	}elsif($input eq "12"){
		print "please input spaceName:";
		chomp($spaceName = <STDIN>);
		print "please input tuple key:";
		chomp($key = <STDIN>);
		print "please input tuple value:";
		chomp($value = <STDIN>);
		print "****************************************\n";
		print putTuple($responseType,$metaspaceName,$spaceName,"{\"key\":\"$key\",\"value\":\"$value\"}");
		#print putTuple($responseType,$metaspaceName,$spaceName,"{\"key\":\"$key\",\"value\":\"$value\",\"putOptions\":{\"forget\":false,\"lock\":false,\"lockWait\":-2,\"ttl\":-2,\"route\":false,\"unlock\":false}}");
		print "\n";
		print "****************************************\n";
	}elsif($input eq "13"){
		print "please input spaceName:";
		chomp($spaceName = <STDIN>);
		print "please input tuple key:";
		chomp($key = <STDIN>);
		print "please input tuple value:";
		chomp($value = <STDIN>);
		print "please input tuple key1:";
		chomp($key1 = <STDIN>);
		print "please input tuple value1:";
		chomp($value1 = <STDIN>);
		print "****************************************\n";
		print putTuples($responseType,$metaspaceName,$spaceName,"[{\"key\":\"$key\",\"value\":\"$value\"},{\"key\":\"$key1\",\"value\":\"$value1\"}]");
		#print putTuples($responseType,$metaspaceName,$spaceName,"[{\"key\":\"$key\",\"value\":\"$value\",\"putOptions\":{\"forget\":false,\"lock\":false,\"lockWait\":100,\"ttl\":-2,\"route\":false,\"unlock\":false}},{\"key\":\"$key1\",\"value\":\"$value1\"}]");
		print "\n";
		print "****************************************\n";
	}elsif($input eq "14"){
		print "please input spaceName:";
		chomp($spaceName = <STDIN>);
		print "please input tuple key:";
		chomp($key = <STDIN>);
		print "please input tuple value:";
		chomp($value = <STDIN>);
		print "please input old tuple key:";
		chomp($oldKey = <STDIN>);
		print "please input old tuple value:";
		chomp($oldValue = <STDIN>);
		print "****************************************\n";
		print compareAndPutTuple($responseType,$metaspaceName,$spaceName,"{\"key\":\"$key\",\"value\":\"$value\",\"oldTuple\":{\"key\":\"$oldKey\",\"value\":\"$oldValue\"}}");
		#print compareAndPutTuple($responseType,$metaspaceName,$spaceName,"{\"key\":\"$key\",\"value\":\"$value\",\"oldTuple\":{\"key\":\"$oldKey\",\"value\":\"$oldValue\"},\"putOptions\":{\"forget\":false,\"lock\":false,\"lockWait\":-2,\"ttl\":-2,\"route\":true,\"unlock\":false}}");
		print "\n";
		print "****************************************\n";
	}elsif($input eq "15"){
		print "please input spaceName:";
		chomp($spaceName = <STDIN>);
		print "please input tuple key:";
		chomp($key = <STDIN>);
		print "please input tuple value:";
		chomp($value = <STDIN>);
		print "please input old tuple key:";
		chomp($oldKey = <STDIN>);
		print "please input old tuple value:";
		chomp($oldValue = <STDIN>);
		print "please input tuple key1:";
		chomp($key1 = <STDIN>);
		print "please input tuple value1:";
		chomp($value1 = <STDIN>);
		print "please input old tuple key1:";
		chomp($oldKey1 = <STDIN>);
		print "please input old tuple value1:";
		chomp($oldValue1 = <STDIN>);
		print "****************************************\n";
		print compareAndPutTuples($responseType,$metaspaceName,$spaceName,"[{\"key\":\"$key\",\"value\":\"$value\",\"oldTuple\":{\"key\":\"$oldKey\",\"value\":\"$oldValue\"}},{\"key\":\"$key1\",\"value\":\"$value1\",\"oldTuple\":{\"key\":\"$oldKey1\",\"value\":\"$oldValue1\"}}]");
		#print compareAndPutTuples($responseType,$metaspaceName,$spaceName,"[{\"key\":\"$key\",\"value\":\"$value\",\"oldTuple\":{\"key\":\"$oldKey\",\"value\":\"$oldValue\"},\"putOptions\":{\"forget\":false,\"lock\":false,\"lockWait\":101,\"ttl\":-2,\"route\":true,\"unlock\":false}},{\"key\":\"$key1\",\"value\":\"$value1\",\"oldTuple\":{\"key\":\"$oldKey1\",\"value\":\"$oldValue1\"}}]");
		print "\n";
		print "****************************************\n";
	}elsif($input eq "16"){
		print "please input spaceName:";
		chomp($spaceName = <STDIN>);
		print "please input tuple key:";
		chomp($key = <STDIN>);
		print "****************************************\n";
		print getTuple($responseType,$metaspaceName,$spaceName,$key);
		print "\n";
		print "****************************************\n";
	}elsif($input eq "17"){
		print "please input spaceName:";
		chomp($spaceName = <STDIN>);
		print "please input tuple key:";
		chomp($key = <STDIN>);
		print "****************************************\n";		
		print takeTuple($responseType,$metaspaceName,$spaceName,"{\"key\":\"$key\"}");
		#print takeTuple($responseType,$metaspaceName,$spaceName,"{\"key\":\"$key\", \"takeOptions\":{\"forget\":false,\"lock\":false,\"lockWait\":-2,\"route\":true,\"unlock\":false}}");
		print "\n";
		print "****************************************\n";
	}elsif($input eq "18"){
		print "please input spaceName:";
		chomp($spaceName = <STDIN>);
		print "please input tuple key:";
		chomp($key = <STDIN>);
		print "please input tuple key1:";
		chomp($key1 = <STDIN>);
		print "****************************************\n";		
		print takeTuples($responseType,$metaspaceName,$spaceName,"{\"tuples\":[{\"key\":\"$key\"},{\"key\":\"$key1\"}]}");
		#print takeTuples($responseType,$metaspaceName,$spaceName,"{\"tuples\":[{\"key\":\"$key\"},{\"key\":\"$key1\"}], \"takeOptions\":{\"forget\":false,\"lock\":false,\"lockWait\":-2,\"route\":true,\"unlock\":false}}");
		print "\n";
		print "****************************************\n";
	}elsif($input eq "19"){
		print "please input spaceName:";
		chomp($spaceName = <STDIN>);
		print "please input tuple key:";
		chomp($key = <STDIN>);
		print "please input tuple value:";
		chomp($value = <STDIN>);
		print "****************************************\n";
		print compareAndTakeTuple($responseType,$metaspaceName,$spaceName,"{\"key\":\"$key\",\"value\":\"$value\"}");
		#print compareAndTakeTuple($responseType,$metaspaceName,$spaceName,"{\"key\":\"$key\",\"value\":\"$value\",\"takeOptions\":{\"forget\":false,\"lock\":false,\"lockWait\":-2,\"route\":true,\"unlock\":false}}");
		print "\n";
		print "****************************************\n";
	}elsif($input eq "20"){
		print "please input spaceName:";
		chomp($spaceName = <STDIN>);
		print "please input tuple key:";
		chomp($key = <STDIN>);
		print "please input tuple value:";
		chomp($value = <STDIN>);
		print "please input tuple key1:";
		chomp($key1 = <STDIN>);
		print "please input tuple value1:";
		chomp($value1 = <STDIN>);
		print "****************************************\n";
		#print compareAndTakeTuples($responseType,$metaspaceName,$spaceName,"{\"tuples\":[{\"key\":\"$key\",\"value\":\"$value\"},{\"key\":\"$key1\",\"value\":\"$value1\"}]}");
		print compareAndTakeTuples($responseType,$metaspaceName,$spaceName,"{\"tuples\":[{\"key\":\"$key\",\"value\":\"$value\"},{\"key\":\"$key1\",\"value\":\"$value1\"}],\"takeOptions\":{\"forget\":false,\"lock\":false,\"lockWait\":-2,\"route\":true,\"unlock\":false}}");
		print "\n";
		print "****************************************\n";
	}elsif($input eq "21"){
		print "please input spaceName:";
		chomp($spaceName = <STDIN>);
		print "please input tuple query:";
		chomp($query = <STDIN>);
		print "please input tuple limit:";
		chomp($limit = <STDIN>);
		print "****************************************\n";
		print getTuples($responseType,$metaspaceName,,$spaceName,$query,$limit);
		print "\n";
		print "****************************************\n";
	}elsif($input eq "22"){
		print "please input spaceName:";
		chomp($spaceName = <STDIN>);
		print "please input remote invoke type\n(key/self/seeders/leeches/members/remote):";
		chomp($type = <STDIN>);
		print "please input className:";
		chomp($className = <STDIN>);
		
		if($type eq "key"){
			print "please input keyName:";
			chomp($keyName = <STDIN>);
			print "please input keyValue:";
			chomp($keyValue = <STDIN>);
			print "please input keyType(boolean/char/datetime/double/float/integer/long/short/string):";
			chomp($keyType = <STDIN>);
			$className = "com.tibco.as.rest.test.remote.ASInvocable";
		}else{
			$className = "com.tibco.as.rest.test.remote.ASInvocableMember";
		}

		$body ="{\"key\":{\"key\":\"$keyName\",\"value\":\"$keyValue\",\"type\":\"$keyType\"},\"className\":\"$className\",".
			   "\"context\":[{\"key\":\"value\",\"value\":\"my id\",\"type\":\"string\"},".
			   "{\"key\":\"time\",\"value\":\"2014-04-21 09:36:28.026\",\"type\":\"datetime\"}],\"timeout\":20000}";
		print "****************************************\n";
		print remoteInvoke($responseType,$metaspaceName,,$spaceName,$type,$body);
		print "\n";
		print "****************************************\n";
	}elsif($input eq "23"){
		exit
	}
}

sub printMessage{
	print "0.set responseType($responseType) 1.set metaspaceName($metaspaceName)\n2.getMetaspaces         3.getMemberDef".
		"         4.getMembers\n5.getSpaces             6.getSpaceDef          7.getSpaceStats\n8.getSpaceMembers       9.createSpace          10.alterSpace\n".
		"11.dropSpace            12.putTuple            13.putTuples\n14.compareAndPutTuple   15.compareAndPutTuples 16.getTuple\n".
		"17.takeTuple            18.takeTuples          19.compareAndTakeTuple\n20.compareAndTakeTuples".
		" 21.getTuples           22.remoteInvoke\n23.quit\nplease input number:";
}