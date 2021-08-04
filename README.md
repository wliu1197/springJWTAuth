# Step 1 POST call to create JWT
Basic auth used in this call wen:comein22 <br />
http://localhost:9091/rest-api/getAuthJWT <br />

## Example data
{<br />
 "clientId":"wen"<br />
}<br />

# Step 2 use JWT to call hello function
http://localhost:9091/rest-api/hello <br />
Authorization : Bearer jwt
