# Simple Spring Security
###### _spring security OAuth2 with autoconfigure_

#### for user
* curl -X POST --user client:123 localhost:8080/oauth/token -d 'grant_type=password&username=user&password=user' -H "Accept: application/json"
#### for admin
* curl -X POST --user client:123 localhost:8080/oauth/token -d 'grant_type=password&username=admin&password=admin' -H "Accept: application/json"

###### _now you have a token_
#### endpoints

###### _free_
- GET
- localhost:8080/v1/hello

###### _user_
- GET
- localhost:8080/v1/user

###### _admin_
- GET
- localhost:8080/v1/admin

###### _token revoker_
- DELETE
- localhost:8080/v1/logout

- ###### curl -X$METHOD $ENDPOINT_URL -H "Authorization: Bearer $VERY_LONG_RETRIEVED_TOKEN"
