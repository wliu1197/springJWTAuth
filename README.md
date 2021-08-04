Step 1 POST call to create JWT
Basic auth used in this call wen:comein22
http://localhost:9091/rest-api/getAuthJWT
Example data
{
 "clientId":"wen"
  
}

Step 2 use JWT to call hello function
http://localhost:9091/rest-api/hello
Authorization : Bearer jwt