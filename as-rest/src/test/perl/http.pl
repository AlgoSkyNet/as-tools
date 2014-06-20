use LWP::UserAgent;;  
use HTTP::Request;  
use HTTP::Response;  
use HTTP::Request::Common;  

$agent=new LWP::UserAgent;  

sub httpRequest{
	my($url, $method, $body, %header)=@_;  
	if($method eq "get"){
		$request=GET($url);
	}elsif($method eq "post"){		
		$request=POST($url);
		$request->content($body);
	}elsif($method eq "put"){
		$request=PUT($url);
		$request->content($body);
	}elsif($method eq "delete"){
		$request=HTTP::Request->new(DELETE => $url);
		$request->content($body);
	}

	$request->header(%header);  
	  
	$response=$agent->request($request);  
	if ($response->is_success) {
		return $response->content;
	}elsif($response->code==204){
		return "";
	}else{
		print $response->status_line,"\n";  
	}
}

sub get{
	my($url, $responseType)=@_;
	if($responseType eq "xml"){
		return httpRequest($url, 'get', "", "Accept"=>"application/xml");
	}else{
		return httpRequest($url, 'get', "", "Accept"=>"application/json");
	}
}

sub post{
	my($url, $responseType, $body, %header)=@_;
	if($responseType eq "xml"){
		$headers{'Accept'} = 'application/xml';
	}else{
		$headers{'Accept'} = 'application/json';
	}
	$headers{'Content-Type'} = 'application/json';
	return httpRequest($url, 'post', $body, %headers);
}

sub put{
	my($url, $responseType, $body)=@_;
	if($responseType eq "xml"){
		$headers{'Accept'} = 'application/xml';
	}else{
		$headers{'Accept'} = 'application/json';
	}
	$headers{'Content-Type'} = 'application/json';
	return httpRequest($url, 'put', $body, %headers);
}

sub del{
	my($url, $responseType, $body, %header)=@_;
	if($responseType eq "xml"){
		$headers{'Accept'} = 'application/xml';
	}else{
		$headers{'Accept'} = 'application/json';
	}	
	return httpRequest($url, 'delete', $body, %headers);
}